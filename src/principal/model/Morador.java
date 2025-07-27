package principal.model;

/**
 * Classe abstrata que define os campos comuns a todos os moradores da vila.
 * Deve ser estendida por tipos específicos de moradores.
 */
public abstract class Morador {
    /** Nome do morador. */
    private String nome;
    /** Idade do morador. */
    private int idade;
    /** Sexo do morador. */
    private Sexo sexo;
    /** Status atual do morador. */
    private Status status;

    /**
     * Construtor da classe Morador.
     * @param nome Nome do morador.
     * @param idade Idade do morador.
     * @param sexo Sexo do morador.
     * @param status Status do morador.
     */
    public Morador(String nome, int idade, Sexo sexo, Status status) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.status = status;
    }

    /**
     * Retorna o nome do morador.
     * @return Nome do morador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a idade do morador.
     * @return Idade do morador.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Retorna o sexo do morador.
     * @return Sexo do morador.
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * Retorna o status do morador.
     * @return Status do morador.
     */
    public Status getStatus() {
        return status;
    }

}
