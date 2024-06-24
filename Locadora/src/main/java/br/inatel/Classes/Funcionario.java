package br.inatel.Classes;

import java.util.Scanner;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(int id, String nome, String cpf, String telefone, String endereco, String cargo) {
        super(id, nome, cpf, telefone, endereco);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void processarPagamento(Pagamento pagamento) {
        pagamento.realizarPagamento(pagamento.getValor());
    }

    public static Funcionario registrarFuncionario(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        return new Funcionario(id, nome, cpf, telefone, endereco, cargo);
    }
}
