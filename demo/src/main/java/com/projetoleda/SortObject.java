package com.projetoleda;

import com.projetoleda.funcoesDeOrdenacao.SortAlgorithm;
import com.projetoleda.csvUtil.CsvFile;
import com.projetoleda.csvUtil.CsvMetods;
import com.projetoleda.csvUtil.SortUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.projetoleda.EstruturasDinamicas.conjuntoDinamico.*;
import com.projetoleda.csvUtil.Arquivo;

public class SortObject {
    private Object tipoDaColuna;
    private SortAlgorithm algorithm;
    private String caminho;
    private String[] dadosCsv;
    private Object[] coluna;

    public SortObject(String arquivo, Object tipoDaColuna, SortAlgorithm algorithm){
        this.caminho = arquivo;
        this.tipoDaColuna = tipoDaColuna;
        this.algorithm = algorithm;

        openData();
        this.algorithm.setCsvLines(dadosCsv);
        this.algorithm.sort(coluna);
    }

    //abre o arquivo csv
    private void openData() {
        //por enquanto vai ser desse jeito mesmo depois eu arrumo...
        String[] colunaStr;

        CsvFile file = new CsvFile();

        ConjuntoDinamicoIF<String> arrayList = file.getAllLinesFrom(caminho);
        dadosCsv = CsvMetods.toStringArray(arrayList.toArray(1, arrayList.tamanho()-2));
        
        CsvMetods csvMetods = new CsvMetods(dadosCsv);
        colunaStr = csvMetods.getColuna(SortUtil.setColuna(tipoDaColuna)); // trocar no nome das variaveis coluna

        this.coluna = SortUtil.getArrayDeDados(tipoDaColuna, colunaStr);
    }

    public void printCsvLines() {
        for(int i = 0; i < dadosCsv.length; i++) {
            System.out.printf("\"%s\",\n",dadosCsv[i]);
        }
    }

    public void salvarArquivo(String filePath, boolean reversed) {
        String[] dadosCsvComPrimeiraLinha = inserirPrimeiraLinha();
        if(reversed){
            Arquivo.criarArquivoCsvRevesed(dadosCsvComPrimeiraLinha, filePath);
        }else{
            Arquivo.criarArquivoCsv(dadosCsvComPrimeiraLinha, filePath);
        }
    }

    private String[] inserirPrimeiraLinha() {
        String[] tempArray = new String[dadosCsv.length+1];
        tempArray[0] = "trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance";

        for(int i = 1; i < dadosCsv.length+1; i++) {
            tempArray[i] = dadosCsv[i-1];
        }
        return tempArray;
    }
}
