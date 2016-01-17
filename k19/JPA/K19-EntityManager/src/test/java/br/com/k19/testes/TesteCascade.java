package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;
import br.com.k19.modelo.Governador;

public class TesteCascade {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");
        EntityManager manager = factory.createEntityManager();

        Governador governador = new Governador();
        governador.setNome("Rafael Cosentino");

        Estado estado = new Estado();
        estado.setNome("São Paulo");

        governador.setEstado(estado);
        estado.setGovernador(governador);

        manager.getTransaction()
               .begin();
        manager.persist(estado);
        manager.getTransaction()
               .commit();

        manager.close();
        factory.close();
    }
}
