package principal.model;

/**
 * Representa um morador ninja, herdando os campos comuns de Morador e adicionando o tipo de ninja.
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public class Ninja extends Morador{
    /** Patente do ninja.
     */
    private TipoNinja tipo;

    /**
     * Cria um novo ninja com os dados informados.
     * @param nome nome do ninja
     * @param idade idade do ninja
     * @param sexo sexo do ninja
     * @param status status do ninja
     * @param tipo patente do ninja
     */
    public Ninja(String nome, int idade, Sexo sexo, Status status, TipoNinja tipo) {
        super(nome, idade, sexo, status);
        this.tipo = tipo;
    }

    /**
     * Retorna a patente do ninja.
     * @return tipo do ninja
     */
    public TipoNinja getTipo() {
        return tipo;
    }

}
