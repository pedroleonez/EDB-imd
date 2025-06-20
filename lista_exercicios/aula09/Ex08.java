package lista_exercicios.aula09;

public class Ex08 {
    public static void main(String[] args) {
        // Vetor de doubles com casas decimais definido manualmente (desordenado)
        double[] numeros = {3.14, 1.618, 2.718, 0.577, 9.876, 4.321, 5.0, 1.0, 7.77, 6.54};

        int n = numeros.length;
        long contadorComparacoes = 0; // Contador para o número de comparações
        long contadorTrocas = 0;      // Contador para o número de trocas

        System.out.println("Vetor original (doubles):");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println("\n");

        System.out.println("--- Iniciando Bubble Sort Otimizado para Doubles ---\n");

        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            System.out.println("Passagem " + (i + 1) + ":");
            for (int j = 0; j < n - 1 - i; j++) {
                contadorComparacoes++; // Incrementa o contador a cada comparação
                if (numeros[j] > numeros[j + 1]) { // Comparação para ordem crescente
                    // Troca arr[j] e arr[j+1]
                    double temp = numeros[j]; // Variável temporária agora é double
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                    contadorTrocas++; // Incrementa o contador a cada troca
                    System.out.println("  Trocando " + (double)Math.round(numeros[j+1]*100)/100 + " (antigo) e " + (double)Math.round(numeros[j]*100)/100 + " (antigo)"); // Exibe a troca (arredondando para melhor visualização)
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
