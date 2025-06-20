package lista_exercicios.aula09;

public class Ex01 {
    public static void main(String[] args) {
        // Vetor de 10 números inteiros definidos manualmente
        int[] numeros = {64, 34, 25, 12, 22, 11, 90, 88, 77, 66};
        int n = numeros.length;

        System.out.println("Array original:");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println("\n");

        // Implementação do algoritmo Bubble Sort
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false; // Reinicia a flag para cada passagem
            // O último i elementos já estão no lugar correto, então não precisamos ir até o fim
            for (int j = 0; j < n - 1 - i; j++) {
                // Compara elementos adjacentes
                if (numeros[j] > numeros[j + 1]) {
                    // Troca arr[j] e arr[j+1]
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                    trocou = true; // Indica que houve uma troca nesta passagem
                }
            }
            // Se nenhuma troca ocorreu nesta passagem, o array está totalmente ordenado
            if (!trocou) {
                break;
            }
        }

        System.out.println("Array ordenado (Bubble Sort):");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }
}
