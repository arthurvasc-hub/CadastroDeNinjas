package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private RankMissao dificuldade;

     /*
     * @OneToMany = One (nome da classe que vc ta trabalhando agora) can have many (nome do que vc quer relacionar)
     * One mission can have many ninjas (Uma missão pode ter vários ninjas)
     * */
    @OneToMany(mappedBy = "missoes") // mapeando a tabela em que esta se relacionando
    private List<NinjaModel> ninja;
}
