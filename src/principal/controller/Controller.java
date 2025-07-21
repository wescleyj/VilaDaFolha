package principal.controller;

import principal.model.Model;
import principal.view.Janela;

import java.awt.CardLayout;

public class Controller {
    private Model model;
    private Janela janela;

    public Controller(Model model, Janela janela) {
        this.model = model;
        this.janela = janela;
        adicionarEventosBotoes();
    }

    // Adicionando eventos nos botões de mudança de tela e logica de controle de mudança de panels
    private void adicionarEventosBotoes() {
        janela.getVisaoGeralButton().addActionListener(e -> {
            CardLayout cl = (CardLayout) (janela.getTelasPrincipais().getLayout());
            cl.show(janela.getTelasPrincipais(), "visaoGeral");
        });

        janela.getMoradoresButton().addActionListener(e -> {
            CardLayout cl = (CardLayout) (janela.getTelasPrincipais().getLayout());
            cl.show(janela.getTelasPrincipais(), "moradores");
        });

        janela.getMissoesButton().addActionListener(e -> {
            CardLayout cl = (CardLayout) (janela.getTelasPrincipais().getLayout());
            cl.show(janela.getTelasPrincipais(), "missoes");
        });

        janela.getGerenciarButton().addActionListener(e -> {
            CardLayout cl = (CardLayout) (janela.getTelasPrincipais().getLayout());
            cl.show(janela.getTelasPrincipais(), "gerenciar");
        });
    }
}
