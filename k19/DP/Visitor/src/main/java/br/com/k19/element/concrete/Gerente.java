package br.com.k19.element.concrete;

import br.com.k19.visitor.AtualizadorDeFuncionario;
import lombok.Getter;

/**
 * Concrete Element Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Gerente extends Funcionario {

  @Getter
  private final String senha;

  public Gerente(final String nome, final double salario, final String senha) {
    super(nome, salario);
    this.senha = senha;
  }

  @Override
  public void aceita(final AtualizadorDeFuncionario atualizador) {
    atualizador.atualiza(this);
  }
}
