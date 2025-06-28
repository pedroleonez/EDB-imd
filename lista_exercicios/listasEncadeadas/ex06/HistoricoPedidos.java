package ex06;

public class HistoricoPedidos {

    static class Pedido {
        int numero;
        String cliente;
        double valor;
        Pedido proximo;

        Pedido(int numero, String cliente, double valor) {
            this.numero = numero;
            this.cliente = cliente;
            this.valor = valor;
        }
    }

    static class ListaPedidos {
        private Pedido inicio;
        private Pedido fim;

        // a) Adicionar pedido ao final (ordem de chegada)
        public void adicionarPedido(int numero, String cliente, double valor) {
            Pedido novo = new Pedido(numero, cliente, valor);
            if (inicio == null) {
                inicio = fim = novo;
            } else {
                fim.proximo = novo;
                fim = novo;
            }
            System.out.println("Pedido #" + numero + " adicionado.");
        }

        // b) Cancelar pedido (remover por número)
        public void cancelarPedido(int numero) {
            if (inicio == null) {
                System.out.println("Histórico vazio.");
                return;
            }

            if (inicio.numero == numero) {
                System.out.println("Cancelando pedido #" + numero);
                inicio = inicio.proximo;
                if (inicio == null) fim = null;
                return;
            }

            Pedido atual = inicio;
            while (atual.proximo != null && atual.proximo.numero != numero) {
                atual = atual.proximo;
            }

            if (atual.proximo != null) {
                System.out.println("Cancelando pedido #" + numero);
                atual.proximo = atual.proximo.proximo;
                if (atual.proximo == null) fim = atual;
            } else {
                System.out.println("Pedido #" + numero + " não encontrado.");
            }
        }

        // c) Listar todos os pedidos em andamento
        public void listarPedidos() {
            if (inicio == null) {
                System.out.println("Nenhum pedido em andamento.");
                return;
            }

            Pedido atual = inicio;
            System.out.println("\n📋 Pedidos em andamento:");
            while (atual != null) {
                System.out.printf("- Pedido #%d | Cliente: %s | Valor: R$ %.2f\n",
                        atual.numero, atual.cliente, atual.valor);
                atual = atual.proximo;
            }
        }
    }

    public static void main(String[] args) {
        ListaPedidos pedidos = new ListaPedidos();

        pedidos.adicionarPedido(101, "Alice", 85.50);
        pedidos.adicionarPedido(102, "Bruno", 45.00);
        pedidos.adicionarPedido(103, "Clara", 120.75);

        pedidos.listarPedidos();

        System.out.println();
        pedidos.cancelarPedido(102);
        pedidos.listarPedidos();

        System.out.println();
        pedidos.cancelarPedido(999); // pedido não existe
    }
}

