package br.com.k19.visitor.concrete;

import br.com.k19.element.concrete.Gerente;
import br.com.k19.element.concrete.Telefonista;
import br.com.k19.visitor.AtualizadorDeFuncionario;

/**
 * Concrete Visitor Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class AtualizadorSalarial implements AtualizadorDeFuncionario {

  @Override
  public void atualiza(final Gerente gerente) {
    gerente.setSalario(gerente.getSalario() * 1.43);
  }

  @Override
  public void atualiza(final Telefonista telefonista) {
    telefonista.setSalario(telefonista.getSalario() * 1.27);
  }
}
