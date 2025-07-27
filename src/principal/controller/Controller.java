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

public class Controller {
    private final Model model;
    private final Janela janela;

    public Controller(Model model, Janela janela) {
        this.model = model;
        this.janela = janela;
        adicionarEventosBotoes();
    }

    // Adicionando eventos nos botões de mudança de tela e logica de controle de mudança de panels
    private void adicionarEventosBotoes() {
        botoesEventosMenuLateral();
        botoesEventosMorador();
        botaoSalvar();
    }

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

    private void botoesEventosMorador(){
        atualizarTabelaMoradores(model.getMoradores()); //inicializa a tabela com todos os moradores

        botaoAdicionarMorador();
        botaoRemoverMorador();
        botaoPesquisarMorador();
        atualizarTabelaMoradoresMostrarTodos();
    }

    private void botaoPesquisarMorador(){
        janela.getPesquisarButton().addActionListener(e -> {
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

    private void botaoSalvar(){
        janela.getSalvarButton2().addActionListener(e -> {
            model.salvarMoradores();
        });
    }

    private void atualizarTabelaMoradoresMostrarTodos(){
        janela.getMoradoresMostrarTodos().addActionListener(e -> {
            atualizarTabelaMoradores(model.getMoradores());
            janela.getMoradoresMostrarTodos().setEnabled(false);
        });
    }

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

        janela.getTabelaMoradores2().setModel(new javax.swing.table.DefaultTableModel(dadosResumo, colunasResumo));
        janela.getNumPopulacao().setText(Integer.toString(model.getMoradores().size())); // atualiza o contador de moradores no resumo
    }

    private void botaoRemoverMorador(){
        janela.getRemoverButton().addActionListener(e -> {
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

    private void botaoAdicionarMorador(){
        janela.getAdicionarButton().addActionListener(e -> {
            inicializarTelaAdicionarMorador();
        });
    }

    private void inicializarTelaAdicionarMorador(){ //configurando o jdialog da tela de adicionar um novo morador
        DialogAdicionarMorador dialogAdicionarMorador = new DialogAdicionarMorador();

        atualizarVisibilidadeCampos(dialogAdicionarMorador);

        visibilidadeComboBox(dialogAdicionarMorador);
        botaoOk(dialogAdicionarMorador);
        botaoCancelar(dialogAdicionarMorador);

        dialogAdicionarMorador.pack();
        dialogAdicionarMorador.setVisible(true);
    }

    private void visibilidadeComboBox(DialogAdicionarMorador dialogAdicionarMorador){
        dialogAdicionarMorador.getTipoMorador().addActionListener(e -> {
            atualizarVisibilidadeCampos(dialogAdicionarMorador);
        });
    }

    private void atualizarVisibilidadeCampos(DialogAdicionarMorador dialogAdicionarMorador){ // método para atualizar a visibilidade dos campos Patente do ninja e Profissão do civil
        String tipoSelecionado = (String) dialogAdicionarMorador.getTipoMorador().getSelectedItem();
        boolean ninja = "Ninja".equals(tipoSelecionado);

        dialogAdicionarMorador.getLabelPatente().setVisible(ninja);
        dialogAdicionarMorador.getTextTipoNinja().setVisible(ninja);

        dialogAdicionarMorador.getLabelProfissao().setVisible(!ninja);
        dialogAdicionarMorador.getTextProfissaoCivil().setVisible(!ninja);
    }

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

    private void botaoCancelar(DialogAdicionarMorador dialogAdicionarMorador){
        dialogAdicionarMorador.getBotaoCancelar().addActionListener(e -> {
            dialogAdicionarMorador.dispose();
        });
    }
}
