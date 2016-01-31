package br.com.k19.element.concrete;

import br.com.k19.visitor.AtualizadorDeFuncionario;
import lombok.Getter;

/**
 * Concrete Element Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Telefonista extends Funcionario {

  @Getter
  private final int ramal;

  public Telefonista(final String nome, final double salario, final int ramal) {
    super(nome, salario);
    this.ramal = ramal;
  }

  @Override
  public void aceita(final AtualizadorDeFuncionario atualizador) {
    atualizador.atualiza(this);
  }
}
