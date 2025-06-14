package lista_exercicios.aula07;

import java.util.Scanner;

public class Ex10 {
    
    // Método para implementar o Selection Sort para ordenar o vetor de notas
    public static void selectionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Troca o menor elemento encontrado com o primeiro elemento não ordenado
            double temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Método principal onde o programa executa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas notas você deseja inserir? ");
        // Garante que o usuário digite um número inteiro para a quantidade de notas
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next(); // Descarta a entrada inválida
            System.out.print("Quantas notas você deseja inserir? ");
        }
        int quantidadeNotas = scanner.nextInt();

        // Verifica se a quantidade de notas é válida
        if (quantidadeNotas <= 0) {
            System.out.println("A quantidade de notas deve ser um número positivo. Encerrando o programa.");
            scanner.close();
            return;
        }

        double[] notas = new double[quantidadeNotas]; // Cria o vetor para armazenar as notas

        System.out.println("\nPor favor, digite as " + quantidadeNotas + " notas:");

        // Loop para ler as notas do usuário
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print("Digite a nota " + (i + 1) + ": ");
            // Garante que o usuário digite um número decimal válido (nota)
            while (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Por favor, digite um número decimal (ex: 7.5).");
                scanner.next(); // Descarta a entrada inválida
                System.out.print("Digite a nota " + (i + 1) + ": ");
            }
            notas[i] = scanner.nextDouble(); // Lê a nota decimal digitada pelo usuário
        }

        System.out.println("\n---");
        System.out.print("Notas originais: ");
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print(notas[i] + (i == quantidadeNotas - 1 ? "" : " | "));
        }
        System.out.println();
        System.out.println("---\n");

        // Chama o método selectionSort para ordenar as notas
        selectionSort(notas);

        System.out.print("Notas ordenadas (crescente): ");
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print(notas[i] + (i == quantidadeNotas - 1 ? "" : " | "));
        }
        System.out.println();

        scanner.close();
    }
}
