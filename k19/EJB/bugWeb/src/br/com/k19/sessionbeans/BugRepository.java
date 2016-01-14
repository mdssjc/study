package br.com.k19.sessionbeans;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.k19.entities.Bug;

@Stateless
@RolesAllowed({ "admin", "users" })
public class BugRepository {

    @PersistenceContext
    private EntityManager manager;

    public void add(Bug bug) {
        manager.persist(bug);
    }

    public void edit(Bug bug) {
        manager.merge(bug);
    }

    @RolesAllowed({ "admin" })
    public void removeById(Long id) {
        Bug bug = manager.find(Bug.class, id);
        manager.remove(bug);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Bug> findAll() {
        TypedQuery<Bug> query = manager.createQuery("SELECT x FROM Bug x",
                Bug.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Bug findById(Long id) {
        return manager.find(Bug.class, id);
    }
}
