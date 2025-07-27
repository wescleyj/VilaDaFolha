package principal.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;

/**
 * Representa uma caixa de diálogo modal para adicionar uma nova Missão.
 * <p>
 * Esta classe, como parte da camada View, fornece um formulário para que o
 * usuário insira os dados de uma nova missão (nome, descrição e dificuldade).
 * A lógica para processar esses dados é gerenciada por uma classe Controller externa.
 * </p>
 *
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public class DialogAdicionarMissao extends JDialog {
    /** Painel raiz do diálogo, geralmente o 'Content Pane'. */
    private JPanel dialogAdicionarMissao;
    /** Painel que agrupa os campos de entrada de dados. */
    private JPanel painelPrincipal;
    /** Rótulo "Nome:" para o campo de texto do nome. */
    private JLabel labelNome;
    /** Campo de texto para inserir o nome da missão. */
    private JTextField textNome;
    /** Rótulo "Descrição:" para a área de texto da descrição. */
    private JLabel labelDescricao;
    /** Área de texto para inserir a descrição detalhada da missão. */
    private JTextArea textDescricao;
    /** Rótulo "Dificuldade:" para a caixa de seleção de dificuldade. */
    private JLabel labelDificuldade;
    /** Caixa de combinação (dropdown) para selecionar o nível de dificuldade da missão. */
    private JComboBox<Object> comboDificuldade;
    /** Botão para confirmar a ação e salvar a nova missão. */
    private JButton botaoSalvar;
    /** Botão para cancelar a operação e fechar o diálogo. */
    private JButton botaoCancelar;
    /** Painel auxiliar usado para espaçamento no layout visual. */
    private JPanel espaco;
    /** Painel que contém os botões de ação 'Salvar' e 'Cancelar'. */
    private JPanel botoes;

    /**
     * Construtor da caixa de diálogo para adicionar missões.
     * <p>
     * Inicializa o diálogo, definindo suas propriedades fundamentais como
     * título, modalidade (bloqueia a janela principal), operação de fechamento
     * e posicionamento centralizado na tela.
     * </p>
     */
    public DialogAdicionarMissao() {
        setContentPane(dialogAdicionarMissao);
        setTitle("Adicionar Missão");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);
        pack(); // Ajusta o tamanho do diálogo ao seu conteúdo
        setLocationRelativeTo(null); // Centraliza na tela
    }

    // --- GETTERS PARA ACESSO PELO CONTROLLER ---

    /**
     * Retorna o campo de texto para o nome da missão.
     * @return O componente {@code JTextField} do nome.
     */
    public JTextField getTextNome() {
        return textNome;
    }

    /**
     * Retorna a área de texto para a descrição da missão.
     * @return O componente {@code JTextArea} da descrição.
     */
    public JTextArea getTextDescricao() {
        return textDescricao;
    }

    /**
     * Retorna a caixa de combinação (dropdown) para a dificuldade da missão.
     * @return O componente {@code JComboBox} da dificuldade.
     */
    public JComboBox<Object> getComboDificuldade() {
        return comboDificuldade;
    }

    /**
     * Retorna o botão "Salvar".
     * @return O componente {@code JButton} de salvar.
     */
    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }

    /**
     * Retorna o botão "Cancelar".
     * @return O componente {@code JButton} de cancelar.
     */
    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    /**
     * Retorna o modelo de dados da caixa de combinação de dificuldade.
     * Útil para o Controller popular a lista de dificuldades.
     * @return O {@code ComboBoxModel} associado ao JComboBox de dificuldade.
     */
    public ComboBoxModel<Object> getComboNivelMissoes() {
        return comboDificuldade.getModel();
    }
}