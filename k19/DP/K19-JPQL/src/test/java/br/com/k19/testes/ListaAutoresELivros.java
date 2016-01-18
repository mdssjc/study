package br.com.k19.testes;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class ListaAutoresELivros {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    // final TypedQuery<Autor> query = manager.createQuery(
    // "SELECT a FROM Autor a", Autor.class);
    final TypedQuery<Autor> query = manager.createQuery(
        "SELECT DISTINCT(a) FROM Autor a LEFT JOIN FETCH a.livros",
        Autor.class);
    final List<Autor> autores = query.getResultList();

    System.out.println();

    for (final Autor autor : autores) {
      System.out.println("Autor: " + autor.getNome());
      final Collection<Livro> livros = autor.getLivros();

      for (final Livro livro : livros) {
        System.out.println("Livro: " + livro.getNome());
      }
      System.out.println();
    }

    manager.close();
    factory.close();
  }
}
