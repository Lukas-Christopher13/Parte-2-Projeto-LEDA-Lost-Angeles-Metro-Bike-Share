package com.projetoleda.Interface;
//Esse arquivo gera dois arquivos com o melhor, e pior
//caso para a ordenação.
import java.time.LocalDateTime;

import com.projetoleda.SortObject;
import com.projetoleda.EstruturasDinamicas.HashMap.MyHashMap;
import com.projetoleda.funcoesDeOrdenacao.MergeSort;

public class GerarCasos {
    private final String LAMetroTrips = "/src/main/java/com/projetoleda/DadosCsvTratados/LAMetroTrips.csv";
    private MyHashMap<Object,String> myHashMap;

    public GerarCasos() {
        myHashMap = new MyHashMap<>(11);

        myHashMap.put(Integer.class, "duration");
        myHashMap.put(String.class, "station");
        myHashMap.put(LocalDateTime.class, "start_time");
    }

    public void gerarTabelComTodosOsCasosPor(Object classe) {
        final String melhorCaso = String.format("/csvMelhorPiorEMedioCaso/LAMetroTrips_%s_melhorCaso.csv", myHashMap.get(classe)) ;
        final String piorCaso = String.format("/csvMelhorPiorEMedioCaso/LAMetroTrips_%s_piorCaso.csv", myHashMap.get(classe));

        SortObject sortObject = new SortObject(
            LAMetroTrips, 
            classe, 
            new MergeSort()
        );

        if(classe == LocalDateTime.class) {
            sortObject.salvarArquivo(melhorCaso, true);
            sortObject.salvarArquivo(piorCaso, false);
        }else {
            sortObject.salvarArquivo(melhorCaso, false);
            sortObject.salvarArquivo(piorCaso, true);
        }
       
        System.out.printf("Pior e Melhor casos por %s foram gerados!\n", myHashMap.get(classe));  
    }
}
