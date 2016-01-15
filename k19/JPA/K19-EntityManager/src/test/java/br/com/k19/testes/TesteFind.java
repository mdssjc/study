package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteFind {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");
        EntityManager manager = factory.createEntityManager();

        Pessoa p = manager.find(Pessoa.class, 1L);
        System.out.println("Id: " + p.getId());
        System.out.println("Nome: " + p.getNome());

        manager.close();
        factory.close();
    }
}
