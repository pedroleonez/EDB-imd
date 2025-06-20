package lista_exercicios.aula08;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos elementos você deseja ter no vetor? ");
        // Validação para garantir um número inteiro positivo
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next();
            System.out.print("Quantos elementos você deseja ter no vetor? ");
        }
        int tamanho = scanner.nextInt();

        if (tamanho <= 0) {
            System.out.println("O tamanho do vetor deve ser um número positivo. Encerrando o programa.");
            scanner.close();
            return;
        }

        int[] vetor = new int[tamanho];

        System.out.println("\nPor favor, digite os " + tamanho + " números inteiros em ORDEM CRESCENTE:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next();
                System.out.print("Elemento " + (i + 1) + ": ");
            }
            vetor[i] = scanner.nextInt();
        }

        System.out.println("\n---");
        System.out.print("Vetor inserido: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + (i == tamanho - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.println("---\n");

        System.out.print("Digite o valor que deseja buscar no vetor: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next();
            System.out.print("Digite o valor que deseja buscar: ");
        }
        int valorProcurado = scanner.nextInt();

        // Implementação da Busca Binária
        int inicio = 0;
        int fim = tamanho - 1;
        int posicaoEncontrada = -1; // -1 indica que o valor não foi encontrado

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2; // Calcula o índice do meio

            if (vetor[meio] == valorProcurado) {
                posicaoEncontrada = meio; // Valor encontrado!
                break; // Sai do loop
            } else if (vetor[meio] < valorProcurado) {
                // Se o valor no meio for menor que o procurado, busca na metade direita
                inicio = meio + 1;
            } else {
                // Se o valor no meio for maior que o procurado, busca na metade esquerda
                fim = meio - 1;
            }
        }

        // Exibe o resultado da busca
        if (posicaoEncontrada != -1) {
            System.out.println("O valor " + valorProcurado + " foi encontrado na posição (índice) " + posicaoEncontrada + ".");
        } else {
            System.out.println("O valor " + valorProcurado + " não foi encontrado no vetor.");
        }

        scanner.close(); // Fecha o Scanner
    }
}
