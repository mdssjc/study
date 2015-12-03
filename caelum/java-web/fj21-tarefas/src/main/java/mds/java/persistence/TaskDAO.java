package mds.java.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import mds.java.entity.Task;
import mds.java.persistence.connection.ConnectionMySQL;

public class TaskDAO implements DAO<Task> {
    private static final String DELETE = "DELETE FROM tarefas WHERE id = ?";
    private static final String INSERT = "INSERT INTO tarefas(descricao, finalizado, dataFinalizacao) VALUES(?,?,?)";
    private static final String FINDALL = "SELECT * FROM tarefas";
    private static final String GET = "SELECT * FROM tarefas WHERE id=?";
    private static final String UPDATE = "UPDATE tarefas SET descricao=?, finalizado=?, dataFinalizacao=? WHERE id=?";
    private static final String CLOSETASK = "UPDATE tarefas SET finalizado=?, dataFinalizacao=? WHERE id=?";

    public TaskDAO() {
    }

    @Override
    public void save(Task task) throws DAOException {
	Connection con = new ConnectionMySQL().getConnection();
	try (PreparedStatement stmt = con.prepareStatement(INSERT)) {
	    Optional<Calendar> calendar = Optional.ofNullable(task.getDataFinalizacao());
	    Calendar other = Calendar.getInstance();
	    stmt.setString(1, task.getDescricao());
	    stmt.setBoolean(2, task.getFinalizado());
	    stmt.setDate(3, new java.sql.Date(calendar.orElse(other).getTimeInMillis()));
	    stmt.execute();
	} catch (SQLException e) {
	    throw new DAOException(e);
	}
	System.out.println("tarefa adicionada");
    }

    @Override
    public Task findById(long id) throws DAOException {
	Task task = new Task();
	Connection con = new ConnectionMySQL().getConnection();
	try (PreparedStatement stmt = con.prepareStatement(GET)) {
	    stmt.setLong(1, id);
	    ResultSet rs = stmt.executeQuery();
	    if (rs.next()) {
		task.setId(id);
		task.setDescricao(rs.getString(2));
		task.setFinalizado(rs.getBoolean(3));
		if (rs.getDate(4) != null) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(rs.getDate(4));
		    task.setDataFinalizacao(calendar);
		}
	    }
	} catch (SQLException e) {
	    throw new DAOException(e);
	}

	return task;
    }

    @Override
    public List<Task> findAll() throws DAOException {
	List<Task> list = new ArrayList<Task>();
	try {
	    Connection con = new ConnectionMySQL().getConnection();
	    ResultSet rs = con.prepareStatement(FINDALL).executeQuery();
	    while (rs.next()) {
		Task task = new Task();
		task.setId(rs.getLong(1));
		task.setDescricao(rs.getString(2));
		task.setFinalizado(rs.getBoolean(3));
		if (rs.getDate(4) != null) {
		    Calendar date = Calendar.getInstance();
		    date.setTime(rs.getDate(4));
		    task.setDataFinalizacao(date);
		}

		list.add(task);
	    }
	} catch (SQLException e) {
	    throw new DAOException(e);
	}
	return list;
    }

    @Override
    public void set(Task type) throws DAOException {
	Connection con = new ConnectionMySQL().getConnection();
	try (PreparedStatement stmt = con.prepareStatement(UPDATE)) {
	    stmt.setString(1, type.getDescricao());
	    stmt.setBoolean(2, type.getFinalizado());
	    stmt.setDate(3, new Date(type.getDataFinalizacao().getTimeInMillis()));
	    stmt.setLong(4, type.getId());
	    stmt.execute();
	} catch (Exception e) {
	    throw new DAOException(e);
	}
    }

    @Override
    public void delete(Task type) throws DAOException {
	try {
	    Connection con = new ConnectionMySQL().getConnection();
	    PreparedStatement stmt = con.prepareStatement(DELETE);
	    stmt.setLong(1, type.getId());
	    stmt.execute();
	} catch (SQLException e) {
	    throw new DAOException(e);
	}
    }

    public void closeTask(Long id) throws DAOException {
	Connection con = new ConnectionMySQL().getConnection();
	try (PreparedStatement stmt = con.prepareStatement(CLOSETASK)) {
	    stmt.setBoolean(1, true);
	    stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
	    stmt.setLong(3, id);
	    stmt.execute();
	} catch (Exception e) {
	    throw new DAOException(e);
	}
    }
}
