/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benchmarkordenacao;

/**
 *
 * @author EDUARDA
 */
import java.util.Random;

public class QuickSort {
    public static void sort (int[] array, int inicio, int fim){ 
        if (inicio < fim){
            int pivo = particionar (array, inicio, fim);
            sort(array, inicio, pivo -1);
            sort(array, pivo + 1, fim);
        }
    }
    private static int particionar (int[] array, int inicio, int fim){ 
        Random rand = new Random();
        int indicePivo = inicio + rand.nextInt(fim - inicio + 1);
        int temp = array[indicePivo];
        array[indicePivo] = array[fim];
        array[fim] = temp;
        
        int pivo = array[fim];
        int i = inicio - 1;
        
        for (int j = inicio; j < fim; j++){
            if (array[j] <= pivo){
                
                i++;
                
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;       
            }
        }
        temp = array[i + 1];
        array [i + 1] = array[fim];
        array[fim] = temp;
        
        return i + 1;
    }
}
