package br.com.k19.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Cliente;
import br.com.k19.modelo.Pedido;

public class AdicionaPedidoCliente {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_mapeamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction()
               .begin();

        Cliente c = new Cliente();
        c.setNome("Rafael Cosentino");

        Pedido p = new Pedido();
        p.setData(Calendar.getInstance());
        p.setCliente(c);

        manager.persist(c);
        manager.persist(p);

        manager.getTransaction()
               .commit();

        manager.close();
        factory.close();
    }
}
