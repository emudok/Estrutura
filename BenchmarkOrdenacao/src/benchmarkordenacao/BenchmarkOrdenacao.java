/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package benchmarkordenacao;

/**
 *
 * @author EDUARDA
 */
import java.util.Arrays;

public class BenchmarkOrdenacao {
    static final int EXECUCOES = 30;

    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 50000};

        for (int tamanho : tamanhos) {
            System.out.println();
            System.out.println("TAMANHO: " + tamanho);
            executarCenario("Melhor caso", tamanho, 1);
            executarCenario("Caso medio", tamanho, 2);
            executarCenario("Pior caso", tamanho, 3);
        }
    }

    private static void executarCenario(String nome, int tamanho, int tipo) {
        long[] temposInsertion = new long[EXECUCOES];
        long[] temposQuick = new long[EXECUCOES];

        for (int i = 0; i < EXECUCOES; i++) {

            int[] arrayBase;

            switch (tipo) {
                case 1:
                    arrayBase = ArrayGenerator.melhorCaso(tamanho);
                    break;
                case 2:
                    arrayBase = ArrayGenerator.casoMedio(tamanho);
                    break;
                default:
                    arrayBase = ArrayGenerator.piorCaso(tamanho);
                    break;
            }
            int[] array1 = Arrays.copyOf(arrayBase, arrayBase.length);
            int[] array2 = Arrays.copyOf(arrayBase, arrayBase.length);

            temposInsertion[i] = Benchmark.medirInsertion(array1);
            temposQuick[i] = Benchmark.medirQuick(array2);
        }
        System.out.println("\n--- " + nome + " ---\n");
        exibirResultados("Insertion Sort", temposInsertion);
        System.out.println(); 
        exibirResultados("Quick Sort", temposQuick);
    }
    
    private static void exibirResultados(String algoritmo, long[] tempos) {

        double media = Estatistica.media(tempos);
        double desvio = Estatistica.desvioPadrao(tempos);

        System.out.println(algoritmo);
        System.out.printf("Media (ns): %.2f\n", media);
        System.out.printf("Desvio Padrao: %.2f\n", desvio);
    }
}
