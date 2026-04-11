/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benchmarkordenacao;

/**
 *
 * @author EDUARDA
 */
public class Benchmark {
    public static long medirInsertion(int[] array){
        long inicio = System.nanoTime();
        InsertionSort.sort(array);
        long fim = System.nanoTime();
        return fim - inicio;
    }
    
    public static long medirQuick(int[] array){
        long inicio = System.nanoTime();
        QuickSort.sort(array, 0, array.length - 1);
        long fim = System.nanoTime();
        return fim - inicio;
    }
    
}
