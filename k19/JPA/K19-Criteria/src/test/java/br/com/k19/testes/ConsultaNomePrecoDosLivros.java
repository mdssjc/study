package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.k19.modelo.Livro;

public class ConsultaNomePrecoDosLivros {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_criteria_pu");
    final EntityManager manager = factory.createEntityManager();

    final CriteriaBuilder cb = manager.getCriteriaBuilder();
    // final CriteriaQuery<Object[]> c = cb.createQuery(Object[].class);
    final CriteriaQuery<Tuple> c = cb.createQuery(Tuple.class);
    final Root<Livro> l = c.from(Livro.class);
    // c.multiselect(l.<String> get("nome"), l.<Double> get("preco"));
    c.multiselect(l.<String> get("nome")
                   .alias("livro.nome"),
        l.<Double> get("preco")
         .alias("livro.preco"));

    // final TypedQuery<Object[]> query = manager.createQuery(c);
    // final List<Object[]> resultado = query.getResultList();
    final TypedQuery<Tuple> query = manager.createQuery(c);
    final List<Tuple> resultado = query.getResultList();

    // for (final Object[] registro : resultado) {
    // System.out.println("Livro: " + registro[0]);
    // System.out.println("Preço: " + registro[1]);
    // }

    for (final Tuple registro : resultado) {
      System.out.println("Livro: " + registro.get("livro.nome"));
      System.out.println("Preço: " + registro.get("livro.preco"));
    }

    manager.close();
    factory.close();
  }
}
