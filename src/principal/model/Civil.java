package principal.model;

public class Civil extends Morador{
    private String profissao;

    public Civil(String nome, int idade, Sexo sexo, Status status, String profissao) {
        super(nome, idade, sexo, status);
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
