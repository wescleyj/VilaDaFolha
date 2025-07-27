package principal.model;

import principal.dao.MoradorDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o modelo principal da aplicação, contendo a lista de moradores e o DAO responsável pela persistência.
 */
public class Model {
    private List<Morador> moradores = new ArrayList<>();
    private MoradorDAO moradorDAO = new MoradorDAO();

    /**
     * Cria uma nova instância de Model e inicializa a lista de moradores com os dados carregados do DAO.
     */
    public Model(){
        moradores = moradorDAO.carregarMoradores();
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

}
