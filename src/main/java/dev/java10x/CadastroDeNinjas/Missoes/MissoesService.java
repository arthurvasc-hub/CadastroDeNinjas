package dev.java10x.CadastroDeNinjas.Missoes;

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

}
