/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeapSort;

/**
 *
 * @author Notorius B.I.G
 */
public class HeapSort {

    public static void ordenar(int[] lista) {
        //montagem de arvore
        montarArvoreHeap(lista);
        int n = lista.length;

        //para uma arevore de tamanho  n , ordena - se n - 1 vezes 
        for (int i = lista.length - 1; i > 0; i--) {
            int aux = lista[i];
            lista[i] = lista[0];
            lista[0] = aux;
            ordenarArvore(lista, 0, --n);
        }
    }

    public static void montarArvoreHeap(int[] lista) {
        for (int posicao = (lista.length - 1) / 2; posicao >= 0; posicao--) {
            ordenarArvore(lista, posicao, lista.length);
        }
    }

    public static void ordenarArvore(int[] lista, int posicao, int tamanhoDoVetor) {

        int indiceFilhoUm = 2 * posicao + 1;
        int indiceFilhoDois = indiceFilhoUm + 1;

        if (indiceFilhoUm < tamanhoDoVetor) {

            if (indiceFilhoDois < tamanhoDoVetor) {
                //se ainda estivemos dentro do vetor teste qul mairo filho 
                if (lista[indiceFilhoUm] < lista[indiceFilhoDois]) {
                    indiceFilhoUm = indiceFilhoDois;
                }
            }
            //compracao filho um com no pai
            if (lista[indiceFilhoUm] > lista[posicao]) {
                int aux = lista[indiceFilhoUm];
                lista[indiceFilhoUm] = lista[posicao];
                lista[posicao] = aux;

                //remotagem da arvore
                ordenarArvore(lista, indiceFilhoUm, tamanhoDoVetor);
            }
        }
    }

    public static void main(String[] a) {

        int[] lista = {9, 5, 88, 76, 44, 18, 0, 11, 21};

        System.out.println("Lista Antes ");
        for (int i : lista) {
            System.out.println(i);
        }
        System.out.println();
        ordenar(lista);

        System.out.println("Lista Depois do Heap_Sort ");
        for (int i : lista) {
            System.out.println(i + " ");
        }
    }
}
