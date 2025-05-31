package lista_exercicios.aula06;

public class Ex06 {
    public static void main(String[] args) {
        int[] vetor = {10, 15, 20, 20, 20, 25, 30, 35};

        int alvo = 20;
        int inicio = 0;
        int fim = vetor.length - 1;
        int resultado = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == alvo) {
                resultado = meio;
                fim = meio - 1;
            } else if (vetor[meio] < alvo) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (resultado != -1) {
            System.out.println("Primeira ocorrência de " + alvo + " está no índice: " + resultado);
        } else {
            System.out.println("Número " + alvo + " não encontrado.");
        }
    }
}
