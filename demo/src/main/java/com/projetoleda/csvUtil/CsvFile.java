package com.projetoleda.csvUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import com.projetoleda.EstruturasDinamicas.conjuntoDinamico.*;

public class CsvFile {

    private ConjuntoDinamicoIF<String> arrayList;

    public CsvFile() {
        this.arrayList = new MeuConjuntoDinamico<>();
    }

    public ConjuntoDinamicoIF<String> getAllLinesFrom(String path) {
        File f = new File("");

        path = f.getAbsolutePath() + path;
        lerArquivo(path);
        return arrayList;
    }

    //Graças a Lista dinamica conseguimos enxugar o codigo, não sendo mais necessario utilizar funções para ler
    //a quantidade de linhas do arquivo 
  
    public void lerArquivo(String path){
        try {
            tryLerArquivo(path);
        } catch (IOException ex) {
            System.err.println("Erro ao tentar ler o arquivo!");
        }
    }

    private void tryLerArquivo(String path) throws IOException { 
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String linha = "";

        while(linha != null){
            linha = bufferedReader.readLine();
            arrayList.inserir(linha);
        }
        bufferedReader.close();
    }
}
