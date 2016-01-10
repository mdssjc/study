package br.com.k19.sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.k19.entidades.Grupo;

@Stateless
public class GrupoRepositorio {

    @PersistenceContext
    private EntityManager manager;

    public void adiciona(Grupo g) {
        manager.persist(g);
    }

    public List<Grupo> buscaTodos() {
        TypedQuery<Grupo> query = manager.createQuery("SELECT x FROM Grupo x",
                Grupo.class);
        return query.getResultList();
    }
}
