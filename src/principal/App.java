package principal;

import principal.controller.Controller;
import principal.model.Model;
import principal.view.Janela;

/**
 * Classe principal que serve como ponto de entrada para a aplicação de
 * Gerenciamento da Aldeia da Folha.
 * <p>
 * A responsabilidade desta classe é inicializar os componentes centrais do padrão
 * de arquitetura Model-View-Controller (MVC):
 * </p>
 *
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public class App {

    /** Construtor padrão */
    public App(){}
    
    /**
     * O método principal (main) que inicia a aplicação.
     *
     * @param args os argumentos de linha de comando (não utilizados nesta aplicação).
     */
    public static void main(String[] args) {
        Janela janela = new Janela();
        Model model = new Model();
        Controller controller = new Controller(model, janela);
    }
}
