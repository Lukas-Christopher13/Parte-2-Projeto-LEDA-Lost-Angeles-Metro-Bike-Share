package com.projetoleda.Interface;

import java.time.LocalDateTime;

import com.projetoleda.SortObject;
import com.projetoleda.EstruturasDinamicas.HashMap.MyHashMap;
import com.projetoleda.funcoesDeOrdenacao.SortAlgorithm;

import com.projetoleda.funcoesDeOrdenacao.CountingSort;
import com.projetoleda.funcoesDeOrdenacao.HeapSort;
import com.projetoleda.funcoesDeOrdenacao.InsertionSort;
import com.projetoleda.funcoesDeOrdenacao.MergeSort;
import com.projetoleda.funcoesDeOrdenacao.SelectionSort;
import com.projetoleda.funcoesDeOrdenacao.Quicksort;
import com.projetoleda.funcoesDeOrdenacao.QuicksortM3;
 
public class GerarArquivosOrdenados {
    
    private MyHashMap<Integer, Object> seletorDeClass;
    private MyHashMap<Integer, String[]> seletorDeArquivo;
    private MyHashMap<Integer, SortAlgorithm> seletorDeAlgoritmo;

    public GerarArquivosOrdenados() {
        seletorDeClass = new MyHashMap<>(10);
        seletorDeArquivo = new MyHashMap<>(15);
        seletorDeAlgoritmo = new MyHashMap<>(15);

        carregarClasses();
        carregarArquivos();
        carregarAlgoritimos();
    }

    private void carregarClasses() {
        seletorDeClass.put(1, Integer.class);
        seletorDeClass.put(2, String.class);
        seletorDeClass.put(3, LocalDateTime.class);
    }

    private void carregarArquivos() {
        String medioCaso = "/src/main/java/com/projetoleda/DadosCsvTratados/LAMetroTrips.csv"; 

        String[] durationFile = {
            "/src/main/java/com/projetoleda/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips_duration_melhorCaso.csv",
            medioCaso,
            "/src/main/java/com/projetoleda/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips_duration_piorCaso.csv",
        };

        String[] stationFile = {
            "/src/main/java/com/projetoleda/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips_station_melhorCaso.csv",
            medioCaso,
            "/src/main/java/com/projetoleda/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips_station_piorCaso.csv"
        };

        String[] startTimeFile = {
            "/src/main/java/com/projetoleda/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips_start_time_melhorCaso.csv",
            medioCaso,
            "/src/main/java/com/projetoleda/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips_start_time_piorCaso.csv"
        };

        seletorDeArquivo.put(1, durationFile);
        seletorDeArquivo.put(2, stationFile);
        seletorDeArquivo.put(3, startTimeFile);
    }

    private void carregarAlgoritimos() {
        seletorDeAlgoritmo.put(1, new Quicksort());
        seletorDeAlgoritmo.put(2, new QuicksortM3());
        seletorDeAlgoritmo.put(3, new HeapSort());
        seletorDeAlgoritmo.put(4, new MergeSort());
        seletorDeAlgoritmo.put(5, new InsertionSort());
        seletorDeAlgoritmo.put(6, new SelectionSort());
        seletorDeAlgoritmo.put(7, new CountingSort());
    }

    public void montarSortObject(Integer campo, Integer caso, Integer algoritimo) {
        SortObject sortObject = new SortObject(
            seletorDeArquivo.get(campo)[caso-1],
            seletorDeClass.get(campo),
            seletorDeAlgoritmo.get(algoritimo)
        );
        String caminho = "/csvDadosOrdenados" + montarNomeDoArquivo(campo, caso, algoritimo);
        
        sortObject.salvarArquivo(caminho, false);
    }

    public String montarNomeDoArquivo(Integer campo, Integer caso, Integer algoritimo) {
        String nomeDoArquivo = "/LAMetroTrips_";

        MyHashMap<Integer, String> campoCsv = new MyHashMap<>(10);
        campoCsv.put(1, "duration_");
        campoCsv.put(2, "station_");
        campoCsv.put(3, "start_time_");

        MyHashMap<Integer, String> tipoDeCaso = new MyHashMap<>(10);
        tipoDeCaso.put(1, "_melhorCaso" );
        tipoDeCaso.put(2, "_medioCaso");
        tipoDeCaso.put(3, "_piorCaso" );

        String tipoDeAlgoritimo =  seletorDeAlgoritmo.get(algoritimo).getClass().getSimpleName();

        nomeDoArquivo += campoCsv.get(campo) + tipoDeAlgoritimo + tipoDeCaso.get(caso) + ".csv";

        return nomeDoArquivo;
    }
}
