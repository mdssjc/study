package br.com.k19.element.concrete;

import br.com.k19.element.Atualizavel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Concrete Element Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@AllArgsConstructor
public abstract class Funcionario implements Atualizavel {

  @Getter
  private final String nome;
  @Getter
  @Setter
  private double       salario;
}
