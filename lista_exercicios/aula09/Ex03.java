package lista_exercicios.aula09;

public class Ex03 {
    public static void main(String[] args) {
        // Vetor de 10 números inteiros definidos manualmente
        int[] numeros = {64, 34, 25, 12, 22, 11, 90, 88, 77, 66};
        int n = numeros.length;

        System.out.println("Array original:");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println("\n");

        System.out.println("--- Iniciando a ordenação decrescente com Bubble Sort ---\n");

        // Implementação do algoritmo Bubble Sort para ordem decrescente
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            System.out.println("Passagem " + (i + 1) + ":");
            for (int j = 0; j < n - 1 - i; j++) {
                // AQUI está a mudança: de '>' para '<' para ordenar em ordem decrescente
                // Se o elemento atual for MENOR que o próximo, eles são trocados para que o MAIOR venha antes
                if (numeros[j] < numeros[j + 1]) {
                    System.out.println("  Trocando " + numeros[j] + " e " + numeros[j + 1]);
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                    trocou = true;
                }
            }
            System.out.print("  Array após esta passagem: ");
            for (int k = 0; k < n; k++) {
                System.out.print(numeros[k] + " ");
            }
            System.out.println("\n");

            if (!trocou) {
                System.out.println("Nenhuma troca na passagem " + (i + 1) + ". Array já ordenado decrescentemente.");
                break;
            }
        }

        System.out.println("----------------------------------------\n");
        System.out.println("Array ordenado final (Decrescente):");
        for (int k = 0; k < n; k++) {
            System.out.print(numeros[k] + " ");
        }
        System.out.println();
    }
}
