package lista_exercicios.aula08;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler do console
        int[] numeros = new int[8]; // Declara um vetor de inteiros com tamanho 8
        int n = numeros.length; // Armazena o tamanho do vetor

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

        System.out.println("\n---"); // Separador
        System.out.println("Array original (inserido pelo usuário):");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println();
        System.out.println("---\n"); // Separador

        // Implementação do algoritmo Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i; // Assume que o primeiro elemento não ordenado é o menor

            // Encontra o índice do menor elemento restante no array não ordenado
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[min_idx]) {
                    min_idx = j;
                }
            }

            // Realiza a troca apenas se o menor elemento não estiver já na posição correta
            if (min_idx != i) {
                int temp = numeros[min_idx];
                numeros[min_idx] = numeros[i];
                numeros[i] = temp;
            }
        }

        System.out.println("Array ordenado final (Selection Sort):");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println();

        scanner.close(); // Fecha o objeto Scanner para liberar recursos
    }
}
