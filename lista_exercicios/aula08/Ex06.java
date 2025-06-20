package lista_exercicios.aula08;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos nomes você deseja inserir? ");
        // Valida para garantir que a quantidade de nomes é um número inteiro
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next(); // Descarta a entrada inválida
            System.out.print("Quantos nomes você deseja inserir? ");
        }
        int quantidadeNomes = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha pendente após nextInt()

        // Verifica se a quantidade de nomes é válida
        if (quantidadeNomes <= 0) {
            System.out.println("A quantidade de nomes deve ser um número positivo. Encerrando o programa.");
            scanner.close();
            return; // Encerra o programa
        }

        String[] nomes = new String[quantidadeNomes]; // Cria o vetor para armazenar os nomes
        int n = nomes.length;

        System.out.println("\nPor favor, digite os " + quantidadeNomes + " nomes:");

        // Loop para ler os nomes do usuário e armazená-los no vetor
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine(); // Lê a linha inteira para o nome
        }

        System.out.println("\n---");
        System.out.print("Nomes originais (inseridos pelo usuário): ");
        for (int k = 0; k < n; k++) {
            System.out.print(nomes[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.println("---\n");

        // Implementação do algoritmo Insertion Sort para Strings (ordem alfabética crescente)
        for (int i = 1; i < n; i++) {
            String chave = nomes[i]; // O nome a ser inserido
            int j = i - 1;         // Último nome da sub-array já ordenada

            while (j >= 0 && nomes[j].compareTo(chave) > 0) {
                nomes[j + 1] = nomes[j]; // Desloca o nome para a direita
                j = j - 1;
            }
            nomes[j + 1] = chave; // Insere a 'chave' na sua posição correta
        }

        System.out.print("Nomes ordenados em ordem alfabética: ");
        for (int k = 0; k < n; k++) {
            System.out.print(nomes[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();

        scanner.close(); // Fecha o objeto Scanner
    }
}
