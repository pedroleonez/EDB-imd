package ex03;

public class CarrinhoDeCompras {

    static class Item {
        String nome;
        int quantidade;
        double precoUnitario;
        Item anterior;
        Item proximo;

        Item(String nome, int quantidade, double precoUnitario) {
            this.nome = nome;
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
        }

        double calcularTotal() {
            return quantidade * precoUnitario;
        }
    }

    static class Carrinho {
        private Item primeiro;
        private Item ultimo;
        private Item atual;

        // a) Adicionar item ao final
        public void adicionarItem(String nome, int quantidade, double precoUnitario) {
            Item novo = new Item(nome, quantidade, precoUnitario);
            if (primeiro == null) {
                primeiro = ultimo = atual = novo;
            } else {
                ultimo.proximo = novo;
                novo.anterior = ultimo;
                ultimo = novo;
            }
            System.out.println("Item adicionado: " + nome);
        }

        // b) Remover item atual
        public void removerItemAtual() {
            if (atual == null) {
                System.out.println("Nenhum item para remover.");
                return;
            }

            System.out.println("Removendo: " + atual.nome);

            if (atual == primeiro && atual == ultimo) {
                primeiro = ultimo = atual = null;
            } else if (atual == primeiro) {
                primeiro = atual.proximo;
                primeiro.anterior = null;
                atual = primeiro;
            } else if (atual == ultimo) {
                ultimo = atual.anterior;
                ultimo.proximo = null;
                atual = ultimo;
            } else {
                Item anterior = atual.anterior;
                Item proximo = atual.proximo;
                anterior.proximo = proximo;
                proximo.anterior = anterior;
                atual = proximo;
            }
        }

        // c) Navegar para frente
        public void avancar() {
            if (atual != null && atual.proximo != null) {
                atual = atual.proximo;
                exibirAtual();
            } else {
                System.out.println("Não há próximo item.");
            }
        }

        // c) Navegar para trás
        public void voltar() {
            if (atual != null && atual.anterior != null) {
                atual = atual.anterior;
                exibirAtual();
            } else {
                System.out.println("Não há item anterior.");
            }
        }

        // Mostrar item atual
        public void exibirAtual() {
            if (atual != null) {
                System.out.printf("Item atual: %s | Quantidade: %d | Preço: R$%.2f | Total: R$%.2f\n",
                        atual.nome, atual.quantidade, atual.precoUnitario, atual.calcularTotal());
            } else {
                System.out.println("Carrinho vazio.");
            }
        }

        // Listar todos os itens
        public void listarItens() {
            if (primeiro == null) {
                System.out.println("Carrinho vazio.");
                return;
            }
            Item temp = primeiro;
            System.out.println("🛒 Itens no carrinho:");
            while (temp != null) {
                System.out.printf("- %s | Quantidade: %d | Preço: R$%.2f | Total: R$%.2f\n",
                        temp.nome, temp.quantidade, temp.precoUnitario, temp.calcularTotal());
                temp = temp.proximo;
            }
        }
    }

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarItem("Arroz", 2, 5.99);
        carrinho.adicionarItem("Feijão", 1, 7.49);
        carrinho.adicionarItem("Macarrão", 3, 3.50);

        carrinho.listarItens();

        System.out.println();
        carrinho.exibirAtual();
        carrinho.avancar();
        carrinho.voltar();

        System.out.println();
        carrinho.removerItemAtual();
        carrinho.listarItens();
    }
}

