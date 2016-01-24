package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.k19.modelo.Livro;

public class TesteBuscaPaginada {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    final TypedQuery<Livro> query = manager.createQuery("SELECT l FROM Livro l",
        Livro.class);
    query.setFirstResult(2);
    query.setMaxResults(3);

    final List<Livro> livros = query.getResultList();
    for (final Livro livro : livros) {
      System.out.println("Livro: " + livro.getNome());
    }

    manager.close();
    factory.close();
  }
}
