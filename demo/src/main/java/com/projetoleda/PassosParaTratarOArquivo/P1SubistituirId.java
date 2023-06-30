package com.projetoleda.PassosParaTratarOArquivo;
import java.util.Arrays;

import com.projetoleda.csvUtil.CsvMetods;

public class P1SubistituirId {
    private final int start_station  = 9;
    private final int end_station = 10;
    private final int station_id = 0;
    private final int station_name = 1;

    private String[] registroBicicletasCsv;
    private String[] estacaoCsv;

    private String[] start_stationId;
    private String[] end_StationId;

    private String[] idDasEstacoes;
    private String[] nomesDasEstacoes;

    public P1SubistituirId(String[] registroBicicletasCsv, String[] estacaoCsv) {
        this.registroBicicletasCsv = registroBicicletasCsv;
        this.estacaoCsv = estacaoCsv;
        carregarColunas();
    }

    private void carregarColunas(){
        CsvMetods csvMetodsBicleta = new CsvMetods(registroBicicletasCsv);
        CsvMetods csvMetodsEtacoes = new CsvMetods(estacaoCsv);

        start_stationId = csvMetodsBicleta.getColuna(start_station);
        end_StationId = csvMetodsBicleta.getColuna(end_station);

        idDasEstacoes = csvMetodsEtacoes.getColuna(station_id);
        nomesDasEstacoes = csvMetodsEtacoes.getColuna(station_name);
    }

    public void subistituirIdPorEstcoes() {
        subistituirStartStation();
        subistituirEndStation();

        CsvMetods csvMetods = new CsvMetods(registroBicicletasCsv);
        
        csvMetods.setColuna(start_stationId, start_station);
        csvMetods.setColuna(end_StationId, end_station);
    }

    //terminar....
    private void subistituirStartStation(){
        for(int i = 1; i < start_stationId.length; i++){
            int linha = Arrays.binarySearch(idDasEstacoes, start_stationId[i]);
            //alguns ids são invalidos
            if(linha < 0 ){
                start_stationId[i] = "!!! Local Invalido " + start_stationId[i];
                continue;
            }
            start_stationId[i] = nomesDasEstacoes[linha];
        }
    }

    private void subistituirEndStation () {
        for(int i = 1; i < end_StationId.length; i++){
            int linha = Arrays.binarySearch(idDasEstacoes, end_StationId[i]);
            //alguns ids são invalidos
            if(linha < 0 ){
                end_StationId[i] = "!!! Local Invalido " + end_StationId[i];
                continue;
            }
            end_StationId[i] = nomesDasEstacoes[linha];
        }
    }
}
