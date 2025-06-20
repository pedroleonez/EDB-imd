package lista_exercicios.aula09;

import java.util.Arrays;
import java.util.Random;

public class Ex09 {
    
    // --- Implementação do Bubble Sort Otimizado ---
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }

    // --- Implementação do Insertion Sort ---
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = chave;
        }
    }

    public static void main(String[] args) {
        int tamanhoDoVetor = 1000; // O número de elementos para o teste
        Random random = new Random();

        System.out.println("--- Comparação de Desempenho (Bubble Sort vs Insertion Sort) ---");
        System.out.println("Número de elementos: " + tamanhoDoVetor + "\n");

        // Geração do vetor aleatório
        int[] originalArray = new int[tamanhoDoVetor];
        for (int i = 0; i < tamanhoDoVetor; i++) {
            originalArray[i] = random.nextInt(tamanhoDoVetor * 10); // Números aleatórios
        }

        // --- Teste Bubble Sort ---
        // Cria uma CÓPIA do array original para que ambos os algoritmos recebam os mesmos dados
        int[] arrayParaBubbleSort = Arrays.copyOf(originalArray, originalArray.length);

        long inicioTempoBubble = System.nanoTime(); // Marca o tempo de início em nanossegundos
        bubbleSort(arrayParaBubbleSort);
        long fimTempoBubble = System.nanoTime();   // Marca o tempo de fim
        long duracaoBubble = (fimTempoBubble - inicioTempoBubble) / 1_000_000; // Converte para milissegundos

        System.out.println("Tempo de execução do Bubble Sort:    " + duracaoBubble + " ms");

        // --- Teste Insertion Sort ---
        // Cria uma nova CÓPIA do array original
        int[] arrayParaInsertionSort = Arrays.copyOf(originalArray, originalArray.length);

        long inicioTempoInsertion = System.nanoTime(); // Marca o tempo de início
        insertionSort(arrayParaInsertionSort);
        long fimTempoInsertion = System.nanoTime();   // Marca o tempo de fim
        long duracaoInsertion = (fimTempoInsertion - inicioTempoInsertion) / 1_000_000; // Converte para milissegundos

        System.out.println("Tempo de execução do Insertion Sort: " + duracaoInsertion + " ms");

        System.out.println("\n--- Conclusão ---");
        if (duracaoBubble < duracaoInsertion) {
            System.out.println("Neste teste, o Bubble Sort foi mais rápido.");
        } else if (duracaoInsertion < duracaoBubble) {
            System.out.println("Neste teste, o Insertion Sort foi mais rápido.");
        } else {
            System.out.println("Neste teste, ambos tiveram desempenho similar.");
        }
        System.out.println("Observe que os resultados podem variar ligeiramente entre as execuções.");
    }
}
