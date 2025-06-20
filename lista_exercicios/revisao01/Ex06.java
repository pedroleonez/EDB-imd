package lista_exercicios.revisao01;

import java.util.Scanner;

// Classe que representa um Produto
class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: R$" + String.format("%.2f", preco);
    }
}

public class Ex06 {

    public static void insertionSortProdutos(Produto[] produtos, String sortBy) {
        int n = produtos.length;
        for (int i = 1; i < n; i++) {
            Produto chave = produtos[i]; // O produto a ser inserido
            int j = i - 1;               // Último produto da sub-array já ordenada

            // Move os produtos da sub-array ordenada que são "maiores" que a 'chave'
            // para uma posição à frente.
            while (j >= 0) {
                boolean shouldShift = false;

                if (sortBy.equalsIgnoreCase("nome")) {
                    // Compara por nome alfabeticamente
                    if (produtos[j].getNome().compareToIgnoreCase(chave.getNome()) > 0) {
                        shouldShift = true;
                    }
                } else if (sortBy.equalsIgnoreCase("preco")) {
                    // Compara por preço crescentemente
                    if (produtos[j].getPreco() > chave.getPreco()) {
                        shouldShift = true;
                    }
                }

                if (shouldShift) {
                    produtos[j + 1] = produtos[j];
                    j = j - 1;
                } else {
                    break; // Para de deslocar quando encontra a posição correta
                }
            }
            produtos[j + 1] = chave; // Insere o produto na sua posição correta
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxProdutos = 5; // Limite para demonstração, mas pode ser até 100
        Produto[] produtos = new Produto[maxProdutos];

        System.out.println("--- Cadastro de Produtos (até " + maxProdutos + ") ---");
        for (int i = 0; i < maxProdutos; i++) {
            System.out.println("\nProduto " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            double preco = 0.0;
            boolean precoValido = false;
            while (!precoValido) {
                System.out.print("Preço: R$");
                if (scanner.hasNextDouble()) {
                    preco = scanner.nextDouble();
                    if (preco >= 0) {
                        precoValido = true;
                    } else {
                        System.out.println("Preço inválido. Digite um valor não negativo.");
                    }
                } else {
                    System.out.println("Entrada inválida. Digite um número decimal para o preço.");
                    scanner.next(); // Consome a entrada inválida
                }
                scanner.nextLine(); // Consome a quebra de linha pendente
            }
            produtos[i] = new Produto(nome, preco);
        }

        System.out.println("\n--- Produtos Cadastrados (Original) ---");
        for (Produto p : produtos) {
            System.out.println(p);
        }

        // Ordenar por Nome
        insertionSortProdutos(produtos, "nome");
        System.out.println("\n--- Produtos Ordenados por Nome ---");
        for (Produto p : produtos) {
            System.out.println(p);
        }

        insertionSortProdutos(produtos, "preco");
        System.out.println("\n--- Produtos Ordenados por Preço ---");
        for (Produto p : produtos) {
            System.out.println(p);
        }

        scanner.close();
    }
}
