package lista_exercicios.aula05;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int vetor[] = {1, 2, 3, 4, 5};
        
        System.out.print("Digite o valor a ser buscado: ");
        
        int valorBuscado = sc.nextInt();
        sc.close();

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorBuscado) {
                System.out.println("Valor " + valorBuscado + " encontrado no índice: " + i);
                return;
            }
        }
        System.out.println("Valor " + valorBuscado + " não encontrado no vetor.");
    }
}