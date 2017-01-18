package com.github.mdssjc.fj21_agenda.persistence;

import com.github.mdssjc.fj21_agenda.entity.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO implements DAO<Contato> {

  private Connection connection;
  private static final String SAVE = "INSERT INTO contatos(nome, email, endereco, dataNascimento) VALUES (?,?,?,?)";
  private static final String FINDBYID = "SELECT * FROM contatos WHERE id=?";
  private static final String FINDALL = "SELECT * FROM contatos";
  private static final String DELETE = "DELETE FROM contatos WHERE id=?";
  private static final String SET = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";

  public ContatoDAO(Connection connection) {
    this.connection = connection;
  }

  private Contato make(ResultSet rs) throws DAOException {
    Contato contato = new Contato();
    try {
      contato.setId(rs.getLong(1));
      contato.setNome(rs.getString(2));
      contato.setEmail(rs.getString(3));
      contato.setEndereco(rs.getString(4));
      contato.setDataNascimento(rs.getDate(5)
                                  .toLocalDate());
    } catch (SQLException e) {
      throw new DAOException(e);
    }
    return contato;
  }

  @Override
  public void save(Contato contato) throws DAOException {
    try (PreparedStatement stmt = connection.prepareStatement(SAVE)) {
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, Date.valueOf(contato.getDataNascimento()));
      stmt.execute();
    } catch (SQLException e) {
      throw new DAOException(e);
    }
  }

  @Override
  public Contato findById(long id) throws DAOException {
    try (PreparedStatement stmt = connection.prepareStatement(FINDBYID)) {
      stmt.setLong(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        return make(rs);
      }
    } catch (SQLException e) {
      throw new DAOException(e);
    }
    return null;
  }

  @Override
  public List<Contato> findAll() throws DAOException {
    List<Contato> list = new ArrayList<>();

    try (ResultSet rs = connection.prepareStatement(FINDALL)
                                  .executeQuery()) {
      while (rs.next()) {
        list.add(make(rs));
      }
    } catch (SQLException e) {
      throw new DAOException(e);
    }
    return list;
  }

  @Override
  public void set(Contato contato) throws DAOException {
    try (PreparedStatement stmt = connection.prepareStatement(SET)) {
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, Date.valueOf(contato.getDataNascimento()));
      stmt.setLong(5, contato.getId());
      stmt.execute();
    } catch (SQLException e) {
      throw new DAOException(e);
    }
  }

  @Override
  public void delete(Contato contato) throws DAOException {
    try (PreparedStatement stmt = connection.prepareStatement(DELETE)) {
      stmt.setLong(1, contato.getId());
      stmt.execute();
    } catch (SQLException e) {
      throw new DAOException(e);
    }
  }

  public List<Contato> getList() throws DAOException {
    return findAll();
  }
}
