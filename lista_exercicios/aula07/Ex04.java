package lista_exercicios.aula07;

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
        System.out.println("Array original (inserido pelo usuário):");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println();
        System.out.println("---\n");

        for (int i = 0; i < n - 1; i++) {
            int max_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (numeros[j] > numeros[max_idx]) {
                    max_idx = j;
                }
            }

            if (max_idx != i) {
                int temp = numeros[max_idx];
                numeros[max_idx] = numeros[i];
                numeros[i] = temp;
            }
        }

        System.out.println("Array ordenado em ordem DECRESCENTE (Selection Sort):");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
