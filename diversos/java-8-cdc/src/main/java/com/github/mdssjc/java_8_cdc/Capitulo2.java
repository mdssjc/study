package com.github.mdssjc.java_8_cdc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2 {

  public static void main(final String[] args) {
    final Consumer<Usuario> mostrador = (u) -> System.out.println(u.getNome());

    final Usuario user1 = new Usuario("Paulo Silveira", 150);
    final Usuario user2 = new Usuario("Rodrigo Turini", 120);
    final Usuario user3 = new Usuario("Guilherme Silveira", 190);

    final List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
    usuarios.forEach(mostrador);
    usuarios.forEach(u -> u.tornaModerador());
  }
}
