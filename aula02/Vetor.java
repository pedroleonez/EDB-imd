package aula02;

public class Vetor {
    public static void main(String[] args) {
        int[] vetor1 = {1, 2, 3, 4, 5};

        for (int i = vetor1.length - 1; i >= 0; i--) {
            System.out.println(vetor1[i]);
        }

        System.out.println("-------------------");
        
        int[] vetor2 = {10, 20, 30, 40, 50, 60};

        int soma = 0;
        for (int i = 0; i < vetor2.length; i++) {
            soma += vetor2[i];
        }

        double media = (double) soma / vetor2.length;

        System.out.println("Média: " + media);
        
        System.out.println("-------------------");

        for (int i = 0; i < vetor2.length; i++) {
            if (vetor2[i] > media) {
                System.out.println("Valor maior que a média: " + vetor2[i]);
            }
        }
        
        System.out.println("-------------------");

        String[] vetor3 = {"Ana", "Maria", "Anthony", "Pedro", "Lucas", "Angélica"};

        for (int i = 0; i < vetor3.length; i++) {
            if (vetor3[i].startsWith("A")) {
                System.out.println("Nome que começa com A: " + vetor3[i]);
            }
        }
        
        System.out.println("-------------------");

        double[] notas = {7.5, 8.0, 6.5, 9.0, 10.0, 5.5};
        double maiorNota = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
        }
        System.out.println("Maior nota: " + maiorNota);

        double menorNota = 0;
        for (int i = 0; i < notas.length; i++) {
            if (i == 0 || notas[i] < menorNota) {
                menorNota = notas[i];
            }
        }
        System.out.println("Menor nota: " + menorNota);

        double somaNotas = 0;
        for (int i = 0; i < notas.length; i++) {
            somaNotas += notas[i];
        }
        double mediaNotas = somaNotas / notas.length;
        System.out.println("Média das notas: " + mediaNotas);
        
        System.out.println("-------------------");
    }
}