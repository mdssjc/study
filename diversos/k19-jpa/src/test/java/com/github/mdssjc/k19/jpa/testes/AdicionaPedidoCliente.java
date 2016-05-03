package com.github.mdssjc.k19.jpa.testes;

import java.util.Calendar;

import com.github.mdssjc.k19.jpa.modelo.Cliente;
import com.github.mdssjc.k19.jpa.modelo.Pedido;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class AdicionaPedidoCliente extends JpaEntityManager {

  public static void main(final String[] args) {
    final Cliente c = new Cliente();
    c.setNome("Rafael Cosentino");

    final Pedido p = new Pedido();
    p.setData(Calendar.getInstance());
    p.setCliente(c);

    JpaEntityManager.manager.persist(c);
    JpaEntityManager.manager.persist(p);
  }
}
