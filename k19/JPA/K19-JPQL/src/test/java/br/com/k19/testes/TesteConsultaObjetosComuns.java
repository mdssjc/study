package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteConsultaObjetosComuns {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    final TypedQuery<String> query = manager.createQuery(
        "SELECT l.nome FROM Livro l", String.class);
    final List<String> nomes = query.getResultList();

    for (final String nome : nomes) {
      System.out.println(nome);
    }

    manager.close();
    factory.close();
  }
}
