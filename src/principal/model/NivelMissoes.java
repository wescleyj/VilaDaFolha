package principal.model;

/**
 * Enum que representa os ranks possíveis de uma missão.
 * Pode ser S, A, B, C, ou D.
 * Utilizado para indicar o rank da missão.
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public enum NivelMissoes {
    /**
     * Missões de altíssimo risco, de importância crucial para a vila,
     * geralmente designadas apenas para Jounins de elite ou o Kage.
     */
    S,

    /**
     * Missões de alto nível que envolvem grande perigo, como assassinato
     * ou escolta de figuras importantes em território inimigo.
     */
    A,

    /**
     * Missões que carregam a possibilidade de combate contra outros ninjas.
     * Normalmente designadas para Chuunins ou Jounins.
     */
    B,

    /**
     * Missões de baixo risco que não devem envolver combate. Ex: escolta
     * de civis em rotas seguras.
     */
    C,

    /**
     * As missões mais simples e seguras, geralmente tarefas dentro da
     * própria vila. Designadas para Genins.
     */
    D
}
