package lista_exercicios.aula08;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define o tamanho do vetor para 6 notas
        int quantidadeNotas = 6; 
        double[] notas = new double[quantidadeNotas]; // Cria o vetor para armazenar as notas

        System.out.println("Por favor, digite as 6 notas dos alunos (use vírgula ou ponto para decimais):");

        // Loop para ler as notas do usuário
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            // Garante que o usuário digite um número decimal válido (nota)
            while (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Por favor, digite um número decimal (ex: 7.5 ou 7,5).");
                scanner.next(); // Descarta a entrada inválida
                System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
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

        // Implementação do algoritmo Insertion Sort para ordenar as notas
        for (int i = 1; i < quantidadeNotas; i++) {
            double chave = notas[i]; // A nota a ser inserida
            int j = i - 1;         // Último elemento da sub-array já ordenada

            // Move os elementos da sub-array ordenada que são maiores que 'chave'
            // para uma posição à frente de sua posição atual
            while (j >= 0 && notas[j] > chave) {
                notas[j + 1] = notas[j]; // Desloca o elemento para a direita
                j = j - 1;
            }
            notas[j + 1] = chave; // Insere a 'chave' na sua posição correta
        }

        System.out.print("Notas ordenadas em ordem crescente: ");
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print(notas[i] + (i == quantidadeNotas - 1 ? "" : " | "));
        }
        System.out.println();

        scanner.close();
    }
}
