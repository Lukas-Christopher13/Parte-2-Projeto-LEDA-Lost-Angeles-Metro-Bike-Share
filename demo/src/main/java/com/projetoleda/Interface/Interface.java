package com.projetoleda.Interface;

import java.util.Scanner;
import java.io.File;
import java.time.LocalDateTime;

import com.projetoleda.PrepararODateSet;
import com.projetoleda.PassosParaTratarOArquivo.P2FiltrarStationName;
import com.projetoleda.PassosParaTratarOArquivo.P3FiltrarMedia;

public class Interface {

    private static Scanner input = new Scanner(System.in);

    public static void tratarArquivoInterface() {
        System.out.print("\033[H\033[2J");

        System.out.println("Digite...");

        System.out.println("1-) Para subistituir os ids pelo nome das estações ");
        System.out.println("2-) Para filtrar por Pasadena");
        System.out.println("3-) Para filtrar por viagens maior que a media");

        System.out.printf("\nDigite: ");
        int resposta = input.nextInt();

        switch (resposta) {
            case 1:
                PrepararODateSet prepararOdateSet = new PrepararODateSet();
                prepararOdateSet.subistituirIdPelasEstacoes();
                pausa(5000);
                break;

            case 2:
               try {
                File file = new File("");
                P2FiltrarStationName.rodar(
                file.getAbsolutePath() + "/src/main/java/com/projetoleda/DadosCsvTratados/LAMetroTrips.csv",
                file.getAbsolutePath() + "/src/main/java/com/projetoleda/DadosCsvTratados/LAMetroTrips_F1.csv");
               } catch (Exception e) {
                 System.err.println("Erro ao filtrar");
               }

                break;

            case 3:
                // Filtrar por media
                try {
                    P3FiltrarMedia.rodar();
                } catch (Exception e) {
                    System.err.println("deu ero");
                }
                break;

            default:
                System.out.println("Valor invalido! Digite novamente!");
                pausa(5000);
                break;
        }
    }

    public static void gerarMelhorEPiorCasoInterface() {
        System.out.print("\033[H\033[2J");

        System.out.println("Digite...");

        System.out.println("1-) Para gerar os casos por Estação");
        System.out.println("2-) Para gerar os casos por Duração");
        System.out.println("3-) Para gerar os casos por Data");

        System.out.printf("\nDigite: ");
        int resposta = input.nextInt();

        GerarCasos gerarCasos = new GerarCasos();

        switch (resposta) {
            case 1:
                gerarCasos.gerarTabelComTodosOsCasosPor(String.class);
                pausa(5000);
                break;

            case 2:
                gerarCasos.gerarTabelComTodosOsCasosPor(Integer.class);
                pausa(5000);
                break;

            case 3:
                gerarCasos.gerarTabelComTodosOsCasosPor(LocalDateTime.class);
                pausa(5000);
                break;

            default:
                System.out.println("Valor invalido! Digite novamente!");
                pausa(5000);
                break;
        }
    }

    public static void selecionarItemASerOrdenado() {
        InterfaceSortObject interfaceSortObject = new InterfaceSortObject();
        interfaceSortObject.selecionarDadosParaCriaçãoDoSortObjetct();
    }

    public static void pausa(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
            System.err.println("Erro ao pausar a Thread");
        }
    }
}
