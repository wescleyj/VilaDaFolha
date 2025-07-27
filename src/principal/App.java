package principal;

import principal.controller.Controller;
import principal.model.Model;
import principal.view.Janela;

public class App {
    public static void main(String[] args) {
        Janela janela = new Janela();
        Model model = new Model();
        Controller controller = new Controller(model, janela);
    }
}
