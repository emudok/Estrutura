/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benchmarkordenacao;

/**
 *
 * @author EDUARDA
 */
public class InsertionSort {
    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++ ){
            int chave = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > chave){
                array [j + 1] = array[j];
                j--;
            }
            array [j + 1] = chave;
        }
    }
}
