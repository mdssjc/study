package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Conta;

public class AdicionaConta {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction()
               .begin();

        Conta c = new Conta();
        c.setSaldo(2000);

        manager.persist(c);

        manager.getTransaction()
               .commit();

        manager.close();
        factory.close();
    }
}
