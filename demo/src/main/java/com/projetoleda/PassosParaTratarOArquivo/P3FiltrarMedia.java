package com.projetoleda.PassosParaTratarOArquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class P3FiltrarMedia {
    
    public static BufferedReader lerArquivo() {
        File caminho = new File("");

        String inputFile = caminho.getAbsolutePath() + "/src/main/java/com/projetoleda/DadosCsv/LA_Metro_BikeSharing_CLEANED_2016quater3-2021q3.csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            return reader;
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo/Escrever arquivo.");
            e.printStackTrace();
            return null;
        }
    }

    public static double calcularMedia() throws IOException {
        int[] selectedIndices = {1};
        BufferedReader reader = lerArquivo();
        int quantidade = 0;
        int somatoria = 0;

        String line = reader.readLine();
        // Separando os nomes das colunas em um array.
        String[] headers = line.split(",");
        // Criando um array para armazenar os índices selecionados das colunas.
        int[] selectedHeaders = new int[selectedIndices.length];
        // Percorrendo o array de índices selecionados.
        for (int i = 0; i < selectedIndices.length; i++) {
            int index = selectedIndices[i];
            // Armazenando o índice da coluna selecionada.
            selectedHeaders[i] = index;
        }

        // Lendo as linhas restantes do arquivo de entrada.
        while ((line = reader.readLine()) != null) {
            // Separando os campos da linha em um array.
            String[] fields = line.split(",");

            // Percorrendo os índices das colunas selecionadas.
            for (int index : selectedHeaders) {
                // Somando o valor da coluna atual à variável somatoria.
                somatoria += Integer.parseInt(fields[index]);
            }
            quantidade += 1;
        }

        // Calculando a média da coluna de duration.
        double mediaDuration = (double) somatoria / quantidade;
        reader.close();
        return mediaDuration;
    }
    public static void filtrarArquivo(Double media) throws IOException{
        File f = new File("");
        String outputFile = f.getAbsolutePath() + "/src/main/java/com/projetoleda/DadosCsvTratados/DadosComDuraçãoMaiorQueAMedia.csv"; 
        BufferedReader reader = lerArquivo();
        FileWriter writer = new FileWriter(outputFile);
        int[] selectedIndices = {1};
        String line = reader.readLine();
        // Separando os nomes das colunas em um array.
        String[] headers = line.split(",");
        // Criando um array para armazenar os índices selecionados das colunas.
        int[] selectedHeaders = new int[selectedIndices.length];
        // Percorrendo o array de índices selecionados.
        for (int i = 0; i < selectedIndices.length; i++) {
            int index = selectedIndices[i];
            // Armazenando o índice da coluna selecionada.
            selectedHeaders[i] = index;
        }
        // Gravando as colunas selecionadas no arquivo de saída.
        writer.write(String.join(",", headers) + "\n");
        // Lendo as linhas restantes do arquivo de entrada.
        while ((line = reader.readLine()) != null) {
            // Separando os campos da linha em um array.
            String[] fields = line.split(",");
            boolean matchesFilter = false;
            // Percorrendo os índices das colunas selecionadas.
            for (int index : selectedHeaders) {
                // Verificando se o valor da coluna atual é maior que a média.
                if (Integer.parseInt(fields[index]) > media) {
                    matchesFilter = true;
                    break;
                }
            }
            if (matchesFilter) {
                String selectedFields = "";
                for (int i = 0; i < selectedIndices.length; i++) {
                    int index = selectedIndices[i];
                    selectedFields += fields[index] + ",";
                }
                writer.write(line + "\n");
            }
        }
        reader.close();
        writer.close();
    }
    
    public static void rodar() throws IOException {
        filtrarArquivo(calcularMedia());
    }
}    