package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Cidade;

public class InsereCidades {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction()
               .begin();

        Cidade saoPaulo = new Cidade();
        saoPaulo.setNomeDaCidade("São Paulo");
        saoPaulo.setNomeDoEstado("São Paulo");

        Cidade rioDeJaneiro = new Cidade();
        rioDeJaneiro.setNomeDaCidade("Rio de Janeiro");
        rioDeJaneiro.setNomeDoEstado("Rio de Janeiro");

        Cidade natal = new Cidade();
        natal.setNomeDaCidade("Natal");
        natal.setNomeDoEstado("Rio Grande do Norte");

        manager.persist(saoPaulo);
        manager.persist(rioDeJaneiro);
        manager.persist(natal);

        manager.getTransaction()
               .commit();

        manager.close();
        factory.close();
    }
}
