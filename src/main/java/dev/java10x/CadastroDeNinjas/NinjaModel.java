package dev.java10x.CadastroDeNinjas;

import jakarta.persistence.*;

/*
* @Entity transforma nossa classe em uma entidade no banco de dados
* @Table define o nome para nossa tabela, boa prática colocar em snake_case e com "tb_" antes do nome.
* */

@Entity
@Table(name = "tb_cadastro")
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
    private int idade;
    private String email;

    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
