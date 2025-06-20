package lista_exercicios.aula09;

public class Ex07 {
    public static void main(String[] args) {
        // Vetor desordenado (para ver trocas e comparações reais)
        int[] numeros = {64, 34, 25, 12, 22, 11, 90, 88, 77, 66};

        int n = numeros.length;
        long contadorComparacoes = 0; // Contador para o número de comparações
        long contadorTrocas = 0;      // Contador para o número de trocas

        System.out.println("Vetor original:");
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
                    // Troca arr[j] e arr[j+1]
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                    contadorTrocas++; // Incrementa o contador a cada troca
                    System.out.println("  Trocando " + numeros[j+1] + " (antigo) e " + numeros[j] + " (antigo)"); // Exibe a troca
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
        System.out.println("Número total de trocas realizadas: " + contadorTrocas);
    }
}
