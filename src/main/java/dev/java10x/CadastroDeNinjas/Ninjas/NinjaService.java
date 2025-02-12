package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private final NinjaDTO ninjaDTO;
    private NinjaRepository ninjaRepository;
   private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper, NinjaDTO ninjaDTO) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
        this.ninjaDTO = ninjaDTO;
    }

    public List<NinjaDTO> listarTodosOsNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(NinjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO buscarPorId(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(NinjaMapper::map)
                .orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
    NinjaModel ninja = ninjaMapper.map(ninjaDTO);
    ninja = ninjaRepository.save(ninja);
    return ninjaMapper.map(ninja);
    }

    // Metodo para deletar é VOID
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
