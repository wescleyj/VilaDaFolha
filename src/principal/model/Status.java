package principal.model;

/**
 * Enum que representa o status de um morador da vila.
 * Pode ser ATIVO, AUSENTE ou FALECIDO.
 * Utilizado para indicar a situação atual do morador.
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public enum Status {
    /**
     * Indica que o morador está atualmente na vila e apto para suas atividades.
     */
    ATIVO,

    /**
     * Indica que o morador não está na vila, geralmente por estar em uma
     * missão de longa duração ou por outros motivos.
     */
    AUSENTE,

    /**
     * Indica que o morador faleceu.
     */
    FALECIDO
}
