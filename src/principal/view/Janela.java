package principal.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 * Representa a janela principal (JFrame) da aplicação de gerenciamento da Aldeia da Folha.
 * <p>
 * Esta classe é responsável por inicializar e exibir todos os componentes visuais
 * da interface do usuário (GUI), como painéis, botões e tabelas.
 * Ela centraliza o acesso aos componentes para que possam ser manipulados por
 * uma classe controladora (Controller), seguindo o padrão MVC.
 * </p>
 *
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public class Janela extends JFrame{

    // --- PAINÉIS PRINCIPAIS ---
    /** Painel raiz que contém todos os outros componentes da janela. */
    private JPanel Principal;
    /** Painel que exibe a tela de "Visão Geral" com dados resumidos. */
    private JPanel TelaVisaoGeral;
    /** Painel para visualização detalhada de moradores. */
    private JPanel TelaMoradores;
    /** Painel para visualização detalhada de missões. */
    private JPanel TelaMissoes;
    /** Painel que utiliza CardLayout para alternar entre as telas principais. */
    private JPanel TelasPrincipais;
    /** Painel com ferramentas para gerenciar dados (salvar, deletar, etc.). */
    private JPanel TelaGerenciar;
    /** Painel de menu com opções de navegação e ações globais. */
    private JPanel MenuLateral;

    // --- BOTÕES DE NAVEGAÇÃO ---
    /** Botão para navegar até a tela de Visão Geral. */
    private JButton visaoGeralButton;
    /** Botão para navegar até a tela de Moradores. */
    private JButton moradoresButton;
    /** Botão para navegar até a tela de Missões. */
    private JButton missoesButton;
    /** Botão para navegar até a tela de Gerenciamento. */
    private JButton gerenciarButton;

    // --- COMPONENTES DA TELA GERENCIAR (MORADORES) ---
    /** Botão para reexibir todos os moradores na tabela após uma pesquisa. */
    private JButton moradoresMostrarTodos;
    /** Tabela principal de moradores, exibida na tela de Gerenciamento de Moradores. */
    private JTable tabelaMoradores;
    /** Botão para pesquisar um morador na tela de gerenciamento. */
    private JButton pesquisarMoradorButton;
    /** Botão para remover um morador na tela de gerenciamento. */
    private JButton removerMoradorButton;
    /** Botão para adicionar um novo morador na tela de gerenciamento. */
    private JButton adicionarMoradorButton;

    // --- COMPONENTES DA TELA GERENCIAR (MISSÕES) ---
    /** Botão para pesquisar uma missão na tela de gerenciamento. */
    private JButton pesquisarMissaoButton;
    /** Botão para remover uma missão na tela de gerenciamento. */
    private JButton removerMissaoButton;
    /** Botão para adicionar uma nova missão na tela de gerenciamento. */
    private JButton adicionarMissaoButton;
    /** Tabela principal de missões, exibida na tela de Gerenciamento de Missões. */
    private JTable tabelaMissoes;
    /** Botão para reexibir todas as missões na tabela após uma pesquisa. */
    private JButton missoesMostrarTodas;


    // --- COMPONENTES DA TELA VISÃO GERAL ---
    /** Tabela resumida de moradores exibida na tela de Visão Geral. */
    private JTable tabelaMoradoresResumo;
    /** Rótulo (Label) que exibe o número total da população. */
    private JLabel numPopulacao;
    /** Rótulo (Label) que exibe o número total de missões. */
    private JLabel numMissoes;
    /** Rótulo (Label) que exibe a receita total da aldeia. */
    private JLabel numReceita;
    /** Tabela resumida de missões exibida na tela de Visão Geral. */
    private JTable tabelaMissoesResumo;

    // --- BOTÕES DE AÇÃO GERAL ---
    /** Botão para salvar todas as alterações feitas. */
    private JButton salvarButton;
    /** Botão para deletar todas as missões cadastradas. */
    private JButton deletarTodasMissoesButton;
    /** Botão para deletar todos os dados da aplicação (moradores e missões). */
    private JButton deletarTodosOsDadosButton;
    /** Botão para deletar todos os moradores cadastrados. */
    private JButton deletarTodosMoradoresButton;

    /**
     * Construtor da classe Janela.
     * <p>
     * Inicializa a janela principal, define suas propriedades como título, tamanho,
     * comportamento de fechamento e configura os painéis da interface.
     * </p>
     */
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
        getMoradoresMostrarTodos().setEnabled(false);
    }

    // --- GETTERS PARA ACESSO AOS COMPONENTES (PARA O CONTROLLER) ---

    /**
     * Retorna o painel principal da janela.
     * @return O {@code JPanel} principal.
     */
    public JPanel getPrincipal() { return Principal; }

    /**
     * Retorna o painel da tela "Visão Geral".
     * @return O {@code JPanel} da visão geral.
     */
    public JPanel getTelaVisaoGeral() { return TelaVisaoGeral; }

    /**
     * Retorna o painel da tela "Moradores".
     * @return O {@code JPanel} de moradores.
     */
    public JPanel getTelaMoradores() { return TelaMoradores; }

    /**
     * Retorna o painel da tela "Missões".
     * @return O {@code JPanel} de missões.
     */
    public JPanel getTelaMissoes() { return TelaMissoes; }

    /**
     * Retorna o painel que gerencia a exibição das telas principais (com CardLayout).
     * @return O {@code JPanel} que contém as telas.
     */
    public JPanel getTelasPrincipais() { return TelasPrincipais; }

    /**
     * Retorna o botão de navegação para a tela "Visão Geral".
     * @return O {@code JButton} para a visão geral.
     */
    public JButton getVisaoGeralButton() { return visaoGeralButton; }

    /**
     * Retorna o botão de navegação para a tela "Moradores".
     * @return O {@code JButton} para moradores.
     */
    public JButton getMoradoresButton() { return moradoresButton; }

    /**
     * Retorna o botão de navegação para a tela "Missões".
     * @return O {@code JButton} para missões.
     */
    public JButton getMissoesButton() { return missoesButton; }

    /**
     * Retorna o botão de navegação para a tela "Gerenciar".
     * @return O {@code JButton} para gerenciar.
     */
    public JButton getGerenciarButton() { return gerenciarButton; }

    /**
     * Retorna o painel da tela "Gerenciar".
     * @return O {@code JPanel} de gerenciamento.
     */
    public JPanel getTelaGerenciar() { return TelaGerenciar; }

    /**
     * Retorna a tabela resumida de moradores exibida na tela de Visão Geral.
     * @return A {@code JTable} de resumo de moradores.
     */
    public JTable getTabelaMoradoresResumo() { return tabelaMoradoresResumo; }

    /**
     * Retorna a tabela resumida de missões exibida na tela de Visão Geral.
     * @return A {@code JTable} de resumo de missões.
     */
    public JTable getTabelaMissoesResumo() { return tabelaMissoesResumo; }

    /**
     * Retorna o botão "Pesquisar" para moradores.
     * @return O {@code JButton} de pesquisa de moradores.
     */
    public JButton getPesquisarMoradorButton() { return pesquisarMoradorButton; }

    /**
     * Retorna o botão "Remover" para moradores.
     * @return O {@code JButton} de remoção de moradores.
     */
    public JButton getRemoverMoradorButton() { return removerMoradorButton; }

    /**
     * Retorna o botão "Adicionar" para moradores.
     * @return O {@code JButton} de adição de moradores.
     */
    public JButton getAdicionarMoradorButton() { return adicionarMoradorButton; }

    /**
     * Retorna o botão "Pesquisar" para missões.
     * @return O {@code JButton} de pesquisa de missões.
     */
    public JButton getPesquisarMissaoButton() { return pesquisarMissaoButton; }

    /**
     * Retorna o botão "Remover" para missões.
     * @return O {@code JButton} de remoção de missões.
     */
    public JButton getRemoverMissaoButton() { return removerMissaoButton; }

    /**
     * Retorna o botão "Adicionar" para missões.
     * @return O {@code JButton} de adição de missões.
     */
    public JButton getAdicionarMissaoButton() { return adicionarMissaoButton; }

    /**
     * Retorna o botão "Salvar" para persistir as alterações.
     * @return O {@code JButton} para salvar dados.
     */
    public JButton getSalvarButton() { return salvarButton; }

    /**
     * Retorna a tabela principal de missões da tela de Gerenciamento.
     * @return A {@code JTable} com a lista completa de missões.
     */
    public JTable getTabelaMissoes() { return tabelaMissoes; }

    /**
     * Retorna a tabela principal de moradores da tela de Gerenciamento.
     * @return A {@code JTable} com a lista completa de moradores.
     */
    public JTable getTabelaMoradores() { return tabelaMoradores; }

    /**
     * Retorna o painel do menu lateral.
     * @return O {@code JPanel} do menu lateral.
     */
    public JPanel getMenuLateral() { return MenuLateral; }

    /**
     * Retorna o botão para deletar todas as missões.
     * @return O {@code JButton} para deletar missões.
     */
    public JButton getDeletarTodasMissoesButton() { return deletarTodasMissoesButton; }

    /**
     * Retorna o botão para deletar todos os dados da aplicação.
     * @return O {@code JButton} para deletar todos os dados.
     */
    public JButton getDeletarTodosOsDadosButton() { return deletarTodosOsDadosButton; }

    /**
     * Retorna o botão para deletar todos os moradores.
     * @return O {@code JButton} para deletar moradores.
     */
    public JButton getDeletarTodosMoradoresButton() { return deletarTodosMoradoresButton; }

    /**
     * Retorna o rótulo que exibe o número total da população.
     * @return O {@code JLabel} com o número da população.
     */
    public JLabel getNumPopulacao() { return numPopulacao; }

    /**
     * Retorna o botão "Mostrar Todos" para a tabela de moradores.
     * @return O {@code JButton} para redefinir a visualização da tabela de moradores.
     */
    public JButton getMoradoresMostrarTodos() { return moradoresMostrarTodos; }

    /**
     * Retorna o botão "Mostrar Todas" para a tabela de missões.
     * @return O {@code JButton} para redefinir a visualização da tabela de missões.
     */
    public JButton getMissoesMostrarTodas() { return missoesMostrarTodas; }

    /**
     * Retorna o rótulo que exibe o número total de missões.
     * @return O {@code JLabel} com o número de missões.
     */
    public JLabel getNumMissoes() { return numMissoes; }

    /**
     * Retorna o rótulo que exibe a receita total da aldeia.
     * @return O {@code JLabel} com a receita total.
     */
    public JLabel getNumReceita() { return numReceita; }
}
