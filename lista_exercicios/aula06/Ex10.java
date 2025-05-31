package lista_exercicios.aula06;

public class Ex10 {
    public static void main(String[] args) {
        String[] vetor = {
            "abacate", "banana", "caju", "damasco", "figo",
            "goiaba", "jaca", "kiwi", "laranja", "manga",
            "nectarina", "pera", "pessego", "uva", "zimbro"
        };

        String alvo = "laranja";
        int inicio = 0;
        int fim = vetor.length - 1;
        int letrasComparadas = 0;
        boolean encontrado = false;

        System.out.println("Buscando: " + alvo);

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            String atual = vetor[meio];

            int minLen = Math.min(alvo.length(), atual.length());
            int i = 0;
            while (i < minLen && alvo.charAt(i) == atual.charAt(i)) {
                letrasComparadas++;
                i++;
            }
            if (i < minLen) {
                letrasComparadas++;
            }

            int comparacao = alvo.compareTo(atual);

            if (comparacao == 0) {
                System.out.println(">> Palavra encontrada no índice: " + meio);
                encontrado = true;
                break;
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        if (!encontrado) {
            System.out.println(">> Palavra não encontrada.");
        }

        System.out.println("Total de letras comparadas: " + letrasComparadas);
    }
}
