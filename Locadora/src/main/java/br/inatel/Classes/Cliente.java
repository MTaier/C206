package br.inatel.Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Pessoa {
    private ArrayList<Locacao> locacoes = new ArrayList<>();;

    public Cliente(int id, String nome, String cpf, String telefone, String endereco) {
        super(id, nome, cpf, telefone, endereco);
        this.locacoes = new ArrayList<>();
    }

    public void realizarLocacao(Filme filme) {
        Locacao locacao = new Locacao(this, filme);
        this.locacoes.add(locacao);
        filme.setDisponibilidade(false);
        System.out.println("Locação realizada com sucesso para o cliente: " + this.nome);
    }

    public void devolverFilme(Filme filme) {
        for (Locacao locacao : locacoes) {
            if (locacao.getFilme().getId() == filme.getId() &&!locacao.isDevolvido()) {
                locacao.setDevolvido(true);
                filme.setDisponibilidade(true);
                System.out.println("Filme devolvido com sucesso por: " + this.nome);
                return;
            }
        }
        System.out.println("O filme não está locado para este cliente ou já foi devolvido.");
    }

    public static Cliente registrarCliente(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        return new Cliente(id, nome, cpf, telefone, endereco);
    }
}
