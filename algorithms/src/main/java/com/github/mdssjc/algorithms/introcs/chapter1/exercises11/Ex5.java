package com.github.mdssjc.algorithms.introcs.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.1.5.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex5 {

  public static void main(final String[] args) {
    Executor.execute(Ex5.class, args);

    System.out.println("a. Print Hi, java. How are you?");
    System.out.println("b. zsh: event not found: &"); // in ZSH
    System.out.println("c. Print Hi, 1234. How are you?");
    System.out.println("d. Erro: Não foi possível localizar nem carregar a classe principal UseArgument.java");
    System.out.println("e. Print Hi, Alice. How are you?");
  }
}
