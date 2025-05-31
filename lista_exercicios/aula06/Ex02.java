package lista_exercicios.aula06;

public class Ex02 {
    public static void main(String[] args) {
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 17, 20, 27, 30, 35, 38, 40};

        int valorBuscado = 35;
        int inicio = 0;
        int fim = vetor.length - 1;
        int meio;
        boolean encontrado = false;

        while (inicio <= fim) {
            System.out.println("Início: " + inicio + ", Fim: " + fim);
            meio = (inicio + fim) / 2;

            System.out.println("Verificando meio: " + meio + " com valor: " + vetor[meio]);
            if (vetor[meio] == valorBuscado) {
                System.out.println("Elemento encontrado no vetor!");
                encontrado = true;
                break;
            } else if (vetor[meio] < valorBuscado) {
                System.out.println("Valor buscado é maior que o meio, ajustando início.");
                inicio = meio + 1;
            } else {
                System.out.println("Valor buscado é menor que o meio, ajustando fim.");
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            System.out.println("Elemento não encontrado no vetor.");
        }
    }
}
