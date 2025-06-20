package lista_exercicios.revisao01;

import java.util.Arrays;
import java.util.Random;

public class Ex01 {
    // --- Função para imprimir o vetor ---
    public static void imprimir(String nomeAlgoritmo, int[] arr) {
        System.out.print("Vetor após " + nomeAlgoritmo + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]\n");
    }

    // --- 1. Implementação do Selection Sort ---
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

    // --- 2. Implementação do Insertion Sort ---
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

    // --- 3. Implementação do Bubble Sort (Otimizado) ---
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
            if (!trocou) { // Otimização: para se não houver trocas
                break;
            }
        }
    }

    public static void main(String[] args) {
        int tamanhoDoVetor = 10; // Tamanho do vetor para demonstração
        Random random = new Random();

        // Gerar um vetor original desordenado
        int[] originalArray = new int[tamanhoDoVetor];
        for (int i = 0; i < tamanhoDoVetor; i++) {
            originalArray[i] = random.nextInt(100); // Números aleatórios de 0 a 99
        }

        System.out.print("Vetor original (desordenado): [");
        for (int i = 0; i < tamanhoDoVetor; i++) {
            System.out.print(originalArray[i]);
            if (i < tamanhoDoVetor - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]\n");

        // --- Teste Selection Sort ---
        int[] arrayParaSelectionSort = Arrays.copyOf(originalArray, originalArray.length);
        selectionSort(arrayParaSelectionSort);
        imprimir("Selection Sort", arrayParaSelectionSort);

        // --- Teste Insertion Sort ---
        int[] arrayParaInsertionSort = Arrays.copyOf(originalArray, originalArray.length);
        insertionSort(arrayParaInsertionSort);
        imprimir("Insertion Sort", arrayParaInsertionSort);

        // --- Teste Bubble Sort ---
        int[] arrayParaBubbleSort = Arrays.copyOf(originalArray, originalArray.length);
        bubbleSort(arrayParaBubbleSort);
        imprimir("Bubble Sort", arrayParaBubbleSort);
    }
}
