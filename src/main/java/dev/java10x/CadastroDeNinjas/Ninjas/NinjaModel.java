package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* @Entity transforma nossa classe em uma entidade no banco de dados
* @Table define o nome para nossa tabela, boa prática colocar em snake_case e com "tb_" antes do nome.
* */

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    /*
    * Definimos o id como Long com L maiusculo para trabalhar com JPA.
    * não precisamos de construtor para o ID, pois o JAVA vai lidar com ele
    * através da annotation @Id e @GeneratedValue
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    private int idade;
    /*
    * @ManyToOne = Many (nome da classe que vc ta trabalhando agora) can only have one (nome do que você quer relacionar)
    * Many ninjas can only have one mission (Muitos ninjas podem ter apenas uma missão)
    * */
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Adicionando a coluna da chave estrangeira OU foreign key (FK)
    private MissoesModel missoes;
}
