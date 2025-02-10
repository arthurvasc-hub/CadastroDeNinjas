package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Annotation RestController, significa que estamos lidando com um controlador REST.
* Annotation RequestMapping, significa que iremos mapear as rotas fornecidas nessa classe.
* */
@RestController
@RequestMapping("/ninjas")
public class NinjaController {


   private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.listarTodosOsNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel mostrarPorId(@PathVariable Long id){
        return ninjaService.buscarPorId(id);
    }

    @PostMapping("/criar")
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
