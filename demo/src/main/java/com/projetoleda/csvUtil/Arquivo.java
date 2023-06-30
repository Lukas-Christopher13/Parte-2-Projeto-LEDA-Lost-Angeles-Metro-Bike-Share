package com.projetoleda.csvUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    private static final String caminhoOndeOArquivoSeraSalvo = "/src/main/java/com/projetoleda/DadosCsvTratados";

    public static void criarArquivoCsv(String[] arrayCsv, String nomeDoArquivo) {
        try {
            tryCriarArquivoCsv(arrayCsv, nomeDoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo!");
        }
    }

    private static void tryCriarArquivoCsv(String[] arrayCsv, String nomeDoArquivo) throws IOException {
        File file = new File("");

        BufferedWriter bw = new BufferedWriter(new FileWriter(
            new File(file.getAbsolutePath() + caminhoOndeOArquivoSeraSalvo + nomeDoArquivo)));
        
        for(int i = 0; i < arrayCsv.length; i++){
            bw.write(arrayCsv[i]+"\n");
        }
        bw.close();
    }

    public static void criarArquivoCsvRevesed(String[] arrayCsv, String nomeDoArquivo) {
        try {
            tryCriarArquivoCsvRevesed(arrayCsv, nomeDoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo!");
        }
    }

    private static void tryCriarArquivoCsvRevesed(String[] arrayCsv, String nomeDoArquivo) throws IOException {
        File file = new File("");

        BufferedWriter bw = new BufferedWriter(new FileWriter(
            new File(file.getAbsolutePath() + caminhoOndeOArquivoSeraSalvo + nomeDoArquivo)));
        
            bw.write(arrayCsv[0]+"\n");
        for(int i = arrayCsv.length-2; i > 0; i--){
            bw.write(arrayCsv[i]+"\n");
        }
        bw.close();
    } 
}
