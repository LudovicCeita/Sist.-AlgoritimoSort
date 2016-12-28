package mergensort;

/**
 *
 * @author Notorius B.I.G
 */
public class MergenSort {

    private static int[] vetor;

    public static int[] getVetor() {
        return vetor;
    }

    public static void setVetor(int[] vetor) {
        MergenSort.vetor = vetor;
    }

    /*
     Metodo Recursivo  que divide o vetor em dois e depois
     os mescla e ordena 
     */
    private static void merge(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            merge(inicio, meio);
            merge(meio + 1, fim);
            mesclar(inicio, meio, fim);
        }
    }

    /*Ordena dois trechos ordenados e adjacentes de vetores e ordena-se
     conjuntamente        
     */
    private static void mesclar(int inicio, int meio, int fim) {
        int tamanho = fim - inicio + 1;

        /*inicializacao de um vetor temporario para auxiliar na ordenacao 
         o vetor temporario e uma copia do trecho que sera ordenado */
        int[] temp = new int[tamanho];

        System.arraycopy(vetor, inicio, temp, 0, tamanho);//.arraycopy(vetor , inicio , temp , 0 ,tamanho);

        /*Laço para ordenacao do vetor , utilizando um vetor temporario 
         usando indices  i e j pra cada trecho  de vetor da meclagem */
        int i = 0;
        int j = meio - inicio + 1;

        //A depender das condicoes , recebe um elemento de um trecho  ou de outro 
        for (int posicao = 0; posicao < tamanho; posicao++) {
            if (j <= tamanho - 1) {
                if (i <= meio - inicio) {
                    if (temp[i] < temp[j]) {
                        vetor[inicio + posicao] = temp[i++];
                    } else {
                        vetor[inicio + posicao] = temp[j++];
                    }
                } else {
                    vetor[inicio + posicao] = temp[j++];
                }
            } else {
                vetor[inicio + posicao] = temp[i++];
            }
        }

    }

    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i <= 9; i++) {
            System.out.println(vetor[i]);
        }
    }
    

    public static void main(String[] args) {
        
        int[] vetorM = {9, 8, 6, 7, 3, 5, 4, 10, 1, 2};
        
        System.out.println("Vetor ainda nao Ordenado ");
        imprimirVetor(vetorM);
        
        System.out.println("<-- MergeSort");
        setVetor(vetorM);
        merge(0, 9);

        System.out.println("Vetor ja ordenado");
        imprimirVetor(vetorM);
    }
}
