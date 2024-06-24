package br.inatel.Connection;

import br.inatel.Classes.Funcionario;

import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO extends ConnectionDAO {

    // Método para inserir um funcionário no banco de dados
    public boolean insertFuncionario(Funcionario funcionario) {
        connectToDB();
        String sql = "INSERT INTO funcionario (id, nome, cpf, telefone, endereco, cargo) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, funcionario.getId());
            pst.setString(2, funcionario.getNome());
            pst.setString(3, funcionario.getCpf());
            pst.setString(4, funcionario.getTelefone());
            pst.setString(5, funcionario.getEndereco());
            pst.setString(6, funcionario.getCargo());
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
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

    // Método para atualizar um funcionário no banco de dados
    public boolean updateFuncionario(Funcionario funcionario) {
        connectToDB();
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, telefone = ?, cargo = ?, endereco = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getCpf());
            pst.setString(3, funcionario.getTelefone());
            pst.setString(4, funcionario.getEndereco());
            pst.setString(5, funcionario.getCargo());
            pst.setInt(6, funcionario.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
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

    // Método para excluir um funcionário do banco de dados
    public boolean deleteFuncionario(int id) {
        connectToDB();
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionário: " + e.getMessage());
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

    // Método para buscar todos os funcionários no banco de dados
    public ArrayList<Funcionario> selectFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM funcionario";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("endereco"),
                        rs.getString("cargo")
                );
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionários: " + e.getMessage());
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
        return funcionarios;
    }
}
