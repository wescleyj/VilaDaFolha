package principal.model;

public abstract class Morador {
    private String nome;
    private int idade;
    private Sexo sexo;
    private Status status;

    public Morador(String nome, int idade, Sexo sexo, Status status) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Status getStatus() {
        return status;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
