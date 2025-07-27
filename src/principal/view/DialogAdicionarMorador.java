package principal.view;

import javax.swing.*;

public class DialogAdicionarMorador extends JDialog {
    private JPanel dialogAdicionarMorador;
    private JButton botaoOK;
    private JButton botaoCancelar;
    private JPanel botoes;
    private JPanel espaco;
    private JPanel painelPrincipal;
    private JComboBox tipoMorador;
    private JComboBox sexoMorador;
    private JTextField textNome;
    private JTextField textIdade;
    private JTextField textProfissaoCivil;
    private JComboBox textTipoNinja;
    private JLabel labelPatente;
    private JLabel labelTipo;
    private JLabel labelNome;
    private JLabel labelIdade;
    private JLabel labelSexo;
    private JLabel labelProfissao;

    public DialogAdicionarMorador() {
        setContentPane(dialogAdicionarMorador);
        setModal(true);
    }

    public JPanel getDialogAdicionarMorador() {
        return dialogAdicionarMorador;
    }

    public JButton getBotaoOK() {
        return botaoOK;
    }

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    public JPanel getBotoes() {
        return botoes;
    }

    public JPanel getEspaco() {
        return espaco;
    }

    public JPanel getPainelPrincipal() {
        return painelPrincipal;
    }

    public JComboBox getTipoMorador() {
        return tipoMorador;
    }

    public JComboBox getSexoMorador() {
        return sexoMorador;
    }

    public JTextField getTextNome() {
        return textNome;
    }

    public JTextField getTextIdade() {
        return textIdade;
    }

    public JTextField getTextProfissaoCivil() {
        return textProfissaoCivil;
    }

    public JComboBox getTextTipoNinja() {
        return textTipoNinja;
    }

    public JLabel getLabelPatente() {
        return labelPatente;
    }

    public JLabel getLabelTipo() {
        return labelTipo;
    }

    public JLabel getLabelNome() {
        return labelNome;
    }

    public JLabel getLabelIdade() {
        return labelIdade;
    }

    public JLabel getLabelSexo() {
        return labelSexo;
    }

    public JLabel getLabelProfissao() {
        return labelProfissao;
    }
}
