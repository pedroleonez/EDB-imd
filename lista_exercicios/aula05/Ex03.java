package lista_exercicios.aula05;

public class Ex03 {
    public static void main(String[] args) {
        int vetor[] = {1, 2, 3, 4, 5, 25, 7, 8, 9, 10};
        int valorBuscado = 25;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorBuscado) {
                System.out.println("SIM");
                return;
            }
        }
        System.out.println("NÃO");
    }
}
