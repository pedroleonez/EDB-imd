package lista_exercicios.revisao01;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// Classe para armazenar os resultados de cada algoritmo de ordenação
class SortResult {
    String algorithmName;
    long timeMillis;
    long comparisons;
    long swaps;

    public SortResult(String algorithmName, long timeMillis, long comparisons, long swaps) {
        this.algorithmName = algorithmName;
        this.timeMillis = timeMillis;
        this.comparisons = comparisons;
        this.swaps = swaps;
    }

    @Override
    public String toString() {
        return String.format("%-15s | Tempo: %5d ms | Comparações: %8d | Trocas: %8d",
                             algorithmName, timeMillis, comparisons, swaps);
    }
}

public class Ex05 {

    // --- Algoritmos de Ordenação MODIFICADOS para retornar SortResult ---

    public static SortResult selectionSort(int[] arr) {
        long comparisons = 0;
        long swaps = 0;
        int n = arr.length;

        long startTime = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
                swaps++;
            }
        }
        long endTime = System.nanoTime();
        return new SortResult("Selection Sort", (endTime - startTime) / 1_000_000, comparisons, swaps);
    }

    public static SortResult insertionSort(int[] arr) {
        long comparisons = 0;
        long swaps = 0; // Deslocamentos
        int n = arr.length;

        long startTime = System.nanoTime();
        for (int i = 1; i < n; i++) {
            int chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > chave) {
                comparisons++; // Comparações dentro do loop while
                arr[j + 1] = arr[j];
                swaps++;
                j = j - 1;
            }
            if (j >= 0) { // Conta a última comparação que fez o loop while parar
                comparisons++;
            }
            arr[j + 1] = chave;
        }
        long endTime = System.nanoTime();
        return new SortResult("Insertion Sort", (endTime - startTime) / 1_000_000, comparisons, swaps);
    }

    public static SortResult bubbleSort(int[] arr) {
        long comparisons = 0;
        long swaps = 0;
        int n = arr.length;
        boolean trocou;

        long startTime = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
        long endTime = System.nanoTime();
        return new SortResult("Bubble Sort", (endTime - startTime) / 1_000_000, comparisons, swaps);
    }

    // --- Função para determinar o melhor desempenho ---
    public static void qualMelhorOrdenacao(int[] v) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Testando vetor com " + v.length + " elementos:");
        // Para uma visualização rápida do vetor original (apenas para pequenos)
        // System.out.println("  Original: " + Arrays.toString(v));

        // Testar Selection Sort
        int[] vSelection = Arrays.copyOf(v, v.length);
        SortResult resultSelection = selectionSort(vSelection);
        System.out.println(resultSelection);

        // Testar Insertion Sort
        int[] vInsertion = Arrays.copyOf(v, v.length);
        SortResult resultInsertion = insertionSort(vInsertion);
        System.out.println(resultInsertion);

        // Testar Bubble Sort
        int[] vBubble = Arrays.copyOf(v, v.length);
        SortResult resultBubble = bubbleSort(vBubble);
        System.out.println(resultBubble);

        // --- Determinar o Vencedor ---
        SortResult bestResult = resultSelection;

        // Comparar por tempo primeiramente
        if (resultInsertion.timeMillis < bestResult.timeMillis) {
            bestResult = resultInsertion;
        }
        if (resultBubble.timeMillis < bestResult.timeMillis) {
            bestResult = resultBubble;
        }

        // Se houver empate no tempo, considerar menor número de comparações e trocas
        // Para casos de 0ms, é preciso ser mais granular.
        // Simplificação: o menor tempo vence. Se houver empate (0ms),
        // o que tiver menos comparações/trocas é ligeiramente melhor.
        // Para 0ms, geralmente a ordem de declaração (Selection, then Insertion, then Bubble)
        // pode definir o "melhor" se não houver um critério de desempate explícito.
        // Vamos forçar um desempate simples para 0ms.
        if (bestResult.timeMillis == 0) { // Se o tempo for muito pequeno, desempate por comparações e trocas
            if (resultInsertion.timeMillis == 0 && (resultInsertion.comparisons < bestResult.comparisons || (resultInsertion.comparisons == bestResult.comparisons && resultInsertion.swaps < bestResult.swaps))) {
                bestResult = resultInsertion;
            }
            if (resultBubble.timeMillis == 0 && (resultBubble.comparisons < bestResult.comparisons || (resultBubble.comparisons == bestResult.comparisons && resultBubble.swaps < bestResult.swaps))) {
                bestResult = resultBubble;
            }
        }


        System.out.println("\n==> Melhor desempenho: " + bestResult.algorithmName + "\n");
        System.out.println("----------------------------------------------------------------------------------");
    }

    // --- Métodos para Gerar Vetores de Teste ---

    public static int[] gerarVetorOrdenado(int tamanho) {
        return IntStream.range(0, tamanho).toArray();
    }

    public static int[] gerarVetorOrdemInversa(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = tamanho - 1 - i;
        }
        return arr;
    }

    public static int[] gerarVetorAleatorio(int tamanho, int limiteValores) {
        Random random = new Random();
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = random.nextInt(limiteValores);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000}; // Diferentes tamanhos de vetores
        int limiteValores = 100000; // Limite para valores aleatórios

        System.out.println("Análise Comparativa de Algoritmos de Ordenação\n");

        for (int tamanho : tamanhos) {
            // Teste com Vetor JÁ ORDENADO
            int[] vetorOrdenado = gerarVetorOrdenado(tamanho);
            System.out.println("Cenário: Vetor JÁ ORDENADO");
            qualMelhorOrdenacao(vetorOrdenado);

            // Teste com Vetor em ORDEM INVERSA
            int[] vetorInverso = gerarVetorOrdemInversa(tamanho);
            System.out.println("Cenário: Vetor em ORDEM INVERSA");
            qualMelhorOrdenacao(vetorInverso);

            // Teste com Vetor com VALORES ALEATÓRIOS
            int[] vetorAleatorio = gerarVetorAleatorio(tamanho, limiteValores);
            System.out.println("Cenário: Vetor com VALORES ALEATÓRIOS");
            qualMelhorOrdenacao(vetorAleatorio);
        }
    }
}
