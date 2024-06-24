package br.inatel.Connection;

import br.inatel.Classes.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends ConnectionDAO{
    // Método para inserir um cliente no banco de dados
    public boolean insertCliente(Cliente cliente) {
        connectToDB();
        String sql = "INSERT INTO cliente (id, nome, cpf, telefone, endereco) VALUES (?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getTelefone());
            pst.setString(5, cliente.getEndereco());
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
    }

    // Método para atualizar um cliente no banco de dados
    public boolean updateCliente(Cliente cliente) {
        connectToDB();
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, endereco = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEndereco());
            pst.setInt(5, cliente.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
    }

    // Método para excluir um cliente do banco de dados
    public boolean deleteCliente(int id) {
        connectToDB();
        String sql = "DELETE FROM cliente WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
            return false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
    }

    // Método para buscar um cliente pelo ID no banco de dados
    public ArrayList<Cliente> selectClientes() {
        connectToDB();
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");

                Cliente cliente = new Cliente(id, nome, cpf, telefone, endereco);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar clientes: " + e.getMessage());
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
        return clientes;
    }

}
