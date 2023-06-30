package com.projetoleda;
//minhas classes
import com.projetoleda.PassosParaTratarOArquivo.P0ConcertarDatas;
import com.projetoleda.PassosParaTratarOArquivo.P1SubistituirId;
import com.projetoleda.csvUtil.CsvFile;
import com.projetoleda.csvUtil.Arquivo;
import com.projetoleda.csvUtil.CsvMetods;
import com.projetoleda.EstruturasDinamicas.conjuntoDinamico.*;
import java.util.Arrays;

public class PrepararODateSet {
    
    private final String registroDeLocacaoFile = "/src/main/java/com/projetoleda/DadosCsv/LA_Metro_BikeSharing_CLEANED_2016quater3-2021q3.csv";
    private final String estcoesPorIdFile = "/src/main/java/com/projetoleda/DadosCsv/stations.csv";

    private String[] registroDeLocacaoDeBicicletas;
    private String[] estacoesCsv;
    private ConjuntoDinamicoIF<String> arrayList;

    public PrepararODateSet(){
        CsvFile fileCsv = new CsvFile();
        CsvFile fileStation = new CsvFile();
        
        this.arrayList = fileCsv.getAllLinesFrom(registroDeLocacaoFile);
        this.registroDeLocacaoDeBicicletas = CsvMetods.toStringArray(arrayList.toArray());

        this.arrayList = fileStation.getAllLinesFrom(estcoesPorIdFile);
        this.estacoesCsv = CsvMetods.toStringArray(arrayList.toArray());
        this.registroDeLocacaoDeBicicletas = Arrays.copyOf(registroDeLocacaoDeBicicletas, registroDeLocacaoDeBicicletas.length-1);
        concertarDatas();
    }
    
    //Esse trecho de coidigo "corrige" o problemas das datas, ou devia corrigir...
    private void concertarDatas(){
        CsvMetods conDat = new CsvMetods(registroDeLocacaoDeBicicletas);

        String[] startDate = conDat.getColuna(2); //criar uma constante dps
        String[] endDate = conDat.getColuna(3);

        P0ConcertarDatas corrigirStartDatas = new P0ConcertarDatas(startDate);
        String[] startDateCorrigido =  corrigirStartDatas.corrigirDatas();

        P0ConcertarDatas corrigeirEndDatas = new P0ConcertarDatas(endDate);
        String[] endDateCorrigido = corrigeirEndDatas.corrigirDatas();

        CsvMetods csvMetods = new CsvMetods(registroDeLocacaoDeBicicletas);
        csvMetods.setColuna(startDateCorrigido, 2);
        csvMetods.setColuna(endDateCorrigido, 3);
    }

    public void subistituirIdPelasEstacoes() {
        P1SubistituirId subId = new P1SubistituirId(registroDeLocacaoDeBicicletas, estacoesCsv);
        
        subId.subistituirIdPorEstcoes();
        Arquivo.criarArquivoCsv(registroDeLocacaoDeBicicletas, "/LAMetroTrips.csv");
        
        System.out.println("Arquivo gerado!");
    }    
}
