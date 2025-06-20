package lista_exercicios.aula08;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[8];
        int n = numeros.length;

        System.out.println("Por favor, digite 8 números inteiros:");

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
        System.out.print("Vetor original (inserido pelo usuário): ");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.println("---\n");

        // Implementação do algoritmo Insertion Sort para ordem decrescente
        for (int i = 1; i < n; i++) {
            int chave = numeros[i];
            int j = i - 1;

            while (j >= 0 && numeros[j] < chave) {
                numeros[j + 1] = numeros[j];
                j = j - 1;
            }
            numeros[j + 1] = chave;
        }

        System.out.print("Vetor ordenado (Insertion Sort - Decrescente): ");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();

        scanner.close();
    }
}
