package aula07;

import java.util.Arrays;

public class Ordenacao {
    public static void main(String[] args) {
        int array[] = {5, 3, 8, 6, 2};
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.print("Array ordenado: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int array2[] = {5, 3, 8, 6, 2, 7, 4, 1, 9, 0};
        Arrays.sort(array2);
        System.out.println("\nArray2 ordenado: " + Arrays.toString(array2));
    }
}