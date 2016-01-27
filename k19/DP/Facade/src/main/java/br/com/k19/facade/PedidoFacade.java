package br.com.k19.facade;

import br.com.k19.component.Estoque;
import br.com.k19.component.Financeiro;
import br.com.k19.component.Pedido;
import br.com.k19.component.PosVenda;
import lombok.AllArgsConstructor;

/**
 * Facade Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@AllArgsConstructor
public class PedidoFacade {

  private final Estoque    estoque;
  private final Financeiro financeiro;
  private final PosVenda   posVenda;

  public void registraPedido(final Pedido p) {
    this.estoque.enviaProduto(p.getProduto(), p.getEnderecoDeEntrega());
    this.financeiro.fatura(p.getCliente(), p.getProduto());
    this.posVenda.agendaContato(p.getCliente(), p.getProduto());
  }
}
