package br.inatel.Classes;

import java.util.Scanner;

public class Filme {
    private int id;
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private int duracao;
    private String categoria;
    private boolean disponivel;

    public Filme(int id, String titulo, String diretor, int anoLancamento, int duracao, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
        this.categoria = categoria;
        this.disponivel = true;
    }

    public boolean getDisponibilidade() {
        return disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponibilidade(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public static Filme registrarFilme(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Diretor: ");
        String diretor = scanner.nextLine();
        System.out.print("Ano de Lancamento: ");
        int anoLancamento = scanner.nextInt();
        System.out.print("Duracao: ");
        int duracao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        return new Filme(id, titulo, diretor, anoLancamento, duracao, categoria);
    }
}
