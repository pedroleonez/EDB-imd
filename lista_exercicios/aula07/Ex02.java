package lista_exercicios.aula07;

public class Ex02 {
    public static void main(String[] args) {
        // Vetor de 10 números inteiros definidos manualmente
        int[] numeros = {64, 25, 12, 22, 11, 90, 78, 34, 56, 10};
        int n = numeros.length;

        System.out.println("Array original:");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println("\n-------------------------------------\n"); // Separador

        // Implementação do Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i; // Assume que o primeiro elemento não ordenado é o menor

            System.out.println("Iteração " + (i + 1) + ":");
            System.out.println("  Buscando o menor elemento a partir do índice " + i);

            // Encontra o índice do menor elemento restante no array não ordenado
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[min_idx]) {
                    min_idx = j;
                }
            }

            // Se o menor elemento não estiver na posição atual (i), realiza a troca
            if (min_idx != i) {
                System.out.println("  Trocando " + numeros[i] + " (índice " + i + ") com " + numeros[min_idx] + " (índice " + min_idx + ")");
                int temp = numeros[min_idx];
                numeros[min_idx] = numeros[i];
                numeros[i] = temp;
            } else {
                System.out.println("  O menor elemento já está na posição correta (índice " + i + "). Nenhuma troca necessária.");
            }

            // Imprime o array após a iteração (ou seja, após a troca ou não-troca)
            System.out.print("  Array após esta iteração: ");
            for (int k = 0; k < n; k++) {
                System.out.print(numeros[k] + " ");
            }
            System.out.println("\n"); // Nova linha para a próxima iteração
        }

        System.out.println("-------------------------------------\n");
        System.out.println("Array ordenado final:");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println();
    }
}
