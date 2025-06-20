package lista_exercicios.aula08;

public class Ex08 {
    public static void main(String[] args) {
        // Vetor de doubles com casas decimais definido manualmente
        double[] numeros = {3.14, 1.618, 2.718, 0.577, 9.876, 4.321, 5.0, 1.0, 7.77, 6.54};
        int n = numeros.length;

        System.out.println("Vetor original:");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println("\n");

        // Implementação do algoritmo Insertion Sort para doubles
        for (int i = 1; i < n; i++) {
            double chave = numeros[i]; // O elemento double a ser inserido
            int j = i - 1;         // Último elemento da sub-array já ordenada

            while (j >= 0 && numeros[j] > chave) {
                numeros[j + 1] = numeros[j]; // Desloca o elemento para a direita
                j = j - 1;
            }
            numeros[j + 1] = chave; // Insere a 'chave' na sua posição correta
        }

        System.out.println("Vetor ordenado (Insertion Sort):");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }
}
