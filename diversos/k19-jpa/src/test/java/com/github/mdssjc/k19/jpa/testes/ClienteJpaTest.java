package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Cliente;
import com.github.mdssjc.k19.jpa.modelo.Pedido;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class ClienteJpaTest extends JpaEntityManager {

  @Test
  public void adicionaPedidoCliente() {
    final Cliente cliente = new Cliente();
    cliente.setNome("Rafael Cosentino");

    final Pedido pedido = new Pedido();
    pedido.setData(Calendar.getInstance());
    pedido.setCliente(cliente);

    JpaEntityManager.manager.persist(cliente);
    JpaEntityManager.manager.persist(pedido);

    final Pedido resultado = JpaEntityManager.manager.find(Pedido.class,
        pedido.getId());

    assertEquals(cliente, resultado.getCliente());
  }
}
