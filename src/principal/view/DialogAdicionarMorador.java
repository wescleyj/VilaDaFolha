package principal.view;

import javax.swing.*;

/**
 * Janela de diálogo para adicionar um novo morador à vila.
 * Permite a entrada de dados como nome, idade, sexo, tipo de morador (Ninja ou Civil),
 * profissão (para civis) e patente (para ninjas).
 * Os componentes gráficos são gerados pelo IntelliJ GUI Designer.
 *
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public class DialogAdicionarMorador extends JDialog {
    /** Painel principal do diálogo de adicionar morador. */
    private JPanel dialogAdicionarMorador;
    /** Botão para confirmar a adição do morador. */
    private JButton botaoOK;
    /** Botão para cancelar a adição do morador. */
    private JButton botaoCancelar;
    /** Painel que agrupa os botões de ação. */
    private JPanel botoes;
    /** Painel de espaçamento para layout. */
    private JPanel espaco;
    /** Painel principal de entrada de dados do diálogo. */
    private JPanel painelPrincipal;
    /** Combo box para seleção do tipo de morador (Ninja ou Civil). */
    private JComboBox tipoMorador;
    /** Combo box para seleção do sexo do morador. */
    private JComboBox sexoMorador;
    /** Campo de texto para o nome do morador. */
    private JTextField textNome;
    /** Campo de texto para a idade do morador. */
    private JTextField textIdade;
    /** Campo de texto para a profissão do civil. */
    private JTextField textProfissaoCivil;
    /** Combo box para seleção da patente do ninja. */
    private JComboBox textTipoNinja;
    /** Rótulo para o campo de patente. */
    private JLabel labelPatente;
    /** Rótulo para o campo de tipo de morador. */
    private JLabel labelTipo;
    /** Rótulo para o campo de nome. */
    private JLabel labelNome;
    /** Rótulo para o campo de idade. */
    private JLabel labelIdade;
    /** Rótulo para o campo de sexo. */
    private JLabel labelSexo;
    /** Rótulo para o campo de profissão. */
    private JLabel labelProfissao;

    /**
     * Construtor da janela de diálogo para adicionar morador.
     * Inicializa os componentes e define o painel principal.
     */
    public DialogAdicionarMorador() {
        setContentPane(dialogAdicionarMorador);
        setModal(true);
    }

    /**
     * Retorna o painel principal do diálogo.
     * @return Painel principal.
     */
    public JPanel getDialogAdicionarMorador() {
        return dialogAdicionarMorador;
    }

    /**
     * Retorna o botão OK.
     * @return Botão OK.
     */
    public JButton getBotaoOK() {
        return botaoOK;
    }

    /**
     * Retorna o botão Cancelar.
     * @return Botão Cancelar.
     */
    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    /**
     * Retorna o painel dos botões.
     * @return Painel dos botões.
     */
    public JPanel getBotoes() {
        return botoes;
    }

    /**
     * Retorna o painel de espaçamento.
     * @return Painel de espaçamento.
     */
    public JPanel getEspaco() {
        return espaco;
    }

    /**
     * Retorna o painel principal de entrada de dados.
     * @return Painel principal.
     */
    public JPanel getPainelPrincipal() {
        return painelPrincipal;
    }

    /**
     * Retorna o combo box para seleção do tipo de morador.
     * @return Combo box de tipo de morador.
     */
    public JComboBox getTipoMorador() {
        return tipoMorador;
    }

    /**
     * Retorna o combo box para seleção do sexo do morador.
     * @return Combo box de sexo.
     */
    public JComboBox getSexoMorador() {
        return sexoMorador;
    }

    /**
     * Retorna o campo de texto para o nome do morador.
     * @return Campo de texto do nome.
     */
    public JTextField getTextNome() {
        return textNome;
    }

    /**
     * Retorna o campo de texto para a idade do morador.
     * @return Campo de texto da idade.
     */
    public JTextField getTextIdade() {
        return textIdade;
    }

    /**
     * Retorna o campo de texto para a profissão do civil.
     * @return Campo de texto da profissão.
     */
    public JTextField getTextProfissaoCivil() {
        return textProfissaoCivil;
    }

    /**
     * Retorna o combo box para seleção da patente do ninja.
     * @return Combo box de patente.
     */
    public JComboBox getTextTipoNinja() {
        return textTipoNinja;
    }

    /**
     * Retorna o rótulo da patente.
     * @return Label da patente.
     */
    public JLabel getLabelPatente() {
        return labelPatente;
    }

    /**
     * Retorna o rótulo do tipo.
     * @return Label do tipo.
     */
    public JLabel getLabelTipo() {
        return labelTipo;
    }

    /**
     * Retorna o rótulo do nome.
     * @return Label do nome.
     */
    public JLabel getLabelNome() {
        return labelNome;
    }

    /**
     * Retorna o rótulo da idade.
     * @return Label da idade.
     */
    public JLabel getLabelIdade() {
        return labelIdade;
    }

    /**
     * Retorna o rótulo do sexo.
     * @return Label do sexo.
     */
    public JLabel getLabelSexo() {
        return labelSexo;
    }

    /**
     * Retorna o rótulo da profissão.
     * @return Label da profissão.
     */
    public JLabel getLabelProfissao() {
        return labelProfissao;
    }
}
