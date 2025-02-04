package dev.java10x.CadastroDeNinjas.Missoes;

public enum RankMissao {
    D("Fáceis, tarefas básicas para ninjas novatos"),
    C("Envolvem combate leve e ameaças moderadas"),
    B("Perigosas, envolvem combates contra ninjas inimigos"),
    A("Altamente perigosas, envolvem combate contra ninjas de elite"),
    S("Extremamente difíceis, afetam nações inteiras");

   private String descricao;

    RankMissao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}


