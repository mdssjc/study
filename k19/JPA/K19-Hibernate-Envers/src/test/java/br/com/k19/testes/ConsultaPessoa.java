package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;

import br.com.k19.modelo.Pessoa;

public class ConsultaPessoa {

  private static final int REVISION = 1;

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_hibernate_envers_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final AuditReader reader = AuditReaderFactory.get(manager);
    final AuditQuery query = reader.createQuery()
                                   .forEntitiesAtRevision(Pessoa.class,
                                       REVISION);
    query.add(AuditEntity.id()
                         .eq(1L));

    final Pessoa p = (Pessoa) query.getSingleResult();

    System.out.println(p.getNome());

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
