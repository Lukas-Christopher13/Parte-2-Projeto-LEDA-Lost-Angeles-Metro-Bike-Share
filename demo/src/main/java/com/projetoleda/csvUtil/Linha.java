package com.projetoleda.csvUtil;

public class Linha {

    private int posicao;
    private String[] listaDeDados;

    public Linha(int posicaoNalinhaASerAtualizada) {
        this.posicao = posicaoNalinhaASerAtualizada;
    }

    public String atualizarLinha (String linha, String palavra) {
        listaDeDados = linha.split(",");
        listaDeDados[posicao] = palavra;

        return toStringComVigulas();
    }
     
    private String toStringComVigulas() {
        String linhaComVirgulas = listaDeDados[0];

        for(int i = 1; i < listaDeDados.length; i++){
            linhaComVirgulas += "," + listaDeDados[i];
        }

        return linhaComVirgulas;
    }
    
}
