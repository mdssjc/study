package br.com.k19.tests;

import br.com.k19.component.Estoque;
import br.com.k19.component.Financeiro;
import br.com.k19.component.Pedido;
import br.com.k19.component.PosVenda;
import br.com.k19.facade.PedidoFacade;

/**
 * Design Pattern
 * Structural - Facade
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Estoque estoque = new Estoque();
    final Financeiro financeiro = new Financeiro();
    final PosVenda posVenda = new PosVenda();

    final PedidoFacade facade = new PedidoFacade(estoque, financeiro, posVenda);
    final Pedido pedido = new Pedido("Notebook", "Rafael Cosentino", "Av Brigadeiro Faria Lima, 1571, São Paulo, SP");
    facade.registraPedido(pedido);
  }
}
