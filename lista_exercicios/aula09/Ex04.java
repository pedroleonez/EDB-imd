package lista_exercicios.aula09;

public class Ex04 {
    public static void main(String[] args) {
        // Vetor de Strings definido manualmente
        String[] palavras = {"banana", "abacaxi", "laranja", "uva", "kiwi", "morango", "pera", "maca"};
        int n = palavras.length;

        System.out.println("Vetor de Strings original:");
        for (int i = 0; i < n; i++) {
            System.out.print(palavras[i] + (i == n - 1 ? "" : ", "));
        }
        System.out.println("\n");

        // Implementação do algoritmo Bubble Sort para Strings
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (palavras[j].compareTo(palavras[j + 1]) > 0) {
                    // Troca palavras[j] e palavras[j+1]
                    String temp = palavras[j];
                    palavras[j] = palavras[j + 1];
                    palavras[j + 1] = temp;
                    trocou = true;
                }
            }
            // Otimização: se nenhuma troca ocorreu nesta passagem, o array está ordenado
            if (!trocou) {
                break;
            }
        }

        System.out.println("Vetor de Strings ordenado (Ordem Alfabética - Bubble Sort):");
        for (int i = 0; i < n; i++) {
            System.out.print(palavras[i] + (i == n - 1 ? "" : ", "));
        }
        System.out.println();
    }
}
