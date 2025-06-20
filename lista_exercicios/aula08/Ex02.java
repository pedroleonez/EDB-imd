package lista_exercicios.aula08;

public class Ex02 {
    public static void main(String[] args) {
        // Vetor de 10 números inteiros definidos manualmente
        int[] numeros = {12, 11, 13, 5, 6, 8, 7, 10, 9, 4};
        int n = numeros.length;

        System.out.println("Array original:");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println("\n");

        System.out.println("--- Iniciando a ordenação com Insertion Sort ---\n");

        // Implementação do algoritmo Insertion Sort
        for (int i = 1; i < n; i++) {
            int chave = numeros[i]; // O elemento a ser inserido
            int j = i - 1;         // Último elemento da sub-array já ordenada

            System.out.println("Iteração " + i + ": Chave = " + chave + " (elemento no índice " + i + ")");
            System.out.print("  Estado inicial da sub-array ordenada: ");
            for (int k = 0; k <= j; k++) {
                System.out.print(numeros[k] + " ");
            }
            System.out.println();

            // Move os elementos da sub-array ordenada que são maiores que 'chave'
            // para uma posição à frente de sua posição atual.
            boolean houveDeslocamento = false;
            while (j >= 0 && numeros[j] > chave) {
                System.out.println("  Deslocando " + numeros[j] + " (índice " + j + ") para a direita.");
                numeros[j + 1] = numeros[j];
                j = j - 1;
                houveDeslocamento = true;
            }
            numeros[j + 1] = chave; // Insere a 'chave' na sua posição correta

            if (houveDeslocamento || j + 1 != i) { // Imprime a inserção apenas se houve movimento ou se a chave não estava na posição inicial
                System.out.println("  Inserindo " + chave + " na posição " + (j + 1) + ".");
            } else {
                System.out.println("  A chave " + chave + " já estava na posição correta.");
            }


            System.out.print("  Array após esta inserção: ");
            for (int k = 0; k < n; k++) {
                System.out.print(numeros[k] + " ");
            }
            System.out.println("\n"); // Nova linha para a próxima iteração
        }

        System.out.println("----------------------------------------\n");
        System.out.println("Array ordenado final:");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println();
    }
}
