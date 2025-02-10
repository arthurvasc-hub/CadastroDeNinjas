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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }



}
