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
import br.com.k19.entities.Project;

@Stateless
@RolesAllowed({ "admin", "users" })
public class ProjectRepository {

    @PersistenceContext
    private EntityManager manager;

    public void add(Project project) {
        manager.persist(project);
    }

    public void edit(Project project) {
        manager.merge(project);
    }

    @RolesAllowed({ "admin" })
    public void removeById(Long id) {
        Project project = manager.find(Project.class, id);

        TypedQuery<Bug> query = manager.createQuery(
                "SELECT x FROM Bug x WHERE x.project = :project", Bug.class);
        query.setParameter("project", project);
        List<Bug> bugs = query.getResultList();
        for (Bug bug : bugs) {
            manager.remove(bug);
        }

        manager.remove(project);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Project> findAll() {
        TypedQuery<Project> query = manager.createQuery(
                "SELECT x FROM Project x", Project.class);
        return query.getResultList();

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Project findById(Long id) {
        return manager.find(Project.class, id);
    }
}
