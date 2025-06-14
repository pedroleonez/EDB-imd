package lista_exercicios.aula07;

import java.util.Arrays;
import java.util.Random;

public class Ex08 {
    
    // --- Implementação do Selection Sort ---
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Troca
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // --- Implementação do Bubble Sort ---
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca arr[j] e arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            // Se nenhuma troca ocorreu nesta iteração, o array está ordenado
            if (!trocou) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000}; // Tamanhos dos vetores a serem testados
        Random random = new Random();

        System.out.println("Comparação de Performance de Algoritmos de Ordenação:\n");

        for (int tamanho : tamanhos) {
            System.out.println("--- Testando com " + tamanho + " elementos ---");

            // Gera um vetor aleatório
            int[] originalArray = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                originalArray[i] = random.nextInt(tamanho * 10); // Números aleatórios até tamanho*10
            }

            // --- Teste Selection Sort ---
            // Cria uma cópia do array original para não alterar os dados para o Bubble Sort
            int[] arrayForSelectionSort = Arrays.copyOf(originalArray, originalArray.length);

            long startTimeSelection = System.nanoTime(); // Marca o tempo de início
            selectionSort(arrayForSelectionSort);
            long endTimeSelection = System.nanoTime(); // Marca o tempo de fim
            long durationSelection = (endTimeSelection - startTimeSelection) / 1_000_000; // Tempo em milissegundos

            System.out.println("  Selection Sort: " + durationSelection + " ms");

            // --- Teste Bubble Sort ---
            // Cria uma nova cópia do array original
            int[] arrayForBubbleSort = Arrays.copyOf(originalArray, originalArray.length);

            long startTimeBubble = System.nanoTime(); // Marca o tempo de início
            bubbleSort(arrayForBubbleSort);
            long endTimeBubble = System.nanoTime(); // Marca o tempo de fim
            long durationBubble = (endTimeBubble - startTimeBubble) / 1_000_000; // Tempo em milissegundos

            System.out.println("  Bubble Sort:    " + durationBubble + " ms");
            System.out.println();
        }
    }
}
