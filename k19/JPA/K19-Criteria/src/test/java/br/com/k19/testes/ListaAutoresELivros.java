package br.com.k19.testes;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class ListaAutoresELivros {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_criteria_pu");
    final EntityManager manager = factory.createEntityManager();

    final CriteriaBuilder cb = manager.getCriteriaBuilder();
    final CriteriaQuery<Autor> c = cb.createQuery(Autor.class);
    final Root<Autor> a = c.from(Autor.class);
    a.fetch("livros", JoinType.LEFT);
    c.select(a)
     .distinct(true);

    final TypedQuery<Autor> query = manager.createQuery(c);
    final List<Autor> autores = query.getResultList();

    System.out.println();

    for (final Autor autor : autores) {
      System.out.println("Autor: " + autor.getNome());
      final Collection<Livro> livros = autor.getLivros();

      for (final Livro livro : livros) {
        System.out.println("Livro: " + livro.getNome());
      }
    }

    manager.close();
    factory.close();
  }
}
