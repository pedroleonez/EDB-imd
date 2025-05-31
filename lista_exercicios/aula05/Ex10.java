package lista_exercicios.aula05;

public class Ex10 {
    public static void main(String[] args) {
        int vetor[] = {5, 10, 15, 20, 25, 1, 35, 40};

        int menorValor = vetor[0];
        int indiceMenor = 0;
        
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < menorValor) {
                menorValor = vetor[i];
                indiceMenor = i;
            }
        }

        System.out.println("Indice do menor valor: " + indiceMenor);
    }
}
