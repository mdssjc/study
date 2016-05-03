package com.github.mdssjc.k19.jpa.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;

import com.github.com.mdssjc.k19.jpa.testes.util.JpaUtil;
import com.github.mdssjc.k19.jpa.modelo.Cliente;
import com.github.mdssjc.k19.jpa.modelo.Pedido;

public class AdicionaPedidoCliente {

  public static void main(final String[] args) {
    final EntityManager manager = JpaUtil.getEntityManager();

    manager.getTransaction()
           .begin();

    final Cliente c = new Cliente();
    c.setNome("Rafael Cosentino");

    final Pedido p = new Pedido();
    p.setData(Calendar.getInstance());
    p.setCliente(c);

    manager.persist(c);
    manager.persist(p);

    manager.getTransaction()
           .commit();

    manager.close();
  }
}
