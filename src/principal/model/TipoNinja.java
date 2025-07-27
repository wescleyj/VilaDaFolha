package principal.model;

/**
 * Enum que representa as patentes possíveis de um ninja na vila: Genin, Chuunin, Jounin ou Kage.
 * Utilizado para diferenciar o nível hierárquico dos moradores do tipo Ninja.
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public enum TipoNinja {
    /**
     * Nível mais baixo de um ninja, geralmente recém-formados da academia.
     */
    GENIN,

    /**
     * Nível intermediário. Ninjas que passaram no Exame Chuunin e
     * estão aptos a liderar equipes.
     */
    CHUUNIN,

    /**
     * Ninja de elite, altamente qualificado e experiente, que realiza
     * missões de alto nível.
     */
    JOUNIN,

    /**
     * O mais alto título de um ninja, o líder da vila.
     */
    KAGE
}
