package principal.view;

import javax.swing.*;

public class DialogAdicionarMissao extends JDialog {
    // Campos vinculados ao formulário
    private JPanel dialogAdicionarMissao;
    private JPanel painelPrincipal;
    private JLabel labelNome;
    private JTextField textNome;
    private JLabel labelDescricao;
    private JTextArea textDescricao;
    private JLabel labelDificuldade;
    private JComboBox comboDificuldade;
    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JPanel espaco;
    private JPanel botoes;

    public DialogAdicionarMissao() {
        // O construtor deve configurar o painel principal do diálogo
        setContentPane(dialogAdicionarMissao);
        setTitle("Adicionar Missão");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);
        pack();
        setLocationRelativeTo(null);
    }

    // Adicione getters para os componentes que você precisará acessar no controller
    public JTextField getTextNome() {
        return textNome;
    }

    public JTextArea getTextDescricao() {
        return textDescricao;
    }

    public JComboBox getComboDificuldade() {
        return comboDificuldade;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    public ComboBoxModel<Object> getComboNivelMissoes() {
        return comboDificuldade.getModel();
    }
}