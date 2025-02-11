package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class MissoesDTO {
    private Long id;
    private String nome;
    private RankMissao dificuldade;
    private List<NinjaModel> ninja;
}
