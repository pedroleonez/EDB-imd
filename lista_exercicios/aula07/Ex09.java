package lista_exercicios.aula07;

import java.util.Arrays;
import java.util.Random;

public class Ex09 {
    // --- Implementação do Selection Sort para double[] ---
    public static void selectionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Troca
            double temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // --- Implementação do Bubble Sort para double[] ---
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca arr[j] e arr[j+1]
                    double temp = arr[j];
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

        System.out.println("Comparação de Performance de Algoritmos de Ordenação (double[]):\n");

        for (int tamanho : tamanhos) {
            System.out.println("--- Testando com " + tamanho + " elementos ---");

            // Gera um vetor de números decimais aleatórios
            double[] originalArray = new double[tamanho];
            for (int i = 0; i < tamanho; i++) {
                // Geramos um double aleatório entre 0.0 e tamanho*10.0
                originalArray[i] = random.nextDouble() * (tamanho * 10);
            }

            // --- Teste Selection Sort ---
            // Cria uma cópia do array original para não alterar os dados para o Bubble Sort
            double[] arrayForSelectionSort = Arrays.copyOf(originalArray, originalArray.length);

            long startTimeSelection = System.nanoTime(); // Marca o tempo de início
            selectionSort(arrayForSelectionSort);
            long endTimeSelection = System.nanoTime(); // Marca o tempo de fim
            long durationSelection = (endTimeSelection - startTimeSelection) / 1_000_000; // Tempo em milissegundos

            System.out.println("  Selection Sort: " + durationSelection + " ms");

            // --- Teste Bubble Sort ---
            // Cria uma nova cópia do array original
            double[] arrayForBubbleSort = Arrays.copyOf(originalArray, originalArray.length);

            long startTimeBubble = System.nanoTime(); // Marca o tempo de início
            bubbleSort(arrayForBubbleSort);
            long endTimeBubble = System.nanoTime(); // Marca o tempo de fim
            long durationBubble = (endTimeBubble - startTimeBubble) / 1_000_000; // Tempo em milissegundos

            System.out.println("  Bubble Sort:    " + durationBubble + " ms");
            System.out.println();
        }
    }
}
