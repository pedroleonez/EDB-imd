package lista_exercicios.aula05;

public class Ex07 {
    public static void main(String[] args) {
        double notas[] = {4.5, 7.0, 9.0, 6.5, 10.0, 5.5};

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > 7.0) {
                System.out.println("Primeira nota maior que 7: " + notas[i]);
                return;
            }
        }
    }
}
