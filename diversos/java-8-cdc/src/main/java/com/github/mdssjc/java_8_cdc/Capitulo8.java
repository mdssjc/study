package com.github.mdssjc.java_8_cdc;

import static java.util.Comparator.comparing;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Capitulo8 {

  static Stream<String> lines(final Path p) {
    try {
      return Files.lines(p);
    } catch (final IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  public static void main(final String[] args) {
    final UsuarioFactory factory = Usuario::new;
    final Usuario user1 = factory.make("Paulo Silveira", 150);
    final Usuario user2 = factory.make("Rodrigo Turini", 120);
    final Usuario user3 = factory.make("Guilherme Silveira", 90);

    final List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

    usuarios.stream()
            // .filter(u -> u.getPontos() > 100)
            .sorted(comparing(Usuario::getNome))
            .peek(System.out::println)
            .findAny();

    final int reduce = usuarios.stream()
                               .mapToInt(u -> u.getPontos())
                               .reduce(1, (a, b) -> a * b);
    System.out.println("Pontos: " + reduce);

    try {
      Files.list(Paths.get("./src/main/java/com/github/mdssjc/java_8_cdc"))
           .filter(p -> p.toString()
                         .endsWith(".java"))
           .flatMap(p -> lines(p))
           .forEach(System.out::println);
    } catch (final Exception e) {
      System.err.println(e);
    }
  }
}
