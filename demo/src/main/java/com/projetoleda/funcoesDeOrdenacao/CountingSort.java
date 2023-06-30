package com.projetoleda.funcoesDeOrdenacao;

public class CountingSort implements SortAlgorithm{

    public String[] csvLines;

    public void sort(Object[] lista) {
        if(!(lista instanceof Integer[])) {
            return;
        }

        Integer[] list = (Integer[]) lista;

        int tamanho = list.length;

        // Encontrar o maior valor na lista
        int max = list[0];
        for (int i = 1; i < tamanho; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }

        // Inicializar o array de contagem com zeros
        int[] count = new int[max + 1];
        for (int i = 0; i <= max; ++i) {
            count[i] = 0;
        }

        // Contar a quantidade de elementos iguais em list
        for (int i = 0; i < tamanho; i++) {
            count[list[i]]++;
        }

        // Contar a quantidade de elementos menores ou iguais a cada elemento
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Criar o array de saída
        int[] sortedList = new int[tamanho];
        String[] sortedCsvLines = new String[tamanho];

        // Ordenar os elementos e preencher o array de saída
        for (int i = tamanho - 1; i >= 0; i--) {
            sortedList[count[list[i]] - 1] = list[i];
            sortedCsvLines[count[list[i]] - 1] = csvLines[i];
            count[list[i]]--;
        }

        // Copiar o array de saída para o array original
        for (int i = 0; i < tamanho; i++) {
            list[i] = sortedList[i];
            csvLines[i] = sortedCsvLines[i];
        }
    }


    @Override
    public void setCsvLines(String[] lines) {
       this.csvLines = lines;
    }
}
