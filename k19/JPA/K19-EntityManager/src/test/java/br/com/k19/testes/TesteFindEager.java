package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteFindEager {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");
        EntityManager manager = factory.createEntityManager();

        System.out.println("--- CHAMANDO O FIND ---");
        Pessoa p = manager.find(Pessoa.class, 1L);
        System.out.println("--- FEZ O SELECT ---");

        manager.close();
        factory.close();
    }
}
