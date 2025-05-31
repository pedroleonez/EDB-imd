package lista_exercicios.aula05;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int vetor[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println("Digite o valor de referência: ");
        int valorReferencia = sc.nextInt();
        sc.close();

        int soma = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > valorReferencia) {
                soma += vetor[i];
            }
        }

        System.out.println("A soma dos valores maiores que " + valorReferencia + " é: " + soma);
    }
}
