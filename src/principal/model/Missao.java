package principal.model;

public class Missao {
    private String nome;
    private String descricao;
    private NivelMissoes dificuldade;

    public Missao(String nome, String descricao, NivelMissoes dificuldade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public NivelMissoes getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(NivelMissoes dificuldade) {
        this.dificuldade = dificuldade;
    }
}
