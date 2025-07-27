package principal.model;

import principal.dao.MoradorDAO;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Morador> moradores = new ArrayList<>();
    private MoradorDAO moradorDAO = new MoradorDAO();


    public Model(){
        moradores = moradorDAO.carregarMoradores();
    }

    public List<Morador> getMoradores() {
        return moradores;
    }

    public void adicionarMorador(Morador morador){
        moradores.add(morador);
    }

    public void removerMorador(Morador morador){
        moradores.remove(morador);
    }

    public void salvarMoradores(){
        moradorDAO.salvarMoradores(moradores);
    }

}
