package lista_exercicios.revisao01;

import java.util.Arrays;
import java.util.Random;

public class Ex03 {
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
            if (min_idx != i) { // Troca apenas se encontrou um menor
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
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

    // --- Implementação do Bubble Sort (Otimizado) ---
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

    // --- Método para Gerar Vetor Aleatório ---
    public static int[] gerarVetorAleatorio(int tamanho, int limiteValores) {
        Random random = new Random();
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = random.nextInt(limiteValores);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000}; // Tamanhos dos vetores a serem testados
        int limiteValores = 100000; // Limite superior para os valores aleatórios no vetor

        System.out.println("=== Comparação de Tempo de Execução de Algoritmos de Ordenação ===");
        System.out.println("Medição utilizando System.nanoTime()\n");

        for (int tamanho : tamanhos) {
            System.out.println("--- Testando com " + tamanho + " elementos ---");

            // Gerar o vetor aleatório original para esta rodada de testes
            int[] originalArray = gerarVetorAleatorio(tamanho, limiteValores);

            // --- Teste Selection Sort ---
            // Cria uma cópia do array original para que o algoritmo trabalhe com dados "frescos"
            int[] arrayParaSelectionSort = Arrays.copyOf(originalArray, originalArray.length);
            long startTimeSelection = System.nanoTime();
            selectionSort(arrayParaSelectionSort);
            long endTimeSelection = System.nanoTime();
            long durationSelection = (endTimeSelection - startTimeSelection) / 1_000_000; // Converte para milissegundos
            System.out.println("  Selection Sort: " + durationSelection + " ms");

            // --- Teste Insertion Sort ---
            // Cria uma nova cópia do array original
            int[] arrayParaInsertionSort = Arrays.copyOf(originalArray, originalArray.length);
            long startTimeInsertion = System.nanoTime();
            insertionSort(arrayParaInsertionSort);
            long endTimeInsertion = System.nanoTime();
            long durationInsertion = (endTimeInsertion - startTimeInsertion) / 1_000_000; // Converte para milissegundos
            System.out.println("  Insertion Sort: " + durationInsertion + " ms");

            // --- Teste Bubble Sort ---
            // Cria uma nova cópia do array original
            int[] arrayParaBubbleSort = Arrays.copyOf(originalArray, originalArray.length);
            long startTimeBubble = System.nanoTime();
            bubbleSort(arrayParaBubbleSort);
            long endTimeBubble = System.nanoTime();
            long durationBubble = (endTimeBubble - startTimeBubble) / 1_000_000; // Converte para milissegundos
            System.out.println("  Bubble Sort:    " + durationBubble + " ms");

            System.out.println(); // Linha em branco para separar os tamanhos
        }

        System.out.println("=== Fim da Comparação ===");
    }
}
