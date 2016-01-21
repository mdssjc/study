package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

public class Indexacao {

  public static void main(String[] args) throws InterruptedException {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_hibernate_search_pu");
    EntityManager manager = factory.createEntityManager();

    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(
        manager);
    fullTextEntityManager.createIndexer()
                         .startAndWait();

    manager.close();
    factory.close();
  }
}
