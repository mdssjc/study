package jdbc;

import java.util.List;

import entity.Contato;

public interface DAO {

    void add(Contato contato) throws RuntimeException;

    Contato get(long id);

    List<Contato> listAll() throws RuntimeException;

    void update(Contato contato) throws RuntimeException;

    void remove(Contato contato) throws RuntimeException;
}
