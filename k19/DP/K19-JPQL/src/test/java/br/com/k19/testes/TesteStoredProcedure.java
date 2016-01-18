package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import br.com.k19.modelo.Produto;

public class TesteStoredProcedure {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    final StoredProcedureQuery query = manager.createNamedStoredProcedureQuery(
        "BuscaProdutos");
    query.setParameter("PRECO_MINIMO", 1000.0);
    final List<Produto> produtos = query.getResultList();

    for (final Produto produto : produtos) {
      System.out.println("ID: " + produto.getId());
      System.out.println("NOME: " + produto.getNome());
      System.out.println("PREÇO: " + produto.getPreco());
      System.out.println("----------------------------------");
    }

    manager.close();
    factory.close();
  }
}
