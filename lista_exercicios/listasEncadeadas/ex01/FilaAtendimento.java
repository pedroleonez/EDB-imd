package ex01;
public class FilaAtendimento {

    // Classe que representa um paciente
    static class Paciente {
        String nome;
        int idade;
        int senha;
        Paciente proximo;

        Paciente(String nome, int idade, int senha) {
            this.nome = nome;
            this.idade = idade;
            this.senha = senha;
            this.proximo = null;
        }
    }

    static class Fila {
        private Paciente inicio;
        private Paciente fim;
        private int contadorSenha = 1;

        public Fila() {
            this.inicio = null;
            this.fim = null;
        }

        // a) Inserir paciente
        public void inserirPaciente(String nome, int idade) {
            Paciente novo = new Paciente(nome, idade, contadorSenha++);
            if (inicio == null) {
                // Lista vazia
                inicio = fim = novo;
            } else if (idade >= 60) {
                // Inserção com prioridade: logo após o último idoso
                if (inicio.idade < 60) {
                    // Nenhum idoso no início
                    novo.proximo = inicio;
                    inicio = novo;
                } else {
                    // Procurar o último idoso
                    Paciente atual = inicio;
                    while (atual.proximo != null && atual.proximo.idade >= 60) {
                        atual = atual.proximo;
                    }
                    novo.proximo = atual.proximo;
                    atual.proximo = novo;
                    if (novo.proximo == null) fim = novo;
                }
            } else {
                // Inserção normal no fim
                fim.proximo = novo;
                fim = novo;
            }
            System.out.println("Paciente inserido com sucesso!");
        }

        // b) Chamar próximo paciente
        public void chamarPaciente() {
            if (inicio == null) {
                System.out.println("Nenhum paciente aguardando.");
                return;
            }
            System.out.println("Chamando paciente: " + inicio.nome + " | Idade: " + inicio.idade + " | Senha: " + inicio.senha);
            inicio = inicio.proximo;
            if (inicio == null) fim = null;
        }

        // c) Listar pacientes aguardando
        public void listarPacientes() {
            if (inicio == null) {
                System.out.println("Nenhum paciente na fila.");
                return;
            }
            Paciente atual = inicio;
            System.out.println("Pacientes na fila:");
            while (atual != null) {
                System.out.println("Nome: " + atual.nome + " | Idade: " + atual.idade + " | Senha: " + atual.senha);
                atual = atual.proximo;
            }
        }
    }

    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.inserirPaciente("João", 45);
        fila.inserirPaciente("Maria", 70);
        fila.inserirPaciente("Carlos", 50);
        fila.inserirPaciente("Ana", 80);
        fila.inserirPaciente("Bruno", 30);

        System.out.println();
        fila.listarPacientes();

        System.out.println();
        fila.chamarPaciente();

        System.out.println();
        fila.listarPacientes();
    }
}