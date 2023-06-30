package com.projetoleda.funcoesDeOrdenacao;

import com.projetoleda.csvUtil.SortUtil;

public class SelectionSort implements SortAlgorithm {

    public String[] csvLines;

    public void sort(Object list[]) {
        int min;
        int i,j;

        for(i = 0; i < list.length; i++){
            min = i;
            for(j = i+1; j < list.length; j++){
                if(SortUtil.comparar(list[j],list[min]) < 0 ){  //list[j] < list[min]
                    min = j;
                }
            }
            Object temp = list[min];
            list[min] = list[i];
            list[i] = temp;

            //swap arquivo csv
            String Stemp = csvLines[min];
            csvLines[min] = csvLines[i];
            csvLines[i] = Stemp;
        }
    }

    @Override
    public void setCsvLines(String[] lines) {
        this.csvLines = lines;
    }
}
