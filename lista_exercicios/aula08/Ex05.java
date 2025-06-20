package lista_exercicios.aula08;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[5];
        int n = nomes.length;

        System.out.println("Por favor, digite " + n + " nomes:");

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine(); // Usa nextLine() para ler a linha inteira (incluindo espaços)
        }

        System.out.println("\n---");
        System.out.print("Nomes originais (inseridos pelo usuário): ");
        for (int k = 0; k < n; k++) {
            System.out.print(nomes[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.println("---\n");

        // Implementação do algoritmo Insertion Sort para Strings (ordem alfabética)
        for (int i = 1; i < n; i++) {
            String chave = nomes[i]; // O elemento String a ser inserido
            int j = i - 1;         // O último elemento da parte já ordenada

            while (j >= 0 && nomes[j].compareTo(chave) > 0) { // Compara strings: nomes[j] > chave
                nomes[j + 1] = nomes[j]; // Desloca o elemento para a direita
                j = j - 1;
            }
            nomes[j + 1] = chave; // Insere a 'chave' na sua posição correta
        }

        System.out.print("Nomes ordenados em ordem alfabética (Insertion Sort): ");
        for (int k = 0; k < n; k++) {
            System.out.print(nomes[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();

        scanner.close();
    }
}
