package lista_exercicios.aula06;

public class Ex05 {
    public static void main(String[] args) {
        int vetor[] = {10, 20, 35, 50, 52, 60, 70, 85, 100};

        int inicio = 0;
        int fim = vetor.length - 1;
        int resultado = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] > 50) {
                resultado = vetor[meio];
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        if (resultado != -1) {
            System.out.println("O menor valor maior que 50 é: " + resultado);
        } else {
            System.out.println("Nenhum valor maior que 50 foi encontrado.");
        }
    }
}
