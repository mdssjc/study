package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteConsultaLivroPrecoMedio {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    final TypedQuery<Double> query = manager.createQuery(
        "SELECT AVG(l.preco) FROM Livro l", Double.class);
    final Double precoMedio = query.getSingleResult();

    System.out.println("Preço médio: " + precoMedio);

    manager.close();
    factory.close();
  }
}
