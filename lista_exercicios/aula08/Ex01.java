package lista_exercicios.aula08;

public class Ex01 {
    public static void main(String[] args) {
        // Vetor de 10 números inteiros definidos manualmente
        int[] numeros = {12, 11, 13, 5, 6, 8, 7, 10, 9, 4};
        int n = numeros.length;

        System.out.println("Array original:");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println("\n");

        for (int i = 1; i < n; i++) {
            int chave = numeros[i];
            int j = i - 1;

            while (j >= 0 && numeros[j] > chave) {
                numeros[j + 1] = numeros[j]; // Desloca o elemento para a direita
                j = j - 1;
            }
            numeros[j + 1] = chave; // Insere a 'chave' na sua posição correta
        }

        System.out.println("Array ordenado (Insertion Sort):");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }
}