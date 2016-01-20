package br.com.k19.pool.concrete;

import java.util.ArrayList;

import br.com.k19.pool.Pool;
import br.com.k19.product.Funcionario;

/**
 * Concrete Pool Class
 *
 * @author mdssjc
 *
 */
public class FuncionarioPool implements Pool<Funcionario> {

  private final ArrayList<Funcionario> funcionarios;

  public FuncionarioPool() {
    this.funcionarios = new ArrayList<>();
    this.funcionarios.add(new Funcionario("Marcelo Martins"));
    this.funcionarios.add(new Funcionario("Rafael Cosentino"));
    this.funcionarios.add(new Funcionario("Jonas Hirata"));
  }

  @Override
  public Funcionario acquire() {
    if (!this.funcionarios.isEmpty()) {
      return this.funcionarios.remove(0);
    }
    return null;
  }

  @Override
  public void release(final Funcionario funcionario) {
    this.funcionarios.add(funcionario);
  }
}
