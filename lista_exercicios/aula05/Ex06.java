package lista_exercicios.aula05;

public class Ex06 {
    public static void main(String[] args) {
        int vetor[] = {1, 2, 0, 4, 5, 0, 7, 8, 0, 10};
        int valorEncontrado = 0;

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] == valorEncontrado) {
                System.out.println("Valor " + valorEncontrado + " encontrado na posição: " + i);
            }
        }
    }
}
