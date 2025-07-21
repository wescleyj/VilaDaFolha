package principal.view;

import principal.controller.Controller;
import principal.model.Model;

public class App {
    public static void main(String[] args) {
        Janela janela = new Janela();
        Model model = new Model();
        Controller controller = new Controller(model, janela);
    }
}
