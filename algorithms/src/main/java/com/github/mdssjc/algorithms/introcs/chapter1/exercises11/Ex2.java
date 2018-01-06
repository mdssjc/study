package com.github.mdssjc.algorithms.introcs.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.1.2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    System.out.println("a. Compile; Erro: o método main não foi encontrado na classe HelloWorld");
    System.out.println("b. Compile; Erro: o método main não é static na classe HelloWorld");
    System.out.println("c. Error: invalid method declaration; return type required");
    System.out.println("d. Error: <identifier> expected");
  }
}
