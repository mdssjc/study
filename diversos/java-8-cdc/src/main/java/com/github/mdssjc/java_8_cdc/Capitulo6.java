package com.github.mdssjc.java_8_cdc;

import static java.util.Comparator.comparingInt;
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
    final Usuario user4 = new Usuario("Paulo Joaquim", 150);

    final List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4);

    final Function<Usuario, String> byName = Usuario::getNome;
    final ToIntFunction<Usuario> byPoints = Usuario::getPontos;

    // usuarios.forEach(Usuario::tornaModerador);
    usuarios.sort(
        nullsLast(comparingInt(byPoints).thenComparing(byName)
                                        .reversed()));

    try {
      usuarios.forEach(System.out::println);
    } catch (final Exception e) {
      System.err.println("Usuário com valor nulo: " + e);
    }

    // Usuario rodrigo = new Usuario("Rodrigo Turini", 50);
    // Runnable bloco = rodrigo::tornaModerador;
    // bloco.run();

    // BiFunction<String, Integer, Usuario> criadorDeUsuarios = Usuario::new;
    // Usuario rodrigo = criadorDeUsuarios.apply("Rodrigo Turini", 50);
    // Usuario paulo = criadorDeUsuarios.apply("Paulo Silveira", 300);

    final UsuarioFactory factory = Usuario::new;
    final Usuario rodrigo = factory.make("Rodrigo Turini", 50);
    final Usuario paulo = factory.make("Paulo Silveira", 300);
  }
}
