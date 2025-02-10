package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    @Autowired
    MissoesService missoesService;

    @GetMapping("/listar")
    public List<MissoesModel> listarTodasAsMissoes(){
        return missoesService.listarTodasAsMissoes();
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Criado com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissaoPorId(){
        return "Alterado com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissaoPorId(){
        return "Deletado com sucesso";
    }
}
