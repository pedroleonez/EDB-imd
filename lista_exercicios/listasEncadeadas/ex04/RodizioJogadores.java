package ex04;

public class RodizioJogadores {

    static class Jogador {
        String nome;
        int pontuacao;
        Jogador proximo;

        Jogador(String nome, int pontuacao) {
            this.nome = nome;
            this.pontuacao = pontuacao;
            this.proximo = null;
        }
    }

    static class ListaCircular {
        private Jogador atual;
        private Jogador ultimo;
        private int tamanho = 0;

        // a) Adicionar jogador no final
        public void adicionarJogador(String nome, int pontuacao) {
            Jogador novo = new Jogador(nome, pontuacao);
            if (atual == null) {
                atual = novo;
                novo.proximo = novo;
                ultimo = novo;
            } else {
                novo.proximo = atual;
                ultimo.proximo = novo;
                ultimo = novo;
            }
            tamanho++;
            System.out.println("Jogador adicionado: " + nome);
        }

        // b) Remover jogador atual
        public void removerJogadorAtual() {
            if (atual == null) {
                System.out.println("Não há jogadores na lista.");
                return;
            }

            System.out.println("Removendo jogador: " + atual.nome);

            if (tamanho == 1) {
                atual = ultimo = null;
            } else {
                Jogador temp = atual;
                // Encontrar jogador anterior
                Jogador anterior = atual;
                while (anterior.proximo != atual) {
                    anterior = anterior.proximo;
                }
                anterior.proximo = atual.proximo;
                if (atual == ultimo) {
                    ultimo = anterior;
                }
                atual = atual.proximo;
            }

            tamanho--;
        }

        // c) Avançar para o próximo jogador
        public void avancarRodizio() {
            if (atual != null) {
                atual = atual.proximo;
                System.out.println("É a vez de: " + atual.nome + " (Pontuação: " + atual.pontuacao + ")");
            } else {
                System.out.println("Não há jogadores na lista.");
            }
        }

        // Mostrar jogador atual
        public void jogadorAtual() {
            if (atual != null) {
                System.out.println("Jogador atual: " + atual.nome + " | Pontuação: " + atual.pontuacao);
            } else {
                System.out.println("Lista vazia.");
            }
        }

        // Mostrar todos os jogadores na ordem do rodízio
        public void listarJogadores() {
            if (atual == null) {
                System.out.println("Nenhum jogador na lista.");
                return;
            }

            System.out.println("🎮 Lista de jogadores:");
            Jogador temp = atual;
            do {
                System.out.println("- " + temp.nome + " | Pontuação: " + temp.pontuacao);
                temp = temp.proximo;
            } while (temp != atual);
        }
    }

    public static void main(String[] args) {
        ListaCircular rodada = new ListaCircular();

        rodada.adicionarJogador("Alice", 10);
        rodada.adicionarJogador("Bob", 15);
        rodada.adicionarJogador("Carlos", 20);

        rodada.listarJogadores();

        System.out.println();
        rodada.jogadorAtual();
        rodada.avancarRodizio();
        rodada.avancarRodizio();
        rodada.removerJogadorAtual();
        rodada.listarJogadores();
    }
}
