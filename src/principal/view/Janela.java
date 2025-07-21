package principal.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.CardLayout;

public class Janela extends JFrame{
    private JPanel Principal;
    private JPanel TelaVisaoGeral;
    private JPanel TelaMoradores;
    private JPanel TelaMissoes;
    private JPanel TelasPrincipais;
    private JButton visaoGeralButton;
    private JButton moradoresButton;
    private JButton missoesButton;
    private JButton gerenciarButton;
    private JPanel TelaGerenciar;
    private JTable tabelaMoradores2;
    private JTable tabelaMissoes2;
    private JButton pesquisarButton;
    private JButton removerButton;
    private JButton adicionarButton;
    private JButton pesquisarButton1;
    private JButton removerButton1;
    private JButton adicionarButton1;
    private JButton salvarButton2;
    private JTable tabelaMissoes;
    private JTable tabelaMoradores;
    private JPanel MenuLateral;

    // Adicionar confirmação antes dos botões a seguir -----------------------------------------------------------------------
    private JButton deletarMissoesButton;
    private JButton deletarTodosOsDadosButton;
    private JButton deletarMoradoresButton;

    public Janela() {
        setTitle("Sistema de Gerenciamento da aldeia da folha");
        setContentPane(Principal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        TelasPrincipais.add(TelaVisaoGeral, "visaoGeral");
        TelasPrincipais.add(TelaMoradores, "moradores");
        TelasPrincipais.add(TelaMissoes, "missoes");
        TelasPrincipais.add(TelaGerenciar, "gerenciar");


        // A partir daqui TESTES de mudança de página, levar para Controller depois----------------------------------------------

        visaoGeralButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (TelasPrincipais.getLayout());
            cl.show(TelasPrincipais, "visaoGeral");
        });
        moradoresButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (TelasPrincipais.getLayout());
            cl.show(TelasPrincipais, "moradores");
        });
        missoesButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (TelasPrincipais.getLayout());
            cl.show(TelasPrincipais, "missoes");
        });
        gerenciarButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (TelasPrincipais.getLayout());
            cl.show(TelasPrincipais, "gerenciar");
        });
    }
}
