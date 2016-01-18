package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.modelo.Produto;

public class TesteConsultaNativas {

  private static final String SQL = "SELECT * FROM Produto";

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    final Query nativeQuery = manager.createNativeQuery(
        TesteConsultaNativas.SQL, Produto.class);
    final List<Produto> produtos = nativeQuery.getResultList();

    for (final Produto p : produtos) {
      System.out.println(p.getNome());
    }

    manager.close();
    factory.close();
  }
}
