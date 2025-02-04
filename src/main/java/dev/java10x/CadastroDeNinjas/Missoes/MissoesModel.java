package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes" )
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

    public MissoesModel() {
    }

    public MissoesModel(String nome, RankMissao dificuldade, List<NinjaModel> ninja) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.ninja = ninja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RankMissao getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(RankMissao dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<NinjaModel> getNinja() {
        return ninja;
    }

    public void setNinja(List<NinjaModel> ninja) {
        this.ninja = ninja;
    }
}
