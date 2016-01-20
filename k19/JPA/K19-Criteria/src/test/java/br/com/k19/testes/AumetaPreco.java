package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import br.com.k19.modelo.Produto;

public class AumetaPreco {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_criteria_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final CriteriaBuilder cb = manager.getCriteriaBuilder();
    final CriteriaUpdate<Produto> update = cb.createCriteriaUpdate(
        Produto.class);
    final Root<Produto> produto = update.from(Produto.class);
    update.set(produto.<Double> get("preco"),
        cb.prod(produto.<Double> get("preco"), 1.1));

    final Query query = manager.createQuery(update);
    query.executeUpdate();

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
