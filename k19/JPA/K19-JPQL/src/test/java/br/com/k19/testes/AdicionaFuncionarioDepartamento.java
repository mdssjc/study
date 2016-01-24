package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Departamento;
import br.com.k19.modelo.Funcionario;

public class AdicionaFuncionarioDepartamento {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    manager.getTransaction()
           .begin();

    final Departamento d = new Departamento();
    d.setNome("Treinamentos");

    final Funcionario f = new Funcionario();
    f.setNome("Rafael Cosentino");
    f.setDepartamento(d);

    manager.persist(f);
    manager.persist(d);

    manager.getTransaction()
           .commit();

    manager.close();
    factory.close();
  }
}
