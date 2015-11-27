package mds.java.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import mds.java.entity.Task;
import mds.java.persistence.connection.ConnectionMySQL;

public class TaskDAO implements DAO<Task> {
    private static final String INSERT = "INSERT INTO tarefas(descricao, finalizado, dataFinalizacao) VALUES(?,?,?)";

    public TaskDAO() {
    }

    /*
     * create table tarefas ( id BIGINT NOT NULL AUTO_INCREMENT, descricao
     * VARCHAR(255), finalizado BOOLEAN, dataFinalizacao DATE, primary key (id)
     */

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
    public Task findById(long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Task> findAll() throws DAOException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void set(Task type) throws DAOException {
	// TODO Auto-generated method stub

    }

    @Override
    public void delete(Task type) throws DAOException {
	// TODO Auto-generated method stub

    }
}
