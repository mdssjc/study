package com.github.mdssjc.fj21_agenda.persistence;

import com.github.mdssjc.fj21_agenda.entity.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO implements DAO<Contato> {

  private static final String SAVE = "INSERT INTO contatos(nome, email, endereco, dataNascimento) VALUES (?,?,?,?)";
  private static final String FINDBYID = "SELECT * FROM contatos WHERE id=?";
  private static final String FINDALL = "SELECT * FROM contatos";
  private static final String DELETE = "DELETE FROM contatos WHERE id=?";
  private static final String SET = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";
  private final Connection connection;

  public ContatoDAO(final Connection connection) {
    this.connection = connection;
  }

  private Contato make(final ResultSet rs) throws DAOException {
    final Contato contato = new Contato();
    try {
      contato.setId(rs.getLong(1));
      contato.setNome(rs.getString(2));
      contato.setEmail(rs.getString(3));
      contato.setEndereco(rs.getString(4));
      contato.setDataNascimento(rs.getDate(5)
                                  .toLocalDate());
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
    return contato;
  }

  @Override
  public void save(final Contato contato) throws DAOException {
    try (PreparedStatement stmt = this.connection.prepareStatement(SAVE)) {
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, Date.valueOf(contato.getDataNascimento()));
      stmt.execute();
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  @Override
  public Contato findById(final long id) throws DAOException {
    try (PreparedStatement stmt = this.connection.prepareStatement(FINDBYID)) {
      stmt.setLong(1, id);
      final ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        return make(rs);
      }
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
    return null;
  }

  @Override
  public List<Contato> findAll() throws DAOException {
    final List<Contato> list = new ArrayList<>();

    try (ResultSet rs = this.connection.prepareStatement(FINDALL)
                                       .executeQuery()) {
      while (rs.next()) {
        list.add(make(rs));
      }
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
    return list;
  }

  @Override
  public void set(final Contato contato) throws DAOException {
    try (PreparedStatement stmt = this.connection.prepareStatement(SET)) {
      stmt.setString(1, contato.getNome());
      stmt.setString(2, contato.getEmail());
      stmt.setString(3, contato.getEndereco());
      stmt.setDate(4, Date.valueOf(contato.getDataNascimento()));
      stmt.setLong(5, contato.getId());
      stmt.execute();
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  @Override
  public void delete(final Contato contato) throws DAOException {
    try (PreparedStatement stmt = this.connection.prepareStatement(DELETE)) {
      stmt.setLong(1, contato.getId());
      stmt.execute();
    } catch (final SQLException e) {
      throw new DAOException(e);
    }
  }

  public List<Contato> getList() throws DAOException {
    return findAll();
  }
}
