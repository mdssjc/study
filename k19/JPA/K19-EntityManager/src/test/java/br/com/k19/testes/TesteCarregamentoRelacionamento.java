package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;

public class TesteCarregamentoRelacionamento {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");
        EntityManager manager = factory.createEntityManager();

        Estado estado = manager.find(Estado.class, 1L);

        manager.close();
        factory.close();

        System.out.println(estado.getGovernador()
                                 .getNome());
    }
}
