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

public class ArrayGenerator {
    public static int[] melhorCaso(int tamanho){
        Random random = new Random();
        
        int[] array = new int [tamanho];
        
        for (int i = 0; i < tamanho; i++){
            array[i] = i;
        }
        return array;    
    }
    
    public static int[] piorCaso(int tamanho){
        
        int[] array = new int [tamanho];
        
        for (int i = 0; i < tamanho; i++){
            array[i] = tamanho - i;
        }
        return array;
    }
    
    public static int[] casoMedio(int tamanho){
        Random random = new Random();
        
        int[] array = new int [tamanho];
        
        for (int i = 0; i < tamanho; i++){
            array[i] = random.nextInt(100000);
        }
        return array;
    }
}
