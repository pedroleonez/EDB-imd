package lista_exercicios.aula05;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String vetor[] = {"maçã", "banana", "laranja", "uva", "pera", "kiwi"};
        
        System.out.print("Digite o nome da fruta a ser buscada: ");
        
        String valorBuscado = sc.nextLine();
        sc.close();

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(valorBuscado)) {
                System.out.println("Fruta " + valorBuscado + " encontrada no índice: " + i);
                return;
            }
        }
        System.out.println("Fruta " + valorBuscado + " não encontrado no vetor.");
    }
}
