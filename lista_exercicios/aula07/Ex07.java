package lista_exercicios.aula07;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10]; // Vetor para 10 números
        int n = numeros.length;

        System.out.println("Por favor, digite 10 números inteiros:");

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next();
                System.out.print("Digite o número " + (i + 1) + ": ");
            }
            numeros[i] = scanner.nextInt();
        }

        System.out.println("\n---");
        System.out.print("Vetor original: ");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.println("---\n");

        // 1. Ordenação com Selection Sort (Ordem Crescente)
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[min_idx]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) {
                int temp = numeros[min_idx];
                numeros[min_idx] = numeros[i];
                numeros[i] = temp;
            }
        }

        System.out.print("Vetor ordenado (Selection Sort): ");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.println("---\n");

        // 2. Busca Binária
        System.out.print("Digite o número que deseja encontrar no vetor ordenado: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next();
            System.out.print("Digite o número que deseja encontrar: ");
        }
        int elementoProcurado = scanner.nextInt();

        int inicio = 0;
        int fim = n - 1;
        int posicaoEncontrada = -1; // -1 indica que o elemento não foi encontrado

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2; // Evita overflow para grandes arrays

            if (numeros[meio] == elementoProcurado) {
                posicaoEncontrada = meio;
                break; // Elemento encontrado
            }

            // Se o elemento procurado for maior, ignore a metade esquerda
            if (numeros[meio] < elementoProcurado) {
                inicio = meio + 1;
            }
            // Se o elemento procurado for menor, ignore a metade direita
            else {
                fim = meio - 1;
            }
        }

        if (posicaoEncontrada != -1) {
            System.out.println("O número " + elementoProcurado + " foi encontrado na posição (índice) " + posicaoEncontrada + " do vetor ordenado.");
        } else {
            System.out.println("O número " + elementoProcurado + " não foi encontrado no vetor.");
        }

        scanner.close();
    }
}
