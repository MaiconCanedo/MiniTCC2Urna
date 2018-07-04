package br.gov.tse.urna.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Maicon Canedo
 */
public class ManipuladorDeArquivo {

    /*
    System.getProperty("user.dir"); - Diretório de trabalho atual do usuário
    System.getProperty("user.home"); - Diretório pessoal do usuário
    System.getProperty("user.name"); - Nome da conta de usuário
     */
    public int getNLinha() throws IOException, InterruptedException {
        int n = 0;
        BufferedReader ler = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/codigo.txt"));
        if (ler.toString().trim().length() > 0) {
            n = Integer.parseInt(ler.readLine().trim());
            ler.close();
        }

        return n;
    }

    public void setNLinha(int n) throws IOException {
        BufferedWriter escrever = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/codigo.txt"));
        escrever.append(String.valueOf(n));
        escrever.close();
    }

    public void excluirArquivo() {
        File arquivo = new File(System.getProperty("user.dir") + "/codigo.txt");
        if (arquivo.exists()) {
            arquivo.deleteOnExit();
        }
    }

    public void criarAquivo() throws IOException {
        File arquivo = new File(System.getProperty("user.dir") + "/codigo.txt");
        if (!arquivo.exists()) {
            arquivo.createNewFile();
            BufferedWriter escrever = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/codigo.txt"));
            escrever.append("0");
            escrever.close();
        }
    }
}