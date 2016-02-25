package com.github.mdssjc.java_8_cdc;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsLast;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Capitulo6 {

  public static void main(final String[] args) {
    final Usuario user1 = new Usuario("Paulo Silveira", 150);
    final Usuario user2 = new Usuario("Rodrigo Turini", 120);
    final Usuario user3 = new Usuario("Guilherme Silveira", 190);
    final Usuario user4 = null;

    final List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4);

    final Function<Usuario, String> byName = Usuario::getNome;
    final ToIntFunction<Usuario> byPoints = Usuario::getPontos;

    // usuarios.sort(comparing(byName).thenComparingInt(byPoints));

    // usuarios.forEach(Usuario::tornaModerador);
    usuarios.sort(
        nullsLast(comparing(byName).thenComparingInt(byPoints)));

    try {
      usuarios.forEach(
          u -> System.out.println(u.getNome() + " " + u.isModerador()));
    } catch (final Exception e) {
      System.err.println("Usuário com valor nulo: " + e);
    }
  }
}
