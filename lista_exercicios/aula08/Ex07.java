package lista_exercicios.aula08;

import java.util.Arrays;
import java.util.Random;

public class Ex07 {
    // Implementação do Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Implementação do Insertion Sort
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
        int tamanho = 1000; // Tamanho do vetor
        Random random = new Random();

        System.out.println("--- Comparação de Eficiência com " + tamanho + " elementos aleatórios ---\n");

        // Gera um vetor de números aleatórios
        int[] originalArray = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            originalArray[i] = random.nextInt(tamanho * 10); // Números aleatórios
        }

        // --- Teste Selection Sort ---
        int[] arrayForSelectionSort = Arrays.copyOf(originalArray, originalArray.length);
        long startTimeSelection = System.nanoTime();
        selectionSort(arrayForSelectionSort);
        long endTimeSelection = System.nanoTime();
        long durationSelection = (endTimeSelection - startTimeSelection) / 1_000_000; // Tempo em milissegundos

        System.out.println("  Selection Sort: " + durationSelection + " ms");

        // --- Teste Insertion Sort ---
        int[] arrayForInsertionSort = Arrays.copyOf(originalArray, originalArray.length);
        long startTimeInsertion = System.nanoTime();
        insertionSort(arrayForInsertionSort);
        long endTimeInsertion = System.nanoTime();
        long durationInsertion = (endTimeInsertion - startTimeInsertion) / 1_000_000; // Tempo em milissegundos

        System.out.println("  Insertion Sort: " + durationInsertion + " ms");
        System.out.println();
    }
}
