package mds.java.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mds.java.entity.Contato;

public class ContatoDAO implements DAO<Contato> {
    private Connection connection;
    private static final String SAVE = "insert into contatos(nome,email,endereco,dataNascimento) values (?,?,?,?)";
    private static final String FINDBYID = "select * from contatos where id=?";
    private static final String FINDALL = "select * from contatos";
    private static final String DELETE = "delete from contatos where id=?";
    private static final String SET = "update contatos set nome=?, email=?,endereco=?, dataNascimento=? where id=?";

    public ContatoDAO(Connection connection) {
	this.connection = connection;
    }

    private Contato makeContato(ResultSet rs) throws DAOException {
	Contato contato = new Contato();
	try {
	    contato.setId(rs.getLong(1));
	    contato.setNome(rs.getString(2));
	    contato.setEmail(rs.getString(3));
	    contato.setEndereco(rs.getString(4));
	    Calendar date = Calendar.getInstance();
	    date.setTime(rs.getDate(5));
	    contato.setDataNascimento(date);
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
	    stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
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
		return makeContato(rs);
	    }
	} catch (SQLException e) {
	    throw new DAOException(e);
	}
	return null;
    }

    @Override
    public List<Contato> findAll() throws DAOException {
	List<Contato> list = new ArrayList<>();

	try (ResultSet rs = connection.prepareStatement(FINDALL).executeQuery()) {
	    while (rs.next()) {
		list.add(makeContato(rs));
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
	    stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
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

    // POJO
    public List<Contato> getList() throws DAOException {
	return findAll();
    }
}
