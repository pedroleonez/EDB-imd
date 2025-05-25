package aula01;

import java.util.List;

public class Aluno {
    private int matricula;
    private String nome;
    private List<Double> notas;

    public Aluno(int matricula, String nome, List<Double> notas) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public void adicionarNota(double nota) {
        this.notas.add(nota);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    public boolean verificarAprovacao() {
        return calcularMedia() >= 7.0;
    }

    public static void main(String[] args) {
        
    }

}
