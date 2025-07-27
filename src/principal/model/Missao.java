package principal.model;

/**
 * Representa uma entidade de Missão no sistema de gerenciamento da Aldeia.
 * <p>
 * Esta classe é um modelo de dados que encapsula todas as informações
 * pertinentes a uma única missão, como seu nome, descrição e nível de dificuldade.
 * </p>
 *
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public class Missao {
    /** O nome oficial da missão. */
    private String nome;
    /** Uma descrição detalhada dos objetivos e requisitos da missão. */
    private String descricao;
    /** O nível de dificuldade da missão, representado pelo enum {@link NivelMissoes}. */
    private NivelMissoes dificuldade;

    /**
     * Construtor para criar uma nova instância de Missao.
     *
     * @param nome O nome a ser atribuído à missão.
     * @param descricao A descrição detalhada da missão.
     * @param dificuldade O nível de dificuldade da missão.
     */
    public Missao(String nome, String descricao, NivelMissoes dificuldade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    /**
     * Retorna o nome da missão.
     *
     * @return O nome da missão como uma {@code String}.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define um novo nome para a missão.
     *
     * @param nome O novo nome a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a descrição da missão.
     *
     * @return A descrição da missão como uma {@code String}.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define uma nova descrição para a missão.
     *
     * @param descricao A nova descrição a ser definida.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o nível de dificuldade da missão.
     *
     * @return O nível de dificuldade como um enum {@link NivelMissoes}.
     */
    public NivelMissoes getDificuldade() {
        return dificuldade;
    }

    /**
     * Define um novo nível de dificuldade para a missão.
     *
     * @param dificuldade O novo nível de dificuldade a ser definido.
     */
    public void setDificuldade(NivelMissoes dificuldade) {
        this.dificuldade = dificuldade;
    }
}
