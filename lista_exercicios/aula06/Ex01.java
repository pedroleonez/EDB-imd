package lista_exercicios.aula06;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

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
                System.out.println("Elemento existe no vetor!");
                encontrado = true;
                break;
            } else if (vetor[meio] < valorBuscado) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            System.out.println("Elemento não existe no vetor.");
        }
    }
}
