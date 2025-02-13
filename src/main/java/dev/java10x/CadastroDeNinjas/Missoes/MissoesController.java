package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarTodasAsMissoes(){
       List<MissoesDTO> missoes = missoesService.listarTodasAsMissoes();
        return ResponseEntity.ok(missoes);
    }
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

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missaoDTO){
        MissoesDTO missao = missoesService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão: " + missao.getNome() + " criada com sucesso");
    }

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
