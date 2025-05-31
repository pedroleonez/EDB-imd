package lista_exercicios.aula06;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o valor a ser buscado: ");
        
        int valorBuscado = sc.nextInt();
        sc.close();

        int inicio = 0;
        int fim = vetor.length - 1;
        int meio;
        boolean encontrado = false;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            if (vetor[meio] == valorBuscado) {
                System.out.println("Valor existe no vetor na posição: " + meio);
                encontrado = true;
                break;
            } else if (vetor[meio] < valorBuscado) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            System.out.println("Valor não encotrado no vetor.");
        }

        
    }
}
