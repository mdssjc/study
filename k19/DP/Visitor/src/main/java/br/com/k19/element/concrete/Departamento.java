package br.com.k19.element.concrete;

import java.util.ArrayList;
import java.util.List;

import br.com.k19.visitor.AtualizadorDeFuncionario;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Concrete Element Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@RequiredArgsConstructor
public class Departamento {

  @Getter
  @NonNull
  private final String            nome;
  @Getter
  private final List<Funcionario> funcionarios = new ArrayList<>();

  public void aceita(final AtualizadorDeFuncionario atualizador) {
    for (final Funcionario funcionario : this.funcionarios) {
      funcionario.aceita(atualizador);
    }
  }
}
