package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.modelo.FuncionarioDepartamento;

public class TesteBuscaFuncionarioDepartamento {

  public static void main(final String[] args) {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        "K21_jpql_pu");
    final EntityManager manager = factory.createEntityManager();

    final Query query = manager.createQuery(
        "SELECT new br.com.k19.modelo.FuncionarioDepartamento(f.nome, f.departamento.nome) FROM Funcionario f");
    final List<FuncionarioDepartamento> lista = query.getResultList();

    for (final FuncionarioDepartamento fd : lista) {
      System.out.println("Funcionario: " + fd.getFuncionario());
      System.out.println("Departamento: " + fd.getDepartamento());
    }

    manager.close();
    factory.close();
  }
}
