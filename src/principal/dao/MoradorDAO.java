package principal.dao;

import principal.model.Morador;
import principal.model.Ninja;
import principal.model.Civil;
import principal.model.Sexo;
import principal.model.Status;
import principal.model.TipoNinja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoradorDAO {
    private final String ARQUIVO = "moradores.csv";

    public MoradorDAO() {
    }

    public void salvarMoradores(List<Morador> moradores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Morador morador : moradores) {
                if (morador instanceof Ninja) {
                    Ninja ninja = (Ninja) morador;
                    writer.write("Ninja;" + ninja.getNome() + ";" + ninja.getIdade() + ";" +
                            ninja.getSexo().name() + ";" + ninja.getStatus().name() + ";" + ninja.getTipo().name());
                } else if (morador instanceof Civil) {
                    Civil civil = (Civil) morador;
                    writer.write("Civil;" + civil.getNome() + ";" + civil.getIdade() + ";" +
                            civil.getSexo().name() + ";" + civil.getStatus().name() + ";" + civil.getProfissao());
                } else {
                    continue;
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Morador> carregarMoradores() {
        List<Morador> moradores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                try {
                    String[] partes = linha.split(";");
                    if (partes[0].equals("Ninja")) {
                        moradores.add(new Ninja(
                            partes[1],
                            Integer.parseInt(partes[2]),
                            Sexo.valueOf(partes[3]),
                            Status.valueOf(partes[4]),
                            TipoNinja.valueOf(partes[5])
                        ));
                    } else if (partes[0].equals("Civil")) {
                        moradores.add(new Civil(
                            partes[1],
                            Integer.parseInt(partes[2]),
                            Sexo.valueOf(partes[3]),
                            Status.valueOf(partes[4]),
                            partes[5]
                        ));
                    }
                } catch (Exception ex) {
                    System.err.println("Linha ignorada por erro de formatação: " + linha);
                }
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Arquivo 'moradores.csv' não encontrado. Será criado ao salvar.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return moradores;
    }
}