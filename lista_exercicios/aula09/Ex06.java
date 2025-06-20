package lista_exercicios.aula09;

public class Ex06 {
    public static void main(String[] args) {
        // Vetor JÁ ordenado manualmente (exemplo)
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = numeros.length;
        long contadorComparacoes = 0; // Contador para o número de comparações

        System.out.println("Vetor original (já ordenado):");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println("\n");

        System.out.println("--- Iniciando Bubble Sort Otimizado ---\n");

        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            System.out.println("Passagem " + (i + 1) + ":");
            for (int j = 0; j < n - 1 - i; j++) {
                contadorComparacoes++; // Incrementa o contador a cada comparação
                if (numeros[j] > numeros[j + 1]) {
                    // Se o vetor estivesse realmente ordenado, este bloco não seria executado
                    // para um array já ordenado em ordem crescente.
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

            // Otimização: se nenhuma troca ocorreu nesta passagem, o array está ordenado
            if (!trocou) {
                System.out.println("Otimização ativada: Nenhuma troca na passagem " + (i + 1) + ". O vetor já está ordenado.");
                break; // Interrompe o loop externo
            }
        }

        System.out.println("----------------------------------------\n");
        System.out.println("Array ordenado final:");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        System.out.println("\nNúmero total de comparações realizadas: " + contadorComparacoes);
    }
}
