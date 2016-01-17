package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteBuscaFuncionarioDepartamento {

    public static void main(final String[] args) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_jpql_pu");
        final EntityManager manager = factory.createEntityManager();

        final Query query = manager.createQuery(
                "SELECT f.nome, f.departamento.nome FROM Funcionario f");
        final List<Object[]> lista = query.getResultList();

        for (final Object[] tuplas : lista) {
            System.out.println("Funcionario: " + tuplas[0]);
            System.out.println("Departamento: " + tuplas[1]);
        }

        manager.close();
        factory.close();
    }
}
