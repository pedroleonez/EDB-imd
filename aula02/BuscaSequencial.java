package aula02;

public class BuscaSequencial {

    public static int buscaSequencial(int[] vetor, int valorBuscado) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorBuscado) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] vetor = {10, 20, 30, 40, 50};
        int valorBuscado = 30;
        
        int resultado = buscaSequencial(vetor, valorBuscado);
        if (resultado != -1) {
            System.out.println("Valor " + valorBuscado + " encontrado no índice: " + resultado);
        } else {
            System.out.println("Valor " + valorBuscado + " não encontrado no vetor.");
        }
    }
}
