package mds.java.persistence;

import java.util.List;

public interface DAO<T> {

    void save(T type) throws DAOException;

    T findById(long id) throws DAOException;

    List<T> findAll() throws DAOException;

    void set(T type) throws DAOException;

    void delete(T type) throws DAOException;
}
