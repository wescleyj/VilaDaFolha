package principal.controller;

import principal.model.Model;
import principal.view.Janela;
import principal.model.Ninja;
import principal.model.Sexo;
import principal.model.Morador;
import principal.model.Civil;
import principal.model.Status;
import principal.model.TipoNinja;
import principal.view.DialogAdicionarMorador;

import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import principal.view.DialogAdicionarMissao;
import principal.model.Missao;
import principal.model.NivelMissoes;

/**
 * Classe responsável por controlar a interação entre a interface gráfica (Janela) e o modelo de dados (Model).
 * Gerencia eventos dos botões, atualização de tabelas e lógica de adição, remoção, pesquisa e exibição de moradores.
 *
 *  * @author Giovanni Estevam dos Santos
 *  * @author João Vitor Lopes Fagundes
 *  * @author Pedro Ricoy de Oliveira e Silva
 *  * @author Wescley Júnior Gonçalves Navarro
 */
public class Controller {
    /** Referência para o modelo de dados da aplicação. */
    private final Model model;
    /** Referência para a interface gráfica principal da aplicação. */
    private final Janela janela;

    /**
     * Construtor do Controller.
     * Inicializa o modelo, a janela e adiciona os eventos aos botões.
     * @param model Modelo de dados da aplicação.
     * @param janela Interface gráfica principal.
     */
    public Controller(Model model, Janela janela) {
        this.model = model;
        this.janela = janela;
        adicionarEventosBotoes();
    }


    // Adicionando eventos nos botões de mudança de tela e logica de controle de mudança de panels
    /**
     * Adiciona os eventos aos botões principais da interface.
     */
    private void adicionarEventosBotoes() {
        botoesEventosMenuLateral();
        botoesEventosMorador();
        botoesEventosMissao();
        botaoSalvar();
        botaoDeletarTodosOsDados();
    }

