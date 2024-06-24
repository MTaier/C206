package br.inatel.Connection;

import br.inatel.Classes.Categoria;
import br.inatel.Classes.Filme;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO extends ConnectionDAO {

    // Método para inserir um filme no banco de dados
    public boolean insertFilme(Filme filme) {
        connectToDB();
        String sql = "INSERT INTO filme (id, titulo, diretor, anoLancamento, duracao, categoria, disponivel) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, filme.getId());
            pst.setString(2, filme.getTitulo());
            pst.setString(3, filme.getDiretor());
            pst.setInt(4, filme.getAnoLancamento());
            pst.setInt(5, filme.getDuracao());
            pst.setString(6, filme.getCategoria());
            pst.setBoolean(7, filme.isDisponivel());
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir filme: " + e.getMessage());
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

    // Método para atualizar um filme no banco de dados
    public boolean updateFilme(Filme filme) {
        connectToDB();
        String sql = "UPDATE filme SET titulo = ?, diretor = ?, anoLancamento = ?, duracao = ?, categoria = ?, disponivel = ? " +
                "WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, filme.getTitulo());
            pst.setString(2, filme.getDiretor());
            pst.setInt(3, filme.getAnoLancamento());
            pst.setInt(4, filme.getDuracao());
            pst.setString(5, filme.getCategoria());
            pst.setBoolean(6, filme.isDisponivel());
            pst.setInt(7, filme.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar filme: " + e.getMessage());
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

    // Método para excluir um filme do banco de dados
    public boolean deleteFilme(int id) {
        connectToDB();
        String sql = "DELETE FROM filme WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir filme: " + e.getMessage());
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

    // Método para buscar todos os filmes no banco de dados
    public ArrayList<Filme> selectFilmes() {
        ArrayList<Filme> filmes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM filme";
        try {
            pst = con.prepareStatement(sql);
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
            System.out.println("Erro ao buscar filmes: " + e.getMessage());
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
}