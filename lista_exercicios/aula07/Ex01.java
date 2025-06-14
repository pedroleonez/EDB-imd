package lista_exercicios.aula07;

public class Ex01 {
    public static void main(String[] args) {
        int[] numeros = {64, 25, 12, 22, 11, 90, 78, 34, 56, 10};
        int n = numeros.length;

        System.out.println("Array original:");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        // Implementação do Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i; // Assume que o primeiro elemento não ordenado é o menor

            // Encontra o índice do menor elemento restante no array não ordenado
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[min_idx]) {
                    min_idx = j;
                }
            }

            // Troca o menor elemento encontrado com o primeiro elemento não ordenado
            int temp = numeros[min_idx];
            numeros[min_idx] = numeros[i];
            numeros[i] = temp;
        }

        System.out.println("---");

        System.out.println("Array ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }
}