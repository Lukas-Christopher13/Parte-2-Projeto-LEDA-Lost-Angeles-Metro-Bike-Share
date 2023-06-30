package com.projetoleda.PassosParaTratarOArquivo;

//Obs: durante a analise do arquivo percebi que alugumas datas estavam com o mês
//e o dia trocados. Tentei de alguma forma contrariar o problema porem consegui apenas
//minimisa-lo

//datas nesse formato 5/3/2018 estão com o mes e dia trocado 
//datas nesse formato 05/03/2018 não estão corretas
//Há datas do tipo 7/18/2018

public class P0ConcertarDatas {

    private String[] coluna;

    public P0ConcertarDatas(String[] coluna ) {
        this.coluna = coluna;
    }

    public String[] corrigirDatas() {
        for(int i = 1; i < coluna.length; i++){
            coluna[i] = trocarDiaPorMes(coluna[i]);
            if(isInvalidDate(coluna[i])){
                //coluna[i] = returnValidDate(coluna[i].split("[/: ]"));
                coluna[i] = trocarDiaPorMes(coluna[i]);
            }
        }
        return coluna;
    }

    public static boolean isInvalidDate(String data) {
        String[] splitedDate = data.split("[/: ]");

        String dia = splitedDate[0];
        String mes = splitedDate[1];

         if(Integer.parseInt(mes) > 12) {
            return true;
        }else{
            return false;
        }
    }

    public static String returnValidDate (String[] invalidDate) {
        String validDate;

        if(invalidDate[0].length() == 1){
            invalidDate[0] = "0" + invalidDate[0];
        }

        if(invalidDate[1].length() == 1){
            invalidDate[1] = "0" + invalidDate[1];
        }

        //swap mes e dia
        String temp = invalidDate[1];
        invalidDate[1] = invalidDate[0];
        invalidDate[0] = temp;
        
        validDate = invalidDate[0] + "/" + invalidDate[1] + "/" + invalidDate[2] +
        " " + invalidDate[3] + ":" + invalidDate[4];   

        return validDate;
    }

    public String trocarDiaPorMes(String data) {
        String[] splitData = data.split("/");
        
        return splitData[1] + "/" + splitData[0] + "/" + splitData[2]; 
    }
}
