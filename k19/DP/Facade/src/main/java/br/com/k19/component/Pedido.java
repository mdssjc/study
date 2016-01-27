package br.com.k19.component;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Component Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@AllArgsConstructor
public class Pedido {

  @Getter
  private final String produto;
  @Getter
  private final String cliente;
  @Getter
  private final String enderecoDeEntrega;
}
