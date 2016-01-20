package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import br.com.k19.modelo.Produto;

public class RemoveProdutos {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_criteria_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final CriteriaBuilder cb = manager.getCriteriaBuilder();
    final CriteriaDelete<Produto> delete = cb.createCriteriaDelete(
        Produto.class);
    final Root<Produto> produto = delete.from(Produto.class);
    delete.where(cb.lessThan(produto.get("preco"), 50));

    final Query query = manager.createQuery(delete);
    query.executeUpdate();

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
