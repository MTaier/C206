package br.inatel;

import br.inatel.Classes.*;
import br.inatel.Connection.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Filme> filmes = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        FilmeDAO filmeDAO = new FilmeDAO();
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n--- Locadora de Filmes ---");
            System.out.println("1. Registrar Filme");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Registrar Funcionario");
            System.out.println("4. Realizar Locacao");
            System.out.println("5. Devolver Filme");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Registrar filme no banco de dados
                    Filme novoFilme = Filme.registrarFilme(scanner);
                    boolean inseridoFilme = filmeDAO.insertFilme(novoFilme);
                    if (inseridoFilme) {
                        System.out.println("Filme registrado com sucesso.");
                        filmes.add(novoFilme); // Adiciona o filme na lista local
                    } else {
                        System.out.println("Erro ao registrar filme.");
                    }
                    break;
                case 2:
                    // Registrar cliente no banco de dados
                    Cliente novoCliente = Cliente.registrarCliente(scanner);
                    boolean inserido = clienteDAO.insertCliente(novoCliente);
                    if (inserido) {
                        System.out.println("Cliente registrado com sucesso.");
                    } else {
                        System.out.println("Erro ao registrar cliente.");
                    }
                    break;
                case 3:
                    // Registrar funcionário no banco de dados
                    Funcionario novoFuncionario = Funcionario.registrarFuncionario(scanner);
                    boolean inseridoFuncionario = funcionarioDAO.insertFuncionario(novoFuncionario);
                    if (inseridoFuncionario) {
                        System.out.println("Funcionário registrado com sucesso.");
                    } else {
                        System.out.println("Erro ao registrar funcionário.");
                    }
                    break;
                case 4:
                    ArrayList<Cliente> clientesDisponiveis = clienteDAO.selectClientes();
                    System.out.println("Clientes disponíveis:");
                    for (Cliente cliente : clientesDisponiveis) {
                        System.out.println(cliente.getId() + ". " + cliente.getNome());
                    }

                    // Pedir ao usuário para escolher o ID do cliente
                    System.out.print("Escolha o ID do cliente para realizar a locação: ");
                    int idClienteLocacao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Mostrar lista de filmes disponíveis
                    ArrayList<Filme> filmesDisponiveis = filmeDAO.selectFilmes();
                    System.out.println("Filmes disponíveis:");
                    for (Filme filme : filmesDisponiveis) {
                        System.out.println(filme.getId() + ". " + filme.getTitulo());
                    }

                    // Pedir ao usuário para escolher o ID do filme
                    System.out.print("Escolha o ID do filme para realizar a locação: ");
                    int idFilmeLocacao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Registrar a locação na tabela locacao
                    boolean locacaoRegistrada = locacaoDAO.registrarLocacao(idClienteLocacao, idFilmeLocacao);

                    if (locacaoRegistrada) {
                        System.out.println("Locação registrada com sucesso.");
                    } else {
                        System.out.println("Erro ao registrar locação.");
                    }
                    break;
                case 5:
                    // Mostrar lista de clientes disponíveis
                    ArrayList<Cliente> clientesDisponiveisParaDevolucao = clienteDAO.selectClientes();
                    System.out.println("Clientes disponíveis:");
                    for (Cliente cliente : clientesDisponiveisParaDevolucao) {
                        System.out.println(cliente.getId() + ". " + cliente.getNome());
                    }

                    // Pedir ao usuário para escolher o ID do cliente
                    System.out.print("Escolha o ID do cliente para devolver o filme: ");
                    int idClienteDevolucao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Mostrar filmes alugados pelo cliente escolhido
                    ArrayList<Filme> filmesAlugados = locacaoDAO.selectFilmesAlugadosPorCliente(idClienteDevolucao);
                    if (filmesAlugados.isEmpty()) {
                        System.out.println("Este cliente não possui filmes alugados.");
                    } else {
                        System.out.println("Filmes alugados pelo cliente:");
                        for (Filme filme : filmesAlugados) {
                            System.out.println(filme.getId() + ". " + filme.getTitulo());
                        }

                        // Pedir ao usuário para escolher o ID do filme a ser devolvido
                        System.out.print("Escolha o ID do filme a ser devolvido: ");
                        int idFilmeDevolucao = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        // Remover a relação de locação (devolver filme)
                        boolean devolucaoRealizada = locacaoDAO.devolverFilme(idClienteDevolucao, idFilmeDevolucao);

                        if (devolucaoRealizada) {
                            System.out.println("Filme devolvido com sucesso.");
                        } else {
                            System.out.println("Erro ao devolver filme.");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }
        scanner.close();
    }
}
