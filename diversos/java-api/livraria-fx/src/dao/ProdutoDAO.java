package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.ConnectionFactory;
import br.com.casadocodigo.livraria.Autor;
import br.com.casadocodigo.livraria.produtos.LivroFisico;
import br.com.casadocodigo.livraria.produtos.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutoDAO {

  public ObservableList<Produto> lista() {
    final ObservableList<Produto> produtos = FXCollections.observableArrayList();

    try (final Connection conn = new ConnectionFactory().getConnection()) {
      final PreparedStatement ps = conn.prepareStatement(
          "SELECT * FROM produtos");
      final ResultSet resultSet = ps.executeQuery();

      while (resultSet.next()) {
        final LivroFisico livro = new LivroFisico(new Autor());
        livro.setNome(resultSet.getString("nome"));
        livro.setDescricao(resultSet.getString("descricao"));
        livro.setValor(resultSet.getDouble("valor"));
        livro.setIsbn(resultSet.getString("isbn"));
        produtos.add(livro);
      }

      resultSet.close();
      ps.close();
    } catch (final SQLException e) {
      throw new RuntimeException(e);
    }
    return produtos;
  }

  public void adiciona(final Produto produto) {
    try (Connection conn = new ConnectionFactory().getConnection()) {
      final PreparedStatement ps = conn.prepareStatement(
          "INSERT INTO produtos (nome, descricao, valor, isbn) VALUES (?,?,?,?)");

      ps.setString(1, produto.getNome());
      ps.setString(2, produto.getDescricao());
      ps.setDouble(3, produto.getValor());
      ps.setString(4, produto.getIsbn());

      ps.execute();
      ps.close();
    } catch (final SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
