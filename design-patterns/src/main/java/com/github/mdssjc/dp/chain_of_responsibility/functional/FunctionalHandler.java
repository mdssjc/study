package com.github.mdssjc.dp.chain_of_responsibility.functional;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Classe FunctionalHandler.
 *
 * @author Marcelo dos Santos
 *
 */
public class FunctionalHandler {

  public void handleRequest(final Object message) {
    System.out.println(Stream.<Function<Object, Optional<String>>>of(
        FunctionalHandler::textual,
        FunctionalHandler::numeric)
        .map(f -> f.apply(message))
        .filter(Optional::isPresent)
        .findFirst()
        .flatMap(Function.identity())
        .orElseThrow(() -> new RuntimeException("Fim da cadeia")));
  }

  public static Optional<java.lang.String> textual(final Object message) {
    return (message instanceof String) ?
        Optional.of("Mensagem textual: " + message) :
        Optional.empty();
  }

  public static Optional<String> numeric(final Object message) {
    return (message instanceof Integer) ?
        Optional.of("Mensagem numérica: " + String.valueOf(message)) :
        Optional.empty();
  }
}
