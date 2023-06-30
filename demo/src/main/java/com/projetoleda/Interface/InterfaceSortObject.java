package com.projetoleda.Interface;

import java.util.Scanner;

public class InterfaceSortObject {
	private Scanner input = new Scanner(System.in);
	
	public static void pausa(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
            System.err.println("Erro ao pausar a Thread");
        }
    }
	
    public void selecionarDadosParaCriaçãoDoSortObjetct() {
    	System.out.println("RODOU");
       //GerarCasos gerarCasos = new GerarCasos();
    	
       //gerarCasos.gerarTabelComTodosOsCasosPor(Integer.class);
       //gerarCasos.gerarTabelComTodosOsCasosPor(String.class);
       //gerarCasos.gerarTabelComTodosOsCasosPor(LocalDateTime.class);
    	 int resArquivo = 0;
    	 int resAlgoritmo = 0;
    	 int resCaso = 0;
    	 System.out.print("\033[H\033[2J");
    	 String nome = "ian";
    	 System.out.println("Teste" + nome.getClass().getName());
    	 while(resArquivo > 3 || resArquivo < 1) {
    		 System.out.println("Digite...");
    		 
             System.out.println("ESCOLHA QUE TIPO DE ARQUIVO VOCÊ QUER ORDENAR: \n"
                		+  "1) - Por duração de viagem\n" 
                		+  "2) - Por nome da estação \n"
                		+  "3) - Por data da viagem \n");
             
            resArquivo = input.nextInt();
            if(resArquivo < 1 || resArquivo > 3) {
            	System.out.println("ERRO!! Digite apenas valores entre 1 -> 3\n\n\n\n");
            	pausa(3000);
            }
    	 }
    	 
    	 while(resCaso > 3 || resCaso < 1) {
    		 System.out.println("Digite...");
             System.out.println("ESCOLHA QUE TIPO DE ARQUIVO VOCÊ QUER ORDENAR: \n"
                		+  "1) - Melhor Caso\n" 
                		+  "2) - Médio Caso \n"
                		+  "3) - Pior Caso \n"
                		);
             
            resCaso = input.nextInt();
            if(resArquivo < 1 || resArquivo > 7) {
            	System.out.println("ERRO!! Digite apenas valores entre 1 -> 7\n\n\n\n");
            	pausa(3000);
            }
    	 }
    	 
    	 while(resAlgoritmo > 7 || resAlgoritmo < 1) {
    		 System.out.println("Digite...");
             System.out.println("ESCOLHA QUE TIPO DE ARQUIVO VOCÊ QUER ORDENAR: \n"
                		+  "1) - QuickSort\n" 
                		+  "2) - QuickSortM3 \n"
                		+  "3) - HeapSort \n"
                		+  "4) - MergeSort\n"
                		+  "5) - InsertionSort \n"
                		+  "6) - SelectionSort \n"
                		+  "7) - CountingSort \n"
                		);
             
            resAlgoritmo = input.nextInt();
            if(resArquivo < 1 || resArquivo > 7) {
            	System.out.println("ERRO!! Digite apenas valores entre 1 -> 7\n\n\n\n");
            	pausa(3000);
            }
    	 }
    	
		GerarArquivosOrdenados gerarArquivosOrdenados = new GerarArquivosOrdenados();
		gerarArquivosOrdenados.montarSortObject(resArquivo, resCaso, resAlgoritmo);
    }
    
}