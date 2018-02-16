package com.github.mdssjc.design_patterns.structural.flyweight;

/**
 * Padrão de projeto: Flyweight.
 * <p>
 * Design Pattern
 * Object Structural / Responsibility - Flyweight
 * <p>
 * O padrão Flyweight usa compartilhamento para suportar eficientemente grandes
 * quantidades de objetos de granularidade fina.
 * <p>
 * Estado intrínseco: campos que contêm dados invariáveis, duplicados através de
 * vários objetos;
 * Estado extrínseco: campos que contêm dados contextuais, únicos para todos os
 * objetos.
 * Objetos são imutáveis.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final FlyweightFactory flyweightFactory = new FlyweightFactory();

    final Flyweight flyweightA1 = flyweightFactory.getFlyweight("concrete");
    final Flyweight flyweightA2 = flyweightFactory.getFlyweight("concrete");

    final boolean same = flyweightA1 == flyweightA2;
    System.out.println(flyweightA1.operation(">> "));
    System.out.println(flyweightA2.operation(""));
    System.out.println(same);

    final Flyweight flyweightB1 = flyweightFactory.getFlyweight("unshared");
    final Flyweight flyweightB2 = flyweightFactory.getFlyweight("unshared");

    final boolean notSame = flyweightB1 == flyweightB2;
    System.out.println(flyweightB1.operation(">> "));
    System.out.println(flyweightB2.operation(""));
    System.out.println(notSame);
  }
}
