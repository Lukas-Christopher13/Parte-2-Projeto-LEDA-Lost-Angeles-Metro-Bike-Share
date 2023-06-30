package com.projetoleda.csvUtil;

import java.time.LocalDateTime;

public class SortUtil {
    
    public static Integer[] toIntArray(String[] strArray) {
        Integer[] intArray = new Integer[strArray.length];

        for(int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static LocalDateTime[] toDateTime(String[] strArray) {
        LocalDateTime[] datas = new LocalDateTime[strArray.length];

        for(int i = 0; i < strArray.length; i++) {
            String[] dataSplit = strArray[i].split("[/: ]");

            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1]);
            int ano = Integer.parseInt(dataSplit[2]);
            int hora = Integer.parseInt(dataSplit[3]);
            int minuto = Integer.parseInt(dataSplit[4]);

            datas[i] = LocalDateTime.of(ano,mes,dia,hora,minuto);
        }
        return datas;
    }
    
    public static int comparar(Object valor1, Object valor2) {
		if(valor1 instanceof Integer) {
			Integer valorInteger = (Integer) valor1;
		    return valorInteger.compareTo((Integer) valor2);
		
		} else if(valor1 instanceof String) {
			String valorString = (String) valor1;
			return valorString.compareTo((String) valor2);
		} else {
			LocalDateTime localDateTimeString = (LocalDateTime) valor1;
			return localDateTimeString.compareTo((LocalDateTime) valor2);
		}    
	}

    public static Object[] getArrayDeDados(Object tipoDeClass, String[] colunaDeDados) {
        if(tipoDeClass == Integer.class) {
            return toIntArray(colunaDeDados);
        
        } else if(tipoDeClass == LocalDateTime.class) {
            return toDateTime(colunaDeDados);
        
        }else {
            return colunaDeDados;
        }
    }

    public static int setColuna(Object tipObject) {
        if(tipObject == Integer.class) {
            return 1;
        } else if(tipObject == String.class) {
            return 9;
        }else{
            return 2;
        }
    }
}



