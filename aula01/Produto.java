package aula01;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void vender(int quantidadeVendida) {
        if (quantidadeVendida <= quantidade) {
            quantidade -= quantidadeVendida;
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }

    public void reporEstoque(int quantidadeReposta) {
        quantidade += quantidadeReposta;
    }

    public int consultarEstoque() {
        return quantidade;
    }

    public static void main(String[] args) {
        var produtoA = new Produto("Produto A", 10.0, 100);
        var produtoB = new Produto("Produto B", 20.0, 50);

        System.out.println("Estoque do " + produtoA.getNome() + ": " + produtoA.consultarEstoque());

        System.out.println("---------------------------------------");

        produtoA.vender(20);
        System.out.println("Estoque do " + produtoA.getNome() + " após venda: " + produtoA.consultarEstoque());

        System.out.println("---------------------------------------");

        produtoA.reporEstoque(30);
        System.out.println("Estoque do " + produtoA.getNome() + " após reposição: " + produtoA.consultarEstoque());

        System.out.println("---------------------------------------");

        System.out.println("Estoque do " + produtoB.getNome() + ": " + produtoB.consultarEstoque());

        System.out.println("---------------------------------------");

        produtoB.vender(40);
        System.out.println("Estoque do " + produtoB.getNome() + " após venda: " + produtoB.consultarEstoque());
    }
}
