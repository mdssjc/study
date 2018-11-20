package com.github.mdssjc.design_patterns.behavioral.chain_of_responsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Padrão de projeto: Chain of Responsibility.
 * <p>
 * Design Pattern
 * Object Behavioral / Responsibility - Chain of Responsibility
 * <p>
 * O padrão Chain of Responsibility evita o acoplamento do remetente de uma
 * solicitação ao seu receptor, ao dar a mais de um objeto a oportunidade de
 * tratar a solicitação. Encadea os objetos receptores, passando a solicitação
 * ao longo da cadeia até que um objeto a trate.
 *
 * @author Marcelo dos Santos
 */
public class Main {

  public static void main(final String[] args) {
    // Classic
    final Handler handler = new Handler();
    handler.add(new ConcreteHandler1());
    handler.add(new ConcreteHandler2());

    final String message1 = handler.handleRequest(String.class);
    final String message2 = handler.handleRequest(Integer.class);
    final String message3 = handler.handleRequest(Boolean.class);

    System.out.println(message1);
    System.out.println(message2);
    System.out.println(message3);

    // Functional
    final UnaryOperator<String> message4 = text -> text + "Concrete Handler 1";
    final UnaryOperator<String> message5 = text -> text + "12345";

    final Function<String, String> pipeline = message4.andThen(message5);

    final String result = pipeline.apply("Response: ");
    System.out.println(result);
  }
}

