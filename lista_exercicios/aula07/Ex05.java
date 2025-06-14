package lista_exercicios.aula07;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] palavras = new String[5];
        int n = palavras.length;

        System.out.println("Por favor, digite 5 palavras:");

        for (int i = 0; i < n; i++) {
            System.out.print("Digite a palavra " + (i + 1) + ": ");
            palavras[i] = scanner.nextLine();
        }

        System.out.println("\n---");
        System.out.println("Vetor original (inserido pelo usuário):");
        for (int k = 0; k < n; k++) {
            System.out.print(palavras[k] + " ");
        }
        System.out.println();
        System.out.println("---\n");

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (palavras[j].compareTo(palavras[min_idx]) < 0) {
                    min_idx = j;
                }
            }

            if (min_idx != i) {
                String temp = palavras[min_idx];
                palavras[min_idx] = palavras[i];
                palavras[i] = temp;
            }
        }

        System.out.println("Vetor ordenado em ordem alfabética (Selection Sort):");
        for (int k = 0; k < n; k++) {
            System.out.print(palavras[k] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