    /**
     * Adiciona eventos aos botões do menu lateral para troca de telas.
     */
    private void botoesEventosMenuLateral() {
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

    /**
     * Adiciona eventos relacionados à manipulação de moradores.
     */
    private void botoesEventosMorador(){
        atualizarTabelaMoradores(model.getMoradores()); //inicializa a tabela com todos os moradores

        botaoAdicionarMorador();
        botaoRemoverMorador();
        botaoPesquisarMorador();
        atualizarTabelaMoradoresMostrarTodos();
        botaoDeletarMoradores();
    }

    /**
     * Adiciona evento para pesquisar moradores pelo nome.
     */
    private void botaoPesquisarMorador(){
        janela.getPesquisarMoradorButton().addActionListener(e -> {
            String nomeBusca = JOptionPane.showInputDialog(janela, "Digite o nome do morador:");
            if(nomeBusca == null)
                return;

            if(nomeBusca.trim().isEmpty()) {
                atualizarTabelaMoradores(model.getMoradores());
                return;
            }

            List<Morador> encontrados = model.getMoradores().stream().filter(m -> m.getNome().toLowerCase().contains(nomeBusca.toLowerCase())).toList();

            if(encontrados.isEmpty())
                JOptionPane.showMessageDialog(janela, "Nenhum morador encontrado.");
            else {
                atualizarTabelaMoradores(encontrados);
                JOptionPane.showMessageDialog(janela, encontrados.size() + " morador(es) encontrado(s).");
                janela.getMoradoresMostrarTodos().setEnabled(true);
            }
        });
    }

    /**
     * Adiciona evento para pesquisar missões pelo nome.
     */
    private void botaoPesquisarMissao() {
        janela.getPesquisarMissaoButton().addActionListener(e -> {
            String nomeBusca = JOptionPane.showInputDialog(janela, "Digite o nome da missão:");
            if (nomeBusca == null) {
                return;
            }

            if (nomeBusca.trim().isEmpty()) {
                atualizarTabelaMissoes(model.getMissoes());
                return;
            }

            List<Missao> encontradas = model.getMissoes().stream()
                    .filter(m -> m.getNome().toLowerCase().contains(nomeBusca.toLowerCase()))
                    .toList();

            if (encontradas.isEmpty()) {
                JOptionPane.showMessageDialog(janela, "Nenhuma missão encontrada.");
            } else {
                atualizarTabelaMissoes(encontradas);
                JOptionPane.showMessageDialog(janela, encontradas.size() + " missão(ões) encontrada(s).");
                janela.getMissoesMostrarTodas().setEnabled(true);
            }
        });
    }

    /**
     * Adiciona evento para salvar os dados dos moradores e das missões.
     */
    private void botaoSalvar(){
        janela.getSalvarButton().addActionListener(e -> {
            model.salvarMoradores();
            //adicionar aqui a lógica para salvar as missões
        });
    }

    /**
     * Adiciona evento para deletar todos os dados dos moradores e das missões.
     */
    private void botaoDeletarTodosOsDados(){
        janela.getDeletarTodosOsDadosButton().addActionListener(e -> {
            deletarMoradores();
            deletarMissoes();
            //adicionar aqui o método para deletar todas as missões
        });
    }

    /**
     * Adiciona evento para exibir todos os moradores na tabela.
     */
    private void atualizarTabelaMoradoresMostrarTodos(){
        janela.getMoradoresMostrarTodos().addActionListener(e -> {
            atualizarTabelaMoradores(model.getMoradores());
            janela.getMoradoresMostrarTodos().setEnabled(false);
        });
    }

    /**
     * Atualiza a tabela de moradores na interface com a lista fornecida.
     * @param moradores Lista de moradores a ser exibida.
     */
    private void atualizarTabelaMoradores(List<Morador> moradores){
        if(moradores == null)
            return;

        String[] colunas = {"Nome", "Idade", "Sexo", "Status", "Detalhes"};
        String[] colunasResumo = {"Nome", "Status", "Detalhes"};
        Object[][] dados = new Object[moradores.size()][colunas.length];
        Object[][] dadosResumo = new Object[moradores.size()][colunasResumo.length];

        for(int i = 0; i < moradores.size(); i++) {
            Morador morador = moradores.get(i);

            dados[i][0] = morador.getNome();
            dados[i][1] = morador.getIdade();
            dados[i][2] = morador.getSexo();
            dados[i][3] = morador.getStatus();

            if(morador instanceof Ninja)
                dados[i][4] = ((Ninja) morador).getTipo();

            else
                dados[i][4] = ((Civil) morador).getProfissao();

            dadosResumo[i][0] = dados[i][0];
            dadosResumo[i][1] = dados[i][3];
            dadosResumo[i][2] = dados[i][4];

        }

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(dados, colunas) {
            //criando um objedo do tipo DefaultTableModel para sobrescrever o método isCellEditable para impedir que
            // o texto das células da tabela sejam editáveis
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        janela.getTabelaMoradores().setModel(modelo);

        janela.getTabelaMoradoresResumo().setModel(new javax.swing.table.DefaultTableModel(dadosResumo, colunasResumo));
        janela.getNumPopulacao().setText(Integer.toString(model.getMoradores().size())); // atualiza o contador de moradores no resumo
    }

    /**
     * Adiciona evento para deletar todos os moradores.
     */
    private void botaoDeletarMoradores(){
        janela.getDeletarTodosMoradoresButton().addActionListener(e -> deletarMoradores());
    }

    /**
     * Remove todos os moradores do modelo e atualiza a tabela.
     */
    private void deletarMoradores(){
        model.getMoradores().clear();
        atualizarTabelaMoradores(model.getMoradores());
    }

    /**
     * Adiciona evento para remover um morador selecionado na tabela.
     */
    private void botaoRemoverMorador(){
        janela.getRemoverMoradorButton().addActionListener(e -> {
            int linhaSelecionada = janela.getTabelaMoradores().getSelectedRow();
            if(linhaSelecionada == -1){
                JOptionPane.showMessageDialog(janela, "Selecione um morador para remover.");
                return;
            }

            String nome = janela.getTabelaMoradores().getValueAt(linhaSelecionada, 0).toString();

            Morador moradorRemover =
                    model.getMoradores().stream().filter(m-> m.getNome().equals(nome)).findFirst().orElse(null);

            if(moradorRemover != null){
                model.removerMorador(moradorRemover);
                atualizarTabelaMoradores(model.getMoradores());
                JOptionPane.showMessageDialog(janela, "Morador removido com sucesso!");
            } else
                JOptionPane.showMessageDialog(janela, "Morador não encontrado.");


        });
    }

    /**
     * Adiciona evento para abrir o diálogo de adição de novo morador.
     */
    private void botaoAdicionarMorador(){
        janela.getAdicionarMoradorButton().addActionListener(e -> {
            inicializarTelaAdicionarMorador();
        });
    }

    /**
     * Inicializa e exibe a tela de diálogo para adicionar um novo morador.
     */
    private void inicializarTelaAdicionarMorador(){ //configurando o jdialog da tela de adicionar um novo morador
        DialogAdicionarMorador dialogAdicionarMorador = new DialogAdicionarMorador();

        atualizarVisibilidadeCampos(dialogAdicionarMorador);

        visibilidadeComboBox(dialogAdicionarMorador);
        botaoOk(dialogAdicionarMorador);
        botaoCancelar(dialogAdicionarMorador);

        dialogAdicionarMorador.pack();
        dialogAdicionarMorador.setVisible(true);
    }

    /**
     * Adiciona evento para alternar a visibilidade dos campos conforme o tipo de morador selecionado.
     * @param dialogAdicionarMorador Diálogo de adição de morador.
     */
    private void visibilidadeComboBox(DialogAdicionarMorador dialogAdicionarMorador){
        dialogAdicionarMorador.getTipoMorador().addActionListener(e -> {
            atualizarVisibilidadeCampos(dialogAdicionarMorador);
        });
    }

    /**
     * Atualiza a visibilidade dos campos de patente e profissão conforme o tipo de morador selecionado.
     * @param dialogAdicionarMorador Diálogo de adição de morador.
     */
    private void atualizarVisibilidadeCampos(DialogAdicionarMorador dialogAdicionarMorador){ // método para atualizar a visibilidade dos campos Patente do ninja e Profissão do civil
        String tipoSelecionado = (String) dialogAdicionarMorador.getTipoMorador().getSelectedItem();
        boolean ninja = "Ninja".equals(tipoSelecionado);

        dialogAdicionarMorador.getLabelPatente().setVisible(ninja);
        dialogAdicionarMorador.getTextTipoNinja().setVisible(ninja);

        dialogAdicionarMorador.getLabelProfissao().setVisible(!ninja);
        dialogAdicionarMorador.getTextProfissaoCivil().setVisible(!ninja);
    }

    /**
     * Adiciona evento ao botão OK do diálogo de adição de morador, realizando a validação e cadastro.
     * @param dialogAdicionarMorador Diálogo de adição de morador.
     */
    private void botaoOk(DialogAdicionarMorador dialogAdicionarMorador){
        dialogAdicionarMorador.getBotaoOK().addActionListener(e -> {
            String nome = dialogAdicionarMorador.getTextNome().getText();
            String idadeStr = dialogAdicionarMorador.getTextIdade().getText();

            if (nome == null || idadeStr == null || nome.trim().isEmpty() || idadeStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(dialogAdicionarMorador, "Preencha todos os campos obrigatórios.");
                return;
            }

            nome = nome.trim();
            idadeStr = idadeStr.trim();

            int idade;
            try {
                idade = Integer.parseInt(idadeStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialogAdicionarMorador, "Idade inválida.");
                return;
            }

            String sexoSelecionado = (String) dialogAdicionarMorador.getSexoMorador().getSelectedItem();

            Sexo sexo = "F".equals(sexoSelecionado)? Sexo.FEMININO : Sexo.MASCULINO;

            // se a patente está visível, é um ninja
            if(dialogAdicionarMorador.getLabelPatente().isVisible()){
                String strTipoNinja = (String) dialogAdicionarMorador.getTextTipoNinja().getSelectedItem();
                TipoNinja tipoNinja;

                switch(strTipoNinja){
                    case "GENIN":
                        tipoNinja = TipoNinja.GENIN;
                        break;
                    case "CHUUNIN":
                        tipoNinja = TipoNinja.CHUUNIN;
                        break;
                    case "JOUNIN":
                        tipoNinja = TipoNinja.JOUNIN;
                        break;
                    case "KAGE":
                        tipoNinja = TipoNinja.KAGE;
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de ninja inválido: " + strTipoNinja);
                }

                Ninja morador = new Ninja(nome, idade, sexo, Status.ATIVO, tipoNinja);
                model.adicionarMorador(morador);
            } else { // se a patente não está visível, é um civil
                String profissaoCivil = dialogAdicionarMorador.getTextProfissaoCivil().getText();

                if(profissaoCivil == null || profissaoCivil.isEmpty()){
                    JOptionPane.showMessageDialog(dialogAdicionarMorador, "Preencha todos os campos obrigatórios");
                    return;
                }

                Civil morador = new Civil(nome, idade, sexo, Status.ATIVO, profissaoCivil.trim());
                model.adicionarMorador(morador);
            }
            JOptionPane.showMessageDialog(dialogAdicionarMorador, "Morador adicionado com sucesso!");
            atualizarTabelaMoradores(model.getMoradores());
            dialogAdicionarMorador.dispose();
        });
    }

    /**
     * Adiciona evento ao botão Cancelar do diálogo de adição de morador.
     * @param dialogAdicionarMorador Diálogo de adição de morador.
     */
    private void botaoCancelar(DialogAdicionarMorador dialogAdicionarMorador){
        dialogAdicionarMorador.getBotaoCancelar().addActionListener(e -> {
            dialogAdicionarMorador.dispose();
        });
    }

    /**
     * Atualiza a tabela de missões na interface com a lista fornecida.
     * @param missoes Lista de missões a ser exibida.
     */
    private void atualizarTabelaMissoes(List<Missao> missoes) {
        if (missoes == null) return;

        String[] colunas = {"Nome", "Descrição", "Dificuldade"};
        Object[][] dados = new Object[missoes.size()][colunas.length];

        for (int i = 0; i < missoes.size(); i++) {
            Missao missao = missoes.get(i);
            dados[i][0] = missao.getNome();
            dados[i][1] = missao.getDescricao();
            dados[i][2] = missao.getDificuldade();
        }

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        janela.getTabelaMissoes().setModel(modelo);
        janela.getTabelaMissoesResumo().setModel(modelo); // Atualiza a tabela de resumo também
    }

    /**
     * Adiciona evento para remover uma missão selecionada na tabela.
     */
    private void botaoRemoverMissao() {
        janela.getRemoverMissaoButton().addActionListener(e -> {
            int linhaSelecionada = janela.getTabelaMissoes().getSelectedRow();
            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(janela, "Selecione uma missão para remover.");
                return;
            }

            String nome = janela.getTabelaMissoes().getValueAt(linhaSelecionada, 0).toString();
            Missao missaoRemover = model.getMissoes().stream()
                    .filter(m -> m.getNome().equals(nome))
                    .findFirst().orElse(null);

            if (missaoRemover != null) {
                model.removerMissao(missaoRemover); // Supondo que este método exista no Model
                atualizarTabelaMissoes(model.getMissoes());
                JOptionPane.showMessageDialog(janela, "Missão removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(janela, "Missão não encontrada.");
            }
        });
    }

    /**
     * Adiciona evento para deletar todas as missões.
     */
    private void botaoDeletarMissoes() {
        janela.getDeletarTodasMissoesButton().addActionListener(e -> deletarMissoes());
    }

    /**
     * Remove todas as missões do modelo e atualiza a tabela.
     */
    private void deletarMissoes() {
        model.getMissoes().clear();
        atualizarTabelaMissoes(model.getMissoes());
    }

    /**
     * Adiciona eventos relacionados à manipulação de missões.
     */
    private void botoesEventosMissao() {
        atualizarTabelaMissoes(model.getMissoes()); // Descomente esta linha
        botaoAdicionarMissao();
        botaoRemoverMissao();
        botaoDeletarMissoes();
        botaoPesquisarMissao();
        atualizarTabelaMissoesMostrarTodas();
        janela.getMissoesMostrarTodas().setEnabled(false);
    }

    /**
     * Adiciona evento para abrir o diálogo de adição de nova missão.
     */
    private void botaoAdicionarMissao() {
        janela.getAdicionarMissaoButton().addActionListener(e -> {
            inicializarTelaAdicionarMissao();
        });
    }

    /**
     * Inicializa e exibe a tela de diálogo para adicionar uma nova missão.
     */
    private void inicializarTelaAdicionarMissao() {
        DialogAdicionarMissao dialog = new DialogAdicionarMissao();
        botaoSalvarMissao(dialog);
        botaoCancelarMissao(dialog);
        dialog.pack();
        dialog.setVisible(true);
    }

    /**
     * Adiciona evento ao botão Salvar do diálogo de adição de missão.
     * @param dialog O diálogo de adição de missão.
     */
    private void botaoSalvarMissao(DialogAdicionarMissao dialog) {
        dialog.getBotaoSalvar().addActionListener(e -> {
            String nome = dialog.getTextNome().getText();
            String descricao = dialog.getTextDescricao().getText();

            if (nome == null || nome.trim().isEmpty() || descricao == null || descricao.trim().isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Preencha todos os campos.");
                return;
            }

            NivelMissoes dificuldade = NivelMissoes.valueOf((String) dialog.getComboNivelMissoes().getSelectedItem());

            Missao novaMissao = new Missao(nome.trim(), descricao.trim(), dificuldade);
            model.adicionarMissao(novaMissao); // Assumindo que o método existe no Model

            JOptionPane.showMessageDialog(dialog, "Missão adicionada com sucesso!");

            atualizarTabelaMissoes(model.getMissoes());
        });
    }

    /**
     * Adiciona evento ao botão Cancelar do diálogo de adição de missão.
     * @param dialog O diálogo de adição de missão.
     */
    private void botaoCancelarMissao(DialogAdicionarMissao dialog) {
        dialog.getBotaoCancelar().addActionListener(e -> {
            dialog.dispose();
        });
    }

    /**
     * Adiciona evento para exibir todas as missões na tabela.
     */
    private void atualizarTabelaMissoesMostrarTodas() {
        janela.getMissoesMostrarTodas().addActionListener(e -> {
            atualizarTabelaMissoes(model.getMissoes());
            janela.getMissoesMostrarTodas().setEnabled(false);
        });
    }
}
