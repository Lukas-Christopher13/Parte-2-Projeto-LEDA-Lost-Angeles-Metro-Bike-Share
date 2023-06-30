package com.projetoleda.csvUtil;

public class CsvMetods {

    public String[] dadosCSV;
    public String[] colunaFiltrada;
    
    public CsvMetods(String[] dadosCSV) {
        this.dadosCSV = dadosCSV;
        this.colunaFiltrada = new String[dadosCSV.length];//-1
    }
    
    //Recebe a posição da coluna de 0 até 9... eu acho..
    public String[] getColuna(int posicaoDaColuna){
        
        for(int i = 0; i < dadosCSV.length; i++){ //subitrai 1 por conta do problema do null
            if(dadosCSV[i] == null) {
                continue;
            }
            String[] temp = dadosCSV[i].split(",");
            colunaFiltrada[i] = temp[posicaoDaColuna];
        }
        return colunaFiltrada.clone();
    }

    //vamos utilizar isso aqui na hora de atualizar os valores apos o sort!
    public void setColuna(String[] coluna, int posicaoDaColuna) {
        Linha atualizarLinha = new Linha(posicaoDaColuna);

        for(int i = 0; i < dadosCSV.length; i++){
            dadosCSV[i] = atualizarLinha.atualizarLinha(dadosCSV[i], coluna[i]);
        }
    }

    public static String[] toStringArray(Object[] array) {
		String[] strArray = new String[array.length];
		
		for(int i  = 0; i < array.length; i++) {
			strArray[i] = (String) array[i];
		}
		return strArray;
	}
}
