package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Annotation RestController, significa que estamos lidando com um controlador REST.
* Annotation RequestMapping, significa que iremos mapear as rotas fornecidas nessa classe.
* */
@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
   private NinjaService ninjaService;



    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosOsNinjas(){
        return ninjaService.listarTodosOsNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO mostrarPorId(@PathVariable Long id){
        return ninjaService.buscarPorId(id);
    }

    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }



}
