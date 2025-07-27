package principal.model;

/**
 * Representa um morador civil, herdando os campos comuns de Morador e adicionando a profissão.
 */
public class Civil extends Morador{
    /** Profissão exercida pelo civil.
     */
    private String profissao;

    /**
     * Cria um novo civil com os dados informados.
     * @param nome nome do civil
     * @param idade idade do civil
     * @param sexo sexo do civil
     * @param status status do civil
     * @param profissao profissão do civil
     */
    public Civil(String nome, int idade, Sexo sexo, Status status, String profissao) {
        super(nome, idade, sexo, status);
        this.profissao = profissao;
    }

    /**
     * Retorna a profissão do civil.
     * @return profissão do civil
     */
    public String getProfissao() {
        return profissao;
    }

}
