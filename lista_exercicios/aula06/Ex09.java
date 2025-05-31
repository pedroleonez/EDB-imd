package lista_exercicios.aula06;

public class Ex09 {
    public static void main(String[] args) {
        int[] vetor = new int[30];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i * 2;
        }

        int alvo = 36;
        int inicio = 0;
        int fim = vetor.length - 1;
        int comparacoes = 0;
        boolean encontrado = false;

        System.out.println("Iniciando busca binária pelo número " + alvo + "...");

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            comparacoes++;

            System.out.println("\nComparação #" + comparacoes);
            System.out.println("Intervalo atual: índice " + inicio + " até " + fim);
            System.out.println("Elemento do meio (índice " + meio + "): " + vetor[meio]);

            if (vetor[meio] == alvo) {
                System.out.println(">> Valor encontrado no índice: " + meio);
                encontrado = true;
                break;
            } else if (vetor[meio] < alvo) {
                int eliminados = meio - inicio + 1;
                System.out.println("Eliminando " + eliminados + " elemento(s) à esquerda (índices " + inicio + " a " + meio + ")");
                inicio = meio + 1;
            } else {
                int eliminados = fim - meio + 1;
                System.out.println("Eliminando " + eliminados + " elemento(s) à direita (índices " + meio + " a " + fim + ")");
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            System.out.println("\nValor não encontrado no vetor.");
        }

        System.out.println("\nTotal de comparações realizadas: " + comparacoes);
    }
}
