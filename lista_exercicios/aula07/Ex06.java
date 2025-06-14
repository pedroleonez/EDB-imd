package lista_exercicios.aula07;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[5];
        int n = nomes.length;

        System.out.println("Por favor, digite 5 nomes:");

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        System.out.println("\n---");
        System.out.println("Nomes originais (inseridos pelo usuário):");
        for (int k = 0; k < n; k++) {
            System.out.print(nomes[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.println("---\n");

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (nomes[j].compareTo(nomes[min_idx]) < 0) {
                    min_idx = j;
                }
            }

            if (min_idx != i) {
                String temp = nomes[min_idx];
                nomes[min_idx] = nomes[i];
                nomes[i] = temp;
            }
        }

        System.out.println("Nomes ordenados em ordem alfabética (Selection Sort):");
        for (int k = 0; k < n; k++) {
            System.out.print(nomes[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();

        scanner.close();
    }
}