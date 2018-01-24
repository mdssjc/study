package com.github.mdssjc.design_patterns.structural.adapter;

/**
 * Padrão de projeto: Adapter.
 * <p>
 * Design Pattern
 * Class, Object Structural / Interfaces - Adapter (Wrapper)
 * <p>
 * O padrão Adapter converte a interface de uma classe em outra interface,
 * esperada pelos clientes. O Adapter permite que classes com interfaces
 * incompatíveis trabalhem em conjunto - o que de outra foram seria impossível.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Target adapter = new Adapter(new Adaptee());
    final String message = adapter.request();

    System.out.println(message);
  }
}
