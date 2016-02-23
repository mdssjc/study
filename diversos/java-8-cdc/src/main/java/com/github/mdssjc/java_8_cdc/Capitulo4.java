package com.github.mdssjc.java_8_cdc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo4 {

  public static void main(final String[] args) {
    final Usuario user1 = new Usuario("Paulo Silveira", 150);
    final Usuario user2 = new Usuario("Rodrigo Turini", 120);
    final Usuario user3 = new Usuario("Guilherme Silveira", 190);

    // List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
    final List<Usuario> usuarios = new ArrayList<>();
    usuarios.add(user1);
    usuarios.add(user2);
    usuarios.add(user3);

    final Consumer<Usuario> monstraMensagem = u -> System.out.println(
        "antes de imprimir os nomes");
    final Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());

    usuarios.forEach(monstraMensagem.andThen(imprimeNome));

    usuarios.removeIf(u -> u.getPontos() > 160);
    usuarios.forEach(u -> System.out.println(u.getNome()));
  }
}
