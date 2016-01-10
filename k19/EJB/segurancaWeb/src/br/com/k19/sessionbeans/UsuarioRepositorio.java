package br.com.k19.sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.k19.entidades.Usuario;

@Stateless
public class UsuarioRepositorio {

    @PersistenceContext
    private EntityManager manager;

    public void adiciona(Usuario u) {
        manager.persist(u);
    }

    public List<Usuario> buscaTodos() {
        TypedQuery<Usuario> query = manager.createQuery(
                "SELECT x FROM Usuario x", Usuario.class);
        return query.getResultList();
    }
}
