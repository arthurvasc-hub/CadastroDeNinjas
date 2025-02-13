package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para operações relacionadas a missões.
 */
@RestController
@RequestMapping("/missoes")
@Tag(name = "Missões", description = "Endpoints para gerenciar missões")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    /**
     * Lista todas as missões disponíveis.
     * @return Lista de missões.
     */
    @Operation(summary = "Listar todas as missões", description = "Retorna uma lista com todas as missões cadastradas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de missões retornada com sucesso")
    })
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarTodasAsMissoes(){
        List<MissoesDTO> missoes = missoesService.listarTodasAsMissoes();
        return ResponseEntity.ok(missoes);
    }

    /**
     * Busca uma missão pelo ID.
     * @param id ID da missão.
     * @return Dados da missão ou mensagem de erro.
     */
    @Operation(summary = "Buscar missão por ID", description = "Retorna os detalhes de uma missão específica pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão encontrada"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        MissoesDTO missao = missoesService.buscarPorId(id);
        if(missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o id " + "'" + id + "'" + " não existe nos registros.");
        }
    }

    /**
     * Cria uma nova missão.
     * @param missaoDTO Dados da missão.
     * @return Mensagem de sucesso.
     */
    @Operation(summary = "Criar uma nova missão", description = "Cria e salva uma nova missão no sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso")
    })
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missaoDTO){
        MissoesDTO missao = missoesService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão: " + missao.getNome() + " criada com sucesso");
    }

    /**
     * Atualiza uma missão pelo ID.
     * @param id ID da missão.
     * @param missaoAtualizada Dados atualizados da missão.
     * @return Missão atualizada ou mensagem de erro.
     */
    @Operation(summary = "Atualizar missão por ID", description = "Modifica os dados de uma missão existente pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        if(missoesService.buscarPorId(id) != null) {
            MissoesDTO missao = missoesService.atualizarMissao(id, missaoAtualizada);
            return ResponseEntity.ok(missao);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + "'" + id + "'" + " não encontrada.");
        }
    }

    /**
     * Exclui uma missão pelo ID.
     * @param id ID da missão a ser excluída.
     * @return Mensagem de sucesso ou erro.
     */
    @Operation(summary = "Excluir missão por ID", description = "Remove uma missão existente pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id){
        if(missoesService.buscarPorId(id) != null){
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão deletada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o id: " + "'" + id + "'" + ", não existe nos registros.");
        }
    }
}

