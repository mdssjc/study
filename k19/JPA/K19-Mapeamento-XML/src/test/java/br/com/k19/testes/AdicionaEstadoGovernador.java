package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;
import br.com.k19.modelo.Governador;

public class AdicionaEstadoGovernador {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_mapeamento_xml_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final Governador g = new Governador();
    g.setNome("Rafael Cosentino");

    final Estado e = new Estado();
    e.setNome("São Paulo");
    e.setGovernador(g);

    manager.persist(g);
    manager.persist(e);

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
