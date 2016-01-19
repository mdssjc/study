package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class TesteCriteriaAutores {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_criteria_pu");
    final EntityManager manager = factory.createEntityManager();

    final CriteriaBuilder builder = manager.getCriteriaBuilder();
    final CriteriaQuery<Autor> criteriaQuery = builder.createQuery(Autor.class);
    final Root<Autor> root = criteriaQuery.from(Autor.class);
    criteriaQuery.select(root);

    final TypedQuery<Autor> query = manager.createQuery(criteriaQuery);
    final List<Autor> autores = query.getResultList();

    for (final Autor autor : autores) {
      System.out.println("Autor:");
      System.out.println(autor.getNome());
      System.out.println("Livros: ");
      for (final Livro livro : autor.getLivros()) {
        System.out.println(livro.getNome());
      }
    }

    manager.close();
    factory.close();
  }
}
