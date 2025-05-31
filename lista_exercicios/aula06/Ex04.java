package lista_exercicios.aula06;

public class Ex04 {
    public static void main(String[] args) {
        String nomes[] = { "Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gustavo", "Helena", "Igor", "Juliana", "Karina", "Lucas", "Maria", "Nicolas", "Olivia", "Paulo", "Quiteria", "Rafael", "Sofia", "Tiago", "Ursula", "Vinicius", "Wanda", "Xavier", "Yara", "Zoe" };

        String nomeBuscado = "Maria";

        int inicio = 0;
        int fim = nomes.length - 1;
        int meio;
        boolean encontrado = false;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            int comparacao = nomes[meio].compareTo(nomeBuscado);

            if (comparacao == 0) {
                System.out.println("Nome encontrado no índice: " + meio);
                encontrado = true;
                break;
            } else if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            System.out.println("Nome não encontrado.");
        }
    }
}
