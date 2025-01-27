package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class PopulaBanco {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final Livro livro1 = new Livro();
    livro1.setNome("The Battle for Your Mind");
    livro1.setPreco(20.6);
    manager.persist(livro1);

    final Livro livro2 = new Livro();
    livro2.setNome("Differentiate or Die");
    livro2.setPreco(15.8);
    manager.persist(livro2);

    final Livro livro3 = new Livro();
    livro3.setNome("How to Transform Your Ideas");
    livro3.setPreco(32.7);
    manager.persist(livro3);

    final Livro livro4 = new Livro();
    livro4.setNome("Digital Fortress");
    livro4.setPreco(20.6);
    manager.persist(livro4);

    final Livro livro5 = new Livro();
    livro5.setNome("Marketing in an Era of Competition , Change and Crisis");
    livro5.setPreco(26.8);
    manager.persist(livro5);

    final Autor autor1 = new Autor();
    autor1.setNome("Patrick Cullen");
    autor1.getLivros()
          .add(livro2);
    autor1.getLivros()
          .add(livro4);
    manager.persist(autor1);

    final Autor autor2 = new Autor();
    autor2.setNome("Fraser Seitel");
    autor2.getLivros()
          .add(livro3);
    manager.persist(autor2);

    final Autor autor3 = new Autor();
    autor3.setNome("Al Ries");
    autor3.getLivros()
          .add(livro1);
    manager.persist(autor3);

    final Autor autor4 = new Autor();
    autor4.setNome("Jack Trout");
    autor4.getLivros()
          .add(livro1);
    autor4.getLivros()
          .add(livro2);
    autor4.getLivros()
          .add(livro5);
    manager.persist(autor4);

    final Autor autor5 = new Autor();
    autor5.setNome("Steve Rivkin");
    autor5.getLivros()
          .add(livro2);
    autor5.getLivros()
          .add(livro3);
    autor5.getLivros()
          .add(livro5);
    manager.persist(autor5);

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
