package br.inatel.Connection;

import br.inatel.Classes.Cliente;
import br.inatel.Classes.Filme;

import java.sql.SQLException;
import java.util.ArrayList;

public class LocacaoDAO extends ConnectionDAO {

    // Método para inserir uma locação no banco de dados
    public boolean insertLocacao(Cliente cliente, Filme filme) {
        connectToDB();
        String sql = "INSERT INTO locacao (idCliente, idFilme) VALUES (?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            pst.setInt(2, filme.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir locação: " + e.getMessage());
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

    // Método para excluir uma locação do banco de dados
    public boolean deleteLocacao(Cliente cliente, Filme filme) {
        connectToDB();
        String sql = "DELETE FROM locacao WHERE idCliente = ? AND idFilme = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            pst.setInt(2, filme.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir locação: " + e.getMessage());
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

    // Método para buscar todos os filmes alugados por um cliente
    public ArrayList<Filme> selectFilmesAlugadosPorCliente(Cliente cliente) {
        ArrayList<Filme> filmes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT f.id, f.titulo, f.diretor, f.anoLancamento, f.duracao, f.categoria, f.disponivel " +
                "FROM filme f INNER JOIN locacao l ON f.id = l.idFilme WHERE l.idCliente = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String diretor = rs.getString("diretor");
                int anoLancamento = rs.getInt("anoLancamento");
                int duracao = rs.getInt("duracao");
                String categoria = rs.getString("categoria");
                boolean disponivel = rs.getBoolean("disponivel");

                Filme filme = new Filme(id, titulo, diretor, anoLancamento, duracao, categoria);
                filme.setDisponibilidade(disponivel);
                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar filmes alugados por cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
        return filmes;
    }

    public ArrayList<Filme> selectFilmesAlugadosPorCliente(int idCliente) {
        connectToDB();
        ArrayList<Filme> filmesAlugados = new ArrayList<>();
        String sql = "SELECT f.id, f.titulo, f.diretor, f.anoLancamento, f.duracao, f.categoria " +
                "FROM filme f " +
                "INNER JOIN locacao l ON f.id = l.idFilme " +
                "WHERE l.idCliente = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCliente);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String diretor = rs.getString("diretor");
                int anoLancamento = rs.getInt("anoLancamento");
                int duracao = rs.getInt("duracao");
                String categoria = rs.getString("categoria");

                Filme filme = new Filme(id, titulo, diretor, anoLancamento, duracao, categoria);
                filmesAlugados.add(filme);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar filmes alugados: " + e.getMessage());
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
        return filmesAlugados;
    }

    public boolean registrarLocacao(int idCliente, int idFilme) {
        connectToDB();
        String sql = "INSERT INTO locacao (idCliente, idFilme, dataLocacao) VALUES (?, ?, NOW())";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCliente);
            pst.setInt(2, idFilme);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao registrar locação: " + e.getMessage());
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

    public boolean devolverFilme(int idCliente, int idFilme) {
        connectToDB();
        String sql = "DELETE FROM locacao WHERE idCliente = ? AND idFilme = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCliente);
            pst.setInt(2, idFilme);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao devolver filme: " + e.getMessage());
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
}
