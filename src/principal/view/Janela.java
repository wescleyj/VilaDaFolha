package principal.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;

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

    }

    public JPanel getPrincipal() {
        return Principal;
    }

    public JPanel getTelaVisaoGeral() {
        return TelaVisaoGeral;
    }

    public JPanel getTelaMoradores() {
        return TelaMoradores;
    }

    public JPanel getTelaMissoes() {
        return TelaMissoes;
    }

    public JPanel getTelasPrincipais() {
        return TelasPrincipais;
    }

    public JButton getVisaoGeralButton() {
        return visaoGeralButton;
    }

    public JButton getMoradoresButton() {
        return moradoresButton;
    }

    public JButton getMissoesButton() {
        return missoesButton;
    }

    public JButton getGerenciarButton() {
        return gerenciarButton;
    }

    public JPanel getTelaGerenciar() {
        return TelaGerenciar;
    }

    public JTable getTabelaMoradores2() {
        return tabelaMoradores2;
    }

    public JTable getTabelaMissoes2() {
        return tabelaMissoes2;
    }

    public JButton getPesquisarButton() {
        return pesquisarButton;
    }

    public JButton getRemoverButton() {
        return removerButton;
    }

    public JButton getAdicionarButton() {
        return adicionarButton;
    }

    public JButton getPesquisarButton1() {
        return pesquisarButton1;
    }

    public JButton getRemoverButton1() {
        return removerButton1;
    }

    public JButton getAdicionarButton1() {
        return adicionarButton1;
    }

    public JButton getSalvarButton2() {
        return salvarButton2;
    }

    public JTable getTabelaMissoes() {
        return tabelaMissoes;
    }

    public JTable getTabelaMoradores() {
        return tabelaMoradores;
    }

    public JPanel getMenuLateral() {
        return MenuLateral;
    }

    public JButton getDeletarMissoesButton() {
        return deletarMissoesButton;
    }

    public JButton getDeletarTodosOsDadosButton() {
        return deletarTodosOsDadosButton;
    }

    public JButton getDeletarMoradoresButton() {
        return deletarMoradoresButton;
    }
}
