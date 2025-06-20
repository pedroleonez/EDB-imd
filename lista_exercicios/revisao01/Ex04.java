package lista_exercicios.revisao01;

public class Ex04 {
    // --- Implementação da Busca Sequencial ---
    /**
     * Realiza uma busca sequencial em um vetor.
     * @param arr O vetor onde buscar.
     * @param target O valor a ser procurado.
     * @return O índice do valor se encontrado, ou -1 se não encontrado.
     */
    public static int buscaSequencial(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Valor encontrado na posição i
            }
        }
        return -1; // Valor não encontrado
    }

    // --- Implementação da Busca Binária ---
    /**
     * Realiza uma busca binária em um vetor ordenado.
     * @param arr O vetor ordenado onde buscar.
     * @param target O valor a ser procurado.
     * @return O índice do valor se encontrado, ou -1 se não encontrado.
     */
    public static int buscaBinaria(int[] arr, int target) {
        int inicio = 0;
        int fim = arr.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2; // Previne overflow para grandes arrays

            if (arr[meio] == target) {
                return meio; // Valor encontrado!
            } else if (arr[meio] < target) {
                // Se o valor do meio é menor, busca na metade direita
                inicio = meio + 1;
            } else {
                // Se o valor do meio é maior, busca na metade esquerda
                fim = meio - 1;
            }
        }
        return -1; // Valor não encontrado
    }

    // --- Método para Gerar um Vetor Ordenado ---
    /**
     * Gera um vetor de inteiros ordenado crescentemente.
     * @param tamanho O número de elementos no vetor.
     * @return Um vetor ordenado.
     */
    public static int[] gerarVetorOrdenado(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = i; // Gera valores de 0 a tamanho-1
        }
        return arr;
    }

    public static void main(String[] args) {
        int tamanhoDoVetor = 1000;
        int[] vetorOrdenado = gerarVetorOrdenado(tamanhoDoVetor);

        System.out.println("=== Comparação de Desempenho de Algoritmos de Busca ===");
        System.out.println("Vetor de " + tamanhoDoVetor + " elementos ordenados (0 a " + (tamanhoDoVetor - 1) + ")");
        System.out.println("Medição utilizando System.nanoTime()\n");

        // --- Casos de Teste para Busca ---
        int valorInicio = vetorOrdenado[0];                  // Valor existente no início (0)
        int valorMeio = vetorOrdenado[tamanhoDoVetor / 2];   // Valor existente no meio (499)
        int valorInexistente = tamanhoDoVetor + 1;           // Valor inexistente (1001)

        // --- Função auxiliar para rodar e imprimir o teste ---
        testarBusca("início (" + valorInicio + ")", valorInicio, vetorOrdenado);
        testarBusca("meio (" + valorMeio + ")", valorMeio, vetorOrdenado);
        testarBusca("inexistente (" + valorInexistente + ")", valorInexistente, vetorOrdenado);
    }

    // Método auxiliar para executar e medir o tempo de cada busca
    private static void testarBusca(String tipoValor, int valorProcurado, int[] vetor) {
        long startTime, endTime, duration;
        int resultado;

        System.out.println("--- Buscando um valor " + tipoValor + " ---");

        // Teste Busca Sequencial
        startTime = System.nanoTime();
        resultado = buscaSequencial(vetor, valorProcurado);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000; // Tempo em milissegundos
        System.out.println("  Busca Sequencial: " + duration + " ms. Posição: " + resultado);

        // Teste Busca Binária
        startTime = System.nanoTime();
        resultado = buscaBinaria(vetor, valorProcurado);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000; // Tempo em milissegundos
        System.out.println("  Busca Binária:    " + duration + " ms. Posição: " + resultado);
        System.out.println(); // Linha em branco para separar os testes
    }
}
