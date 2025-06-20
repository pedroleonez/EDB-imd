package lista_exercicios.revisao01;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// Classe para armazenar os resultados (comparações e trocas) de cada algoritmo
class SortStats {
    long comparisons;
    long swaps;

    public SortStats(long comparisons, long swaps) {
        this.comparisons = comparisons;
        this.swaps = swaps;
    }

    @Override
    public String toString() {
        return "Comparações: " + comparisons + ", Trocas: " + swaps;
    }
}

public class Ex02 {

    // --- Algoritmos de Ordenação com Contadores ---

    /**
     * Implementa o Selection Sort e retorna o número de comparações e trocas.
     * @param arr O vetor a ser ordenado.
     * @return Um objeto SortStats contendo as contagens.
     */
    public static SortStats selectionSort(int[] arr) {
        long comparisons = 0;
        long swaps = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++; // Cada vez que comparamos arr[j] com arr[min_idx]
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // A troca ocorre apenas se o menor elemento não estiver já na posição correta
            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
                swaps++; // Cada troca de elementos
            }
        }
        return new SortStats(comparisons, swaps);
    }

    /**
     * Implementa o Insertion Sort e retorna o número de comparações e trocas (deslocamentos).
     * @param arr O vetor a ser ordenado.
     * @return Um objeto SortStats contendo as contagens.
     */
    public static SortStats insertionSort(int[] arr) {
        long comparisons = 0;
        long swaps = 0; // Para Insertion Sort, "trocas" geralmente se refere a deslocamentos de elementos
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int chave = arr[i]; // O elemento a ser inserido
            int j = i - 1;       // Último elemento da sub-array já ordenada

            // Move os elementos da sub-array ordenada que são maiores que 'chave'
            // para uma posição à frente de sua posição atual
            while (j >= 0 && arr[j] > chave) {
                comparisons++; // Cada vez que arr[j] é comparado com chave
                arr[j + 1] = arr[j]; // Deslocamento de elemento
                swaps++;             // Contamos cada deslocamento como uma "troca" (movimentação)
                j = j - 1;
            }
            // Uma comparação final é feita quando a condição do while se torna falsa
            // (seja j < 0 ou arr[j] <= chave). Se o loop while foi executado,
            // essa última comparação é a que falhou a condição arr[j] > chave.
            // Se j < 0, a condição arr[j] > chave não foi avaliada novamente.
            // A maneira mais precisa é contar a cada vez que arr[j] > chave é testado.
            // No entanto, é comum que a comparação final que faz o loop parar também seja contada.
            // A implementação atual incrementa 'comparisons' apenas quando o primeiro lado (j >= 0) é verdadeiro.
            if (j >= 0) { // Se o loop parou porque arr[j] <= chave
                comparisons++; // Conta a comparação final que fez o loop parar
            }

            arr[j + 1] = chave; // Insere a 'chave' na sua posição correta
            // A inserção da chave não é uma "troca" no sentido de permutar dois elementos,
            // mas é a colocação final de um elemento. Não a contamos como "swap" aqui para manter
            // a métrica de "swap" como troca bidirecional ou deslocamento de elemento preexistente.
        }
        return new SortStats(comparisons, swaps);
    }

    /**
     * Implementa o Bubble Sort (otimizado) e retorna o número de comparações e trocas.
     * @param arr O vetor a ser ordenado.
     * @return Um objeto SortStats contendo as contagens.
     */
    public static SortStats bubbleSort(int[] arr) {
        long comparisons = 0;
        long swaps = 0;
        int n = arr.length;
        boolean trocou; // Flag para otimização

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++; // Cada vez que comparamos arr[j] com arr[j+1]
                if (arr[j] > arr[j + 1]) {
                    // Troca arr[j] e arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++; // Cada troca de elementos
                    trocou = true;
                }
            }
            if (!trocou) { // Se nenhuma troca ocorreu nesta passagem, o array está ordenado
                break;
            }
        }
        return new SortStats(comparisons, swaps);
    }

    // --- Métodos para Gerar Vetores de Teste ---

    /**
     * Gera um vetor de inteiros já ordenado (crescente).
     * @param tamanho O número de elementos no vetor.
     * @return Um vetor ordenado.
     */
    public static int[] gerarVetorOrdenado(int tamanho) {
        return IntStream.range(0, tamanho).toArray();
    }

    /**
     * Gera um vetor de inteiros em ordem inversa (decrescente).
     * @param tamanho O número de elementos no vetor.
     * @return Um vetor em ordem inversa.
     */
    public static int[] gerarVetorOrdemInversa(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = tamanho - 1 - i;
        }
        return arr;
    }

    /**
     * Gera um vetor de inteiros com valores aleatórios.
     * @param tamanho O número de elementos no vetor.
     * @param limite O limite superior exclusivo para os valores aleatórios.
     * @return Um vetor com valores aleatórios.
     */
    public static int[] gerarVetorAleatorio(int tamanho, int limite) {
        Random random = new Random();
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = random.nextInt(limite);
        }
        return arr;
    }

    // --- Função Principal para Executar os Testes ---
    public static void main(String[] args) {
        int tamanhoDoVetor = 1000; // Tamanho do vetor para os testes
        int limiteValoresAleatorios = 10000; // Limite superior para valores aleatórios (ex: 0 a 9999)

        System.out.println("=== Comparação de Algoritmos de Ordenação (Comparações e Trocas) ===");
        System.out.println("Tamanho do vetor para os testes: " + tamanhoDoVetor + "\n");

        // --- Cenário 1: Vetor Já Ordenado ---
        System.out.println("--- Teste com Vetor JÁ ORDENADO ---");
        int[] sortedArray = gerarVetorOrdenado(tamanhoDoVetor);

        System.out.println("  Selection Sort:");
        int[] arrSelSorted = Arrays.copyOf(sortedArray, tamanhoDoVetor); // Copia para não alterar o original
        SortStats statsSelSorted = selectionSort(arrSelSorted);
        System.out.println("    " + statsSelSorted);

        System.out.println("  Insertion Sort:");
        int[] arrInsSorted = Arrays.copyOf(sortedArray, tamanhoDoVetor);
        SortStats statsInsSorted = insertionSort(arrInsSorted);
        System.out.println("    " + statsInsSorted);

        System.out.println("  Bubble Sort:");
        int[] arrBubSorted = Arrays.copyOf(sortedArray, tamanhoDoVetor);
        SortStats statsBubSorted = bubbleSort(arrBubSorted);
        System.out.println("    " + statsBubSorted + "\n");


        // --- Cenário 2: Vetor em Ordem Inversa ---
        System.out.println("--- Teste com Vetor em ORDEM INVERSA ---");
        int[] reverseArray = gerarVetorOrdemInversa(tamanhoDoVetor);

        System.out.println("  Selection Sort:");
        int[] arrSelReverse = Arrays.copyOf(reverseArray, tamanhoDoVetor);
        SortStats statsSelReverse = selectionSort(arrSelReverse);
        System.out.println("    " + statsSelReverse);

        System.out.println("  Insertion Sort:");
        int[] arrInsReverse = Arrays.copyOf(reverseArray, tamanhoDoVetor);
        SortStats statsInsReverse = insertionSort(arrInsReverse);
        System.out.println("    " + statsInsReverse);

        System.out.println("  Bubble Sort:");
        int[] arrBubReverse = Arrays.copyOf(reverseArray, tamanhoDoVetor);
        SortStats statsBubReverse = bubbleSort(arrBubReverse);
        System.out.println("    " + statsBubReverse + "\n");


        // --- Cenário 3: Vetor com Valores Aleatórios ---
        System.out.println("--- Teste com Vetor com VALORES ALEATÓRIOS ---");
        int[] randomArray = gerarVetorAleatorio(tamanhoDoVetor, limiteValoresAleatorios);

        System.out.println("  Selection Sort:");
        int[] arrSelRandom = Arrays.copyOf(randomArray, tamanhoDoVetor);
        SortStats statsSelRandom = selectionSort(arrSelRandom);
        System.out.println("    " + statsSelRandom);

        System.out.println("  Insertion Sort:");
        int[] arrInsRandom = Arrays.copyOf(randomArray, tamanhoDoVetor);
        SortStats statsInsRandom = insertionSort(arrInsRandom);
        System.out.println("    " + statsInsRandom);

        System.out.println("  Bubble Sort:");
        int[] arrBubRandom = Arrays.copyOf(randomArray, tamanhoDoVetor);
        SortStats statsBubRandom = bubbleSort(arrBubRandom);
        System.out.println("    " + statsBubRandom + "\n");

        System.out.println("=== Fim da Comparação ===");
    }
}