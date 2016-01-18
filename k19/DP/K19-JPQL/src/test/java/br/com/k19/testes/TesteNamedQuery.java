package br.com.k19.testes;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class TesteNamedQuery {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    final Query query = manager.createNamedQuery("Autor.findAll");
    final List<Autor> autores = query.getResultList();

    for (final Autor autor : autores) {
      System.out.println("Autor: " + autor.getNome());
      final Collection<Livro> livros = autor.getLivros();

      for (final Livro livro : livros) {
        System.out.println("Livro: " + livro.getNome());
        System.out.println("Preço: " + livro.getPreco());
        System.out.println();
      }
      System.out.println();
    }

    manager.close();
    factory.close();
  }
}
