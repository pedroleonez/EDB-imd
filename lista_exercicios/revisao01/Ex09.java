package lista_exercicios.revisao01;

public class Ex09 {
    public static void main(String[] args) {
        // Vetor de 20 nomes de alunos
        String[] nomes = {
            "Carlos", "Ana", "Bruno", "Daniela", "Eduardo",
            "Fabiana", "Gabriel", "Helena", "Igor", "Juliana",
            "Kleber", "Laura", "Marcelo", "Natalia", "Otavio",
            "Paula", "Quintino", "Raquel", "Sergio", "Tatiana"
        };
        int n = nomes.length;

        System.out.println("Vetor original de nomes:");
        for (int k = 0; k < n; k++) {
            System.out.print(nomes[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println("\n");

        System.out.println("--- Iniciando a ordenação alfabética com Insertion Sort (passo a passo) ---\n");

        // Implementação do algoritmo Insertion Sort para Strings
        for (int i = 1; i < n; i++) {
            String chave = nomes[i]; // O nome a ser inserido na sub-array ordenada
            int j = i - 1;         // Último nome da sub-array já ordenada

            System.out.println("Iteração " + i + ": Chave = '" + chave + "' (elemento no índice " + i + ")");
            System.out.print("  Estado atual da parte ordenada (até índice " + j + "): ");
            for (int k = 0; k <= j; k++) {
                System.out.print(nomes[k] + (k == j ? "" : ", "));
            }
            System.out.println();

            // Move os nomes da sub-array ordenada que são "maiores" (vêm depois na ordem alfabética)
            // que a 'chave' para uma posição à frente de sua posição atual.
            boolean houveDeslocamento = false;
            while (j >= 0 && nomes[j].compareToIgnoreCase(chave) > 0) {
                System.out.println("  Deslocando '" + nomes[j] + "' (índice " + j + ") para a direita.");
                nomes[j + 1] = nomes[j]; // Desloca o nome para a direita
                j = j - 1;
                houveDeslocamento = true;
            }
            nomes[j + 1] = chave; // Insere a 'chave' na sua posição correta

            if (houveDeslocamento || j + 1 != i) { // Imprime a inserção apenas se houve movimento ou se a chave não estava na posição inicial
                System.out.println("  Inserindo '" + chave + "' na posição " + (j + 1) + ".");
            } else {
                System.out.println("  A chave '" + chave + "' já estava na posição correta.");
            }

            System.out.print("  Array após esta inserção: ");
            for (int k = 0; k < n; k++) {
                System.out.print(nomes[k] + (k == n - 1 ? "" : ", "));
            }
            System.out.println("\n"); // Nova linha para a próxima iteração
        }

        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("Vetor ordenado final:");
        for (int k = 0; k < n; k++) {
            System.out.print(nomes[k] + (k == n - 1 ? "" : ", "));
        }
        System.out.println();
    }
}
