package ex02;

public class Playlist {

    static class Musica {
        String nome;
        int duracao; // em segundos
        Musica anterior;
        Musica proxima;

        Musica(String nome, int duracao) {
            this.nome = nome;
            this.duracao = duracao;
        }
    }

    static class ListaCircular {
        private Musica atual;
        private int tamanho = 0;

        // a) Avançar para a próxima música
        public void avancar() {
            if (atual != null) {
                atual = atual.proxima;
                System.out.println("Tocando: " + atual.nome);
            } else {
                System.out.println("Playlist vazia.");
            }
        }

        // b) Voltar para a música anterior
        public void voltar() {
            if (atual != null) {
                atual = atual.anterior;
                System.out.println("Tocando: " + atual.nome);
            } else {
                System.out.println("Playlist vazia.");
            }
        }

        // c) Adicionar música em qualquer posição (0 = início, tamanho = fim)
        public void adicionar(String nome, int duracao, int posicao) {
            if (posicao < 0 || posicao > tamanho) {
                System.out.println("Posição inválida.");
                return;
            }

            Musica nova = new Musica(nome, duracao);

            if (atual == null) {
                nova.proxima = nova;
                nova.anterior = nova;
                atual = nova;
            } else if (posicao == 0) {
                Musica ultimo = atual.anterior;
                nova.proxima = atual;
                nova.anterior = ultimo;
                atual.anterior = nova;
                ultimo.proxima = nova;
                atual = nova; // atualiza para nova música no início
            } else {
                Musica aux = atual;
                for (int i = 0; i < posicao; i++) {
                    aux = aux.proxima;
                }
                Musica anterior = aux.anterior;
                nova.proxima = aux;
                nova.anterior = anterior;
                anterior.proxima = nova;
                aux.anterior = nova;
            }

            tamanho++;
            System.out.println("Música adicionada: " + nome);
        }

        // c) Remover música na posição desejada
        public void remover(int posicao) {
            if (posicao < 0 || posicao >= tamanho || atual == null) {
                System.out.println("Posição inválida.");
                return;
            }

            if (tamanho == 1) {
                System.out.println("Removendo última música: " + atual.nome);
                atual = null;
            } else {
                Musica aux = atual;
                for (int i = 0; i < posicao; i++) {
                    aux = aux.proxima;
                }
                Musica anterior = aux.anterior;
                Musica proxima = aux.proxima;
                anterior.proxima = proxima;
                proxima.anterior = anterior;

                if (aux == atual) {
                    atual = proxima;
                }
                System.out.println("Música removida: " + aux.nome);
            }

            tamanho--;
        }

        // Mostrar a música atual
        public void tocarAtual() {
            if (atual != null) {
                System.out.println("Tocando agora: " + atual.nome + " (" + atual.duracao + "s)");
            } else {
                System.out.println("Playlist vazia.");
            }
        }

        public void listar() {
            if (atual == null) {
                System.out.println("Playlist vazia.");
                return;
            }

            Musica temp = atual;
            System.out.println("🎵 Playlist:");
            for (int i = 0; i < tamanho; i++) {
                System.out.println("- " + temp.nome + " (" + temp.duracao + "s)");
                temp = temp.proxima;
            }
        }
    }

    public static void main(String[] args) {
        ListaCircular playlist = new ListaCircular();

        playlist.adicionar("Música A", 210, 0);
        playlist.adicionar("Música B", 180, 1);
        playlist.adicionar("Música C", 200, 2);
        playlist.tocarAtual();
        playlist.avancar();
        playlist.voltar();
        playlist.listar();
        playlist.remover(1);
        playlist.listar();
    }
}

