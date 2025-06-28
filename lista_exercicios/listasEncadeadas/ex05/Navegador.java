package ex05;

public class Navegador {

    static class Pagina {
        String url;
        String titulo;
        Pagina anterior;
        Pagina proxima;

        Pagina(String url, String titulo) {
            this.url = url;
            this.titulo = titulo;
        }
    }

    static class HistoricoNavegacao {
        private Pagina atual;

        // a) Avançar para a próxima página
        public void avancar() {
            if (atual != null && atual.proxima != null) {
                atual = atual.proxima;
                exibirAtual();
            } else {
                System.out.println("Não há próxima página.");
            }
        }

        // b) Voltar para a página anterior
        public void voltar() {
            if (atual != null && atual.anterior != null) {
                atual = atual.anterior;
                exibirAtual();
            } else {
                System.out.println("Não há página anterior.");
            }
        }

        // Visitar uma nova página (descarta páginas "à frente")
        public void visitarNovaPagina(String url, String titulo) {
            Pagina nova = new Pagina(url, titulo);
            if (atual != null) {
                // Descartar todas as próximas
                atual.proxima = null;
                nova.anterior = atual;
                atual.proxima = nova;
            }
            atual = nova;
            System.out.println("Nova página visitada: " + titulo + " (" + url + ")");
        }

        public void exibirAtual() {
            if (atual != null) {
                System.out.println("Página atual: " + atual.titulo + " (" + atual.url + ")");
            } else {
                System.out.println("Nenhuma página foi visitada.");
            }
        }

        // Para depuração: mostra histórico até o início
        public void mostrarHistorico() {
            Pagina temp = atual;
            while (temp != null && temp.anterior != null) {
                temp = temp.anterior;
            }

            System.out.println("\n📜 Histórico de navegação:");
            while (temp != null) {
                System.out.println("- " + temp.titulo + " (" + temp.url + ")");
                temp = temp.proxima;
            }
        }
    }

    public static void main(String[] args) {
        HistoricoNavegacao navegador = new HistoricoNavegacao();

        navegador.visitarNovaPagina("https://google.com", "Google");
        navegador.visitarNovaPagina("https://openai.com", "OpenAI");
        navegador.visitarNovaPagina("https://github.com", "GitHub");

        navegador.voltar();
        navegador.voltar();
        navegador.avancar();

        navegador.visitarNovaPagina("https://stackoverflow.com", "Stack Overflow");

        navegador.exibirAtual();
        navegador.mostrarHistorico();
    }
}

