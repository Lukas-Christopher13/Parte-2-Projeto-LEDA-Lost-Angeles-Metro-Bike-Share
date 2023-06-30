package com.projetoleda.funcoesDeOrdenacao;

import com.projetoleda.csvUtil.SortUtil;

public class InsertionSort implements SortAlgorithm {

    private String[] csvLines;

    public void sort(Object[] list){
        Object aux;
        String auxString;
        int i,j;

        //O dois no 'i' é porque todo lista de datas tem o primeiro elemento null
        for(i = 1; i < list.length; i++){
            j = i -1;
            aux = list[i];
            auxString = csvLines[i]; 
            while(j >= 0 && SortUtil.comparar(aux,(list[j])) < 0){ // aux < list[j]
                list[j+1] = list[j];
                //para o csv
                csvLines[j+1] = csvLines[j];
                j--;
            }
            list[j+1] = aux;
            //para o csv
            csvLines[j+1] = auxString;
        }
    }

    @Override
    public void setCsvLines(String[] lines) {
       this.csvLines = lines;
    }
}