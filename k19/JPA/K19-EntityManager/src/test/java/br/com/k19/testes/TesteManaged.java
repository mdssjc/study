package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteManaged {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction()
               .begin();

        Pessoa p = manager.find(Pessoa.class, 1L);

        p.setNome("Marcelo Martins");

        manager.getTransaction()
               .commit();

        manager.close();
        factory.close();
    }
}
