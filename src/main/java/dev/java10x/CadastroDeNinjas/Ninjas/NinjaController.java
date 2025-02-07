package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

/*
* Annotation RestController, significa que estamos lidando com um controlador REST.
* Annotation RequestMapping, significa que iremos mapear as rotas fornecidas nessa classe.
* */
@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    //GetMapping retorna um valor fornecido na função
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Todos os ninjas";
    }

    @PostMapping("/listar")
    public String criarNinja(){
        return "Criado com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarNinjaPorId(){
        return "Alterado com sucesso";
    }

    @DeleteMapping("/deletar")
    public String removerNinjaPorId(){
        return "Removido com sucesso";
    }

}
