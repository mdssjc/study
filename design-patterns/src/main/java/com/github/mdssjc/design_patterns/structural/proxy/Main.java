package com.github.mdssjc.design_patterns.structural.proxy;

/**
 * Padrão de projeto: Proxy.
 * <p>
 * Design Pattern
 * Object Structural / Responsibility - Proxy (Surrogate)
 * <p>
 * O padrão Proxy fornece um substituto ou marcador da localização de outro
 * objeto para controlar o acesso a esse objeto.
 * <p>
 * Tipos: Remote, Virtual, Protection, Smart Reference, Firewall, Caching,
 * Synchronization, Complexity Hiding e Copy-On-Write.
 * <p>
 * Fornece uma mesma interface.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Subject subject = new Proxy(new RealSubject());
    System.out.println(subject.request());
  }
}
