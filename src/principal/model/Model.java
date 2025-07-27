package principal.model;

import principal.dao.MissaoDAO;
import principal.dao.MoradorDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o modelo principal da aplicação, contendo a lista de moradores e o DAO responsável pela persistência.
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public class Model {
    /** Lista de moradores gerenciada pelo modelo. */
    private List<Morador> moradores = new ArrayList<>();
    /** Lista de missões gerenciada pelo modelo. */
    private List<Missao> missoes = new ArrayList<>();
    /** DAO responsável pela persistência dos moradores. */
    private MoradorDAO moradorDAO = new MoradorDAO();
    /** DAO responsável pela persistência das missões. */
    private MissaoDAO missaoDAO = new MissaoDAO();

    /**
     * Cria uma nova instância de Model e inicializa a lista de moradores e das missões com os dados carregados do DAO.
     */
    public Model(){
        moradores = moradorDAO.carregarMoradores();
        missoes = missaoDAO.carregarMissoes();
    }

    /**
     * Retorna a lista de todos os moradores.
     * @return lista de moradores
     */
    public List<Morador> getMoradores() {
        return moradores;
    }

    /**
     * Adiciona um morador à lista de moradores.
     * @param morador morador a ser adicionado
     */
    public void adicionarMorador(Morador morador){
        moradores.add(morador);
    }

    /**
     * Remove um morador da lista de moradores.
     * @param morador morador a ser removido
     */
    public void removerMorador(Morador morador){
        moradores.remove(morador);
    }

    /**
     * Salva todos os moradores da lista no arquivo CSV.
     */
    public void salvarMoradores(){
        moradorDAO.salvarMoradores(moradores);
    }

    /**
     * Salva todas as missoes da lista no arquivo CSV.
     */
    public void salvarMissoes(){
        missaoDAO.salvarMissoes(missoes);
    }

    /**
     * Adiciona um missao à lista de missoes.
     * @param missao missao a ser adicionado
     */
    public void adicionarMissao(Missao missao) {
        missoes.add(missao);
    }

    /**
     * Retorna a lista de todos os missoes.
     * @return lista de missoes
     */
    public List<Missao> getMissoes() {
        return missoes;
    }

    /**
     * Remove um missao da lista de missoes.
     * @param missao missao a ser removido
     */
    public void removerMissao(Missao missao) {
        missoes.remove(missao);
    }

    public void SalvarMissoes() {
        missaoDAO.salvarMissoes(missoes);
    }
}
