/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountingSort;


/**
 *
 * @author Ludovic
 */
public class CountingSort {

    private static int range;

    private static int[] contingSort(int[] array) {
        int[] values = new int[range + 1];
        //array espelho
        for (int i = 0; i <= range; i++) {
            values[i] = 0;
        }
        //Contagem das ocorrencias no vetor desordenado
        for (int i = 0; i < array.length; i++) {            
            values[array[i]]++;
        }
        
        for (int i = 0; i < values.length; i++) {
            System.out.println("[" + i + "] = " + values[i]);
        }
        
        System.out.println("Ordenando ");
        int[] arr = new int[array.length];
        int k = 0;

        for (int i = 0; i <= range; i++) {
            for (int j = 0; j < values[i]; j++) {
                arr[k++] = i;
            }
        }
        return arr;

    }

    
    public static void main(String[] a) {
        range = 9;

        int[] vetor = {1, 5, 0, 6, 9, 5, 0, 2, 3, 4, 5, 8, 7, 6, 1, 4};
        
        System.out.println("Nao ta Ordenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf(vetor[i] + " ");
        }

        System.out.println("\n\n<-- Conting Sort ");
        vetor = contingSort(vetor);  
        //imprime
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf(vetor[i] + " ");
        }

    }

}
