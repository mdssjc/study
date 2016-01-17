package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import br.com.k19.modelo.Produto;

public class TesteDeadLock {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");

        EntityManager manager1 = factory.createEntityManager();
        EntityManager manager2 = factory.createEntityManager();

        manager1.getTransaction()
                .begin();
        manager2.getTransaction()
                .begin();

        manager1.find(Produto.class, 1L, LockModeType.PESSIMISTIC_WRITE);
        System.out.println("Produto 1 travado");
        manager2.find(Produto.class, 1L, LockModeType.PESSIMISTIC_WRITE);
        System.out.println("Essa mensagem não será impressa!!!");

        manager1.close();
        manager2.close();
        factory.close();
    }
}
