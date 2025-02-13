package dev.java10x.CadastroDeNinjas.Ninjas;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Annotation RestController, significa que estamos lidando com um controlador REST.
* Annotation RequestMapping, significa que iremos mapear as rotas fornecidas nessa classe.
* */
@Tag(name = "Ninjas", description = "Gerenciamento de ninjas")
@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @Operation(summary = "Lista todos os ninjas", description = "Retorna uma lista com todos os ninjas cadastrados.")
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarTodosOsNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @Operation(summary = "Busca um ninja por ID", description = "Retorna um ninja específico baseado no ID fornecido.")
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarPorId(
            @Parameter(description = "ID do ninja a ser buscado", example = "1")
            @PathVariable Long id) {
        NinjaDTO ninja = ninjaService.buscarPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o id: '" + id + "' não existe nos registros");
    }

    @Operation(summary = "Cria um novo ninja", description = "Cria um novo ninja com os dados fornecidos.")
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja: " + ninja.getNome() + " criado com sucesso.");
    }

    @Operation(summary = "Atualiza um ninja", description = "Altera os dados de um ninja existente baseado no ID informado.")
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "ID do ninja a ser atualizado", example = "1")
            @PathVariable Long id,
            @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.buscarPorId(id) != null) {
            NinjaDTO ninjaNovo = ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok(ninjaNovo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: '" + id + "' não existe nos registros");
        }
    }

    @Operation(summary = "Deleta um ninja", description = "Remove um ninja dos registros baseado no ID informado.")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "ID do ninja a ser deletado", example = "1")
            @PathVariable Long id) {
        if (ninjaService.buscarPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id '" + id + "' não existe nos registros");
        }
    }
}

