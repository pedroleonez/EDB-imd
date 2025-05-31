package lista_exercicios.aula05;

public class Ex05 {
    public static void main(String[] args) {
        int vetor[] = {1, 2, 0, 4, 5, 0, 7, 8, 0, 10};
        int valorContado = 0;
        int contador = 0;
        
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorContado) {
                contador++;
            }
        }
        
        if (contador > 0) {
            System.out.println("O valor " + valorContado + " aparece " + contador + " vezes no vetor.");
        } else {
            System.out.println("O valor " + valorContado + " não aparece no vetor.");
        }
    }
}
