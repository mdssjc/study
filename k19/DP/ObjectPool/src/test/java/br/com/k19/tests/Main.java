package br.com.k19.tests;

import br.com.k19.pool.Pool;
import br.com.k19.pool.concrete.FuncionarioPool;
import br.com.k19.product.Funcionario;

/**
 * Design Pattern
 * Creational - Object Pool (non GoF)
 *
 * @author mdssjc
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Pool<Funcionario> funcionarioPool = new FuncionarioPool();
    Funcionario funcionario = funcionarioPool.acquire();
    while (funcionario != null) {
      System.out.println(funcionario.getNome());
      funcionario = funcionarioPool.acquire();
    }
  }
}
