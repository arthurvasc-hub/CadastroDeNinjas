package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarTodasAsMissoes(){
        return "Lista de missoes";
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
