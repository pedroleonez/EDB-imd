package lista_exercicios.aula05;

public class Ex01 {
    public static void main(String[] args) {
        int vetor[] = {1, 2, 3, 4, 5};
        int valorBuscado = 2;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorBuscado) {
                System.out.println("Valor " + valorBuscado + " encontrado no índice: " + i);
                return;
            }
        }
        System.out.println("Valor " + valorBuscado + " não encontrado no vetor.");
    }
}