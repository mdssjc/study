package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Produto;

public class AdicionaProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");
        EntityManager manager = factory.createEntityManager();

        Produto p = new Produto();
        p.setNome("K19 - Caneta");
        p.setPreco(4.56);

        manager.getTransaction()
               .begin();
        manager.persist(p);
        manager.getTransaction()
               .commit();

        manager.close();
        factory.close();
    }
}
