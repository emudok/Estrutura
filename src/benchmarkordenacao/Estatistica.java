/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benchmarkordenacao;

/**
 *
 * @author EDUARDA
 */
public class Estatistica {
    public static double media(long[] tempos){
        long soma = 0;
        
        for (long t : tempos){
            soma += t;
        }
        return (double) soma / tempos.length;
    }
    
    public static double desvioPadrao(long[] tempos){
        double media = media(tempos);
        double soma = 0;
        
        for (long t : tempos){
            soma += Math.pow(t - media, 2);
        }
        return Math.sqrt(soma / tempos.length);
    }
}
