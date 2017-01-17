package com.github.mdssjc.fj21_jdbc.jdbc;

import com.github.mdssjc.fj21_jdbc.entity.Contato;
import com.github.mdssjc.fj21_jdbc.jdbc.connection.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDAO implements DAO {

  private static final String ADD = "INSERT INTO contatos(nome, email, endereco, dataNascimento) VALUES (?,?,?,?)";
  private static final String LISTALL = "SELECT * FROM contatos";
  private static final String GET = "SELECT * FROM contatos WHERE id=?";
  private static final String REMOVE = "DELETE FROM contatos WHERE id=?";
  private static final String UPDATE = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";
  private Connection con;

  public ContatoDAO() {
    con = new ConnectionMySQL().getConnection();
  }

  private Contato make(ResultSet rs) throws SQLException {
    Contato contato = new Contato();
    contato.setId(rs.getLong(1));
    contato.setNome(rs.getString(2));
    contato.setEmail(rs.getString(3));
    contato.setEndereco(rs.getString(4));
    Calendar date = Calendar.getInstance();
    date.setTime(rs.getDate(5));
    contato.setDataNascimento(date);
    return contato;
  }

  @Override
  public void add(Contato contato) throws RuntimeException {
    try (PreparedStatement stmt = con.prepareStatement(ADD)) {
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, new java.sql.Date(
          contato.getDataNascimento()
                 .getTimeInMillis()));
      stmt.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Contato get(long id) {
    try (PreparedStatement stmt = con.prepareStatement(GET)) {
      stmt.setLong(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        return make(rs);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  @Override
  public List<Contato> listAll() throws RuntimeException {
    List<Contato> list = new ArrayList<>();

    try (ResultSet rs = con.prepareStatement(LISTALL)
                           .executeQuery()) {
      while (rs.next()) {
        list.add(make(rs));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  @Override
  public void update(Contato contato) throws RuntimeException {
    try (PreparedStatement stmt = con.prepareStatement(UPDATE)) {
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, new Date(
          contato.getDataNascimento()
                 .getTimeInMillis()));
      stmt.setLong(5, contato.getId());
      stmt.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void remove(Contato contato) throws RuntimeException {
    try (PreparedStatement stmt = con.prepareStatement(REMOVE)) {
      stmt.setLong(1, contato.getId());
      stmt.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
