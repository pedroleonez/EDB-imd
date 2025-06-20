package lista_exercicios.aula08;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler do console
        int[] numeros = new int[8]; // Declara um vetor de inteiros com tamanho 8
        int n = numeros.length;     // Armazena o tamanho do vetor

        System.out.println("Por favor, digite 8 números inteiros:");

        // Loop para ler os 8 números do usuário e armazená-los no vetor
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            // Garante que o usuário digitou um número inteiro válido
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Descarta a entrada inválida
                System.out.print("Digite o número " + (i + 1) + ": ");
            }
            numeros[i] = scanner.nextInt(); // Lê o número inteiro digitado pelo usuário
        }

        System.out.println("\n---");
        System.out.print("Vetor original (inserido pelo usuário): ");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.println("---\n");

        for (int i = 1; i < n; i++) {
            int chave = numeros[i]; // O elemento atual a ser inserido na parte ordenada
            int j = i - 1;         // O último elemento da parte já ordenada

            while (j >= 0 && numeros[j] > chave) {
                numeros[j + 1] = numeros[j]; // Desloca o elemento para a direita
                j = j - 1;
            }
            numeros[j + 1] = chave; // Insere a 'chave' na sua posição correta
        }

        System.out.print("Vetor ordenado (Insertion Sort): ");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();

        scanner.close();
    }
}
