package principal.dao;

import principal.model.Missao;
import principal.model.NivelMissoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso e persistência dos dados das missões.
 * Permite salvar e carregar informações de missões em um arquivo CSV.
 * @author Giovanni Estevam dos Santos
 * @author João Vitor Lopes Fagundes
 * @author Pedro Ricoy de Oliveira e Silva
 * @author Wescley Júnior Gonçalves Navarro
 */
public class MissaoDAO {
    private final String ARQUIVO = "missoes.csv";

    /**
     * Construtor padrão da classe MissaoDAO.
     */
    public MissaoDAO() {
    }

    /**
     * Salva a lista de missões no arquivo CSV.
     * @param missoes Lista de missões a ser salva.
     */
    public void salvarMissoes(List<Missao> missoes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Missao missao : missoes) {
                writer.write(missao.getNome() + ";" + missao.getDescricao() + ";" + missao.getDificuldade().name());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega a lista de missões a partir do arquivo CSV.
     * Linhas com erro de formatação são ignoradas.
     * @return Lista de missões carregada do arquivo.
     */
    public List<Missao> carregarMissoes() {
        List<Missao> missoes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                try {
                    String[] partes = linha.split(";");
                    if (partes.length == 3) {
                        String nome = partes[0];
                        String descricao = partes[1];
                        NivelMissoes dificuldade = NivelMissoes.valueOf(partes[2]);
                        missoes.add(new Missao(nome, descricao, dificuldade));
                    }
                } catch (Exception ex) {
                    System.err.println("Linha ignorada por erro de formatação: " + linha);
                }
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Arquivo 'missoes.csv' não encontrado. Será criado ao salvar.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return missoes;
    }
}