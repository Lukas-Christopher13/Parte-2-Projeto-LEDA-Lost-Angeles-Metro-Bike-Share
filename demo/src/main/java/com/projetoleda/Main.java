package com.projetoleda;

import java.util.Scanner;

import com.projetoleda.Interface.Interface;
import com.projetoleda.Interface.GerarCasos;

//Minhas classes

//rode esse arquivo para o programa funcionar
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        GerarCasos gerarCasos = new GerarCasos();
        
        //loop principal
        while(true) {
            //limpa a tela
            System.out.print("\033[H\033[2J");

            System.out.printf("Digite....\n\n");

            System.out.println("1-) Para Tratar o Arquivo");
            System.out.println("2-) Para Gerar Os Arquivos de Pior e Melhor caso");
            System.out.println("3-) Para Começa a ordenar os Arquivos");

            System.out.printf("\nDigite: ");
            int resposta = input.nextInt();

            switch (resposta) {
                case 1:
                    Interface.tratarArquivoInterface();
                    break;
                case 2:
                    Interface.gerarMelhorEPiorCasoInterface();
                    break;
                
                case 3: 
                    Interface.selecionarItemASerOrdenado();
                    break;
            
                default:
                    System.out.println("Valor invalido! Digite novamente!");
                    Interface.pausa(5000);
                    break;
            }

        }
    }
}
        
    
    
