package lista_exercicios.aula05;

public class Ex09 {
    public static void main(String[] args) {
        String produtos[] = {"Mouse", "Teclado", "Monitor", "Impressora", "Scanner", "Webcam"};

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i].startsWith("M")) {
                System.out.println("O produto: " + produtos[i] + " começa com a letra 'M'.");
            }
        }
    }
}
