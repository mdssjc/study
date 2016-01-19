package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.k19.modelo.Livro;

public class TesteCriteria {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_criteria_pu");
    final EntityManager manager = factory.createEntityManager();

    final CriteriaBuilder cb = manager.getCriteriaBuilder();
    final CriteriaQuery<Livro> c = cb.createQuery(Livro.class);
    final Root<Livro> l = c.from(Livro.class);
    c.select(l);

    final TypedQuery<Livro> query = manager.createQuery(c);
    final List<Livro> livros = query.getResultList();

    for (final Livro livro : livros) {
      System.out.println(livro.getNome());
    }

    manager.close();
    factory.close();
  }
}
