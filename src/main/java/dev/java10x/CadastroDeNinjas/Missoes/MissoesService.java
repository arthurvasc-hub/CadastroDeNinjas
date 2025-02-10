package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarTodasAsMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel buscarPorId(Long id){
        Optional<MissoesModel> missoes = missoesRepository.findById(id);
        return missoes.orElse(null);
    }

    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada){
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            missoesRepository.save(missaoAtualizada);
        }
        return null;
    }

}
