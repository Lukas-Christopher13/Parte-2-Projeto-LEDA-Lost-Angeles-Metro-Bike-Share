package com.projetoleda.PassosParaTratarOArquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P2FiltrarStationName {
    
    public static void FiltrarPasadena(String inputFile, String outputFile, int[] selectedIndices, String filterString) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile);
            String line = reader.readLine();
            String[] headers = line.split(",");
            int[] selectedHeaders = new int[selectedIndices.length];
            String[] selectedHeadersNames = new String[selectedIndices.length];
            for (int i = 0; i < selectedIndices.length; i++) {
                int index = selectedIndices[i];
                selectedHeaders[i] = index;
                selectedHeadersNames[i] = headers[index];
            }
            writer.write(String.join(",", headers) + "\n");
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                boolean matchesFilter = false;
                for (int index : selectedHeaders) {
                    if (fields[index].matches(".*" + filterString + "\\s+\\w+.*")) {
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
            System.out.println("Arquivo gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler/gravar arquivo.");
            e.printStackTrace();
        }
    }

    public static void rodar(String inputFile, String outputFile) throws IOException {
       int[] valores = {9, 10};
       FiltrarPasadena(inputFile,outputFile,valores,"Pasadena");
    }
}

