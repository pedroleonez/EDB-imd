package lista_exercicios.aula06;

public class Ex08 {
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

        while (inicio <= fim) {
            comparacoes++;

            int meio = (inicio + fim) / 2;

            if (vetor[meio] == alvo) {
                System.out.println("Valor encontrado no índice: " + meio);
                encontrado = true;
                break;
            } else if (vetor[meio] < alvo) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            System.out.println("Valor não encontrado.");
        }

        System.out.println("Total de comparações: " + comparacoes);
    }
}
