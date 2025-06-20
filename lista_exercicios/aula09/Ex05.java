package lista_exercicios.aula09;

public class Ex05 {
    public static void main(String[] args) {
        // Vetor de Strings definido manualmente
        String[] palavras = {"banana", "abacaxi", "laranja", "uva", "kiwi", "morango", "pera", "maca"};
        int n = palavras.length;

        System.out.println("Vetor de Strings original:");
        for (int i = 0; i < n; i++) {
            System.out.print(palavras[i] + (i == n - 1 ? "" : ", "));
        }
        System.out.println("\n");

        // Implementação do algoritmo Bubble Sort com otimização
        boolean trocou; // Flag para verificar se houve trocas na passagem
        for (int i = 0; i < n - 1; i++) {
            trocou = false; // Assume que nenhuma troca ocorrerá nesta passagem

            // O último 'i' elementos já estão no lugar correto, então não precisamos compará-los
            for (int j = 0; j < n - 1 - i; j++) {
                // Compara strings usando compareTo()
                // Se palavras[j] for lexicograficamente "maior" que palavras[j+1], troca
                if (palavras[j].compareTo(palavras[j + 1]) > 0) {
                    // Realiza a troca
                    String temp = palavras[j];
                    palavras[j] = palavras[j + 1];
                    palavras[j + 1] = temp;
                    trocou = true; // Marca que uma troca ocorreu
                }
            }

            if (!trocou) {
                System.out.println("Otimização ativada: Nenhuma troca na passagem " + (i + 1) + ". O vetor já está ordenado.");
                break; // Interrompe o loop externo
            }
        }

        System.out.println("\n---");
        System.out.println("Vetor de Strings ordenado (Ordem Alfabética - Bubble Sort Otimizado):");
        for (int i = 0; i < n; i++) {
            System.out.print(palavras[i] + (i == n - 1 ? "" : ", "));
        }
        System.out.println();
    }
}
