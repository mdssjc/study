package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class AdicionaLivroAutor {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_mapeamento_xml_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final Autor a = new Autor();
    a.setNome("Rafael Cosentino");

    final Livro l = new Livro();
    l.setNome("JPA2");
    l.getAutores()
     .add(a);

    manager.persist(a);
    manager.persist(l);

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
