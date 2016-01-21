package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.lucene.search.Query;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import br.com.k19.modelo.Pessoa;

public class Busca {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_hibernate_search_pu");
    final EntityManager manager = factory.createEntityManager();

    final FullTextEntityManager fullTextManager = Search.getFullTextEntityManager(
        manager);
    final SearchFactory searchFactory = fullTextManager.getSearchFactory();
    final QueryBuilder pessoaQueryBuilder = searchFactory.buildQueryBuilder()
                                                         .forEntity(
                                                             Pessoa.class)
                                                         .get();

    final Query luceneQuery = pessoaQueryBuilder.keyword()
                                                .onField("nome")
                                                .matching("Hirata")
                                                .createQuery();
    final javax.persistence.Query jpaQuery = fullTextManager.createFullTextQuery(
        luceneQuery, Pessoa.class);

    final List<Pessoa> pessoas = jpaQuery.getResultList();

    for (final Pessoa pessoa : pessoas) {
      System.out.println(pessoa.getNome());
    }

    manager.close();
    factory.close();
  }
}
