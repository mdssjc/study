package com.github.mdssjc.java_8_cdc;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Capitulo5 {

  public static void main(final String[] args) {
    final Usuario user1 = new Usuario("Paulo Silveira", 150);
    final Usuario user2 = new Usuario("Rodrigo Turini", 120);
    final Usuario user3 = new Usuario("Guilherme Silveira", 190);

    final List<Usuario> usuarios = new ArrayList<>();
    usuarios.add(user1);
    usuarios.add(user2);
    usuarios.add(user3);

    // final Comparator<Usuario> comparator = (u1, u2) -> u1.getNome()
    // .compareTo(
    // u2.getNome());

    // Collections.sort(usuarios, comparator);

    // Por nome
    final Function<Usuario, String> extraiNome = u -> u.getNome();
    final Comparator<Usuario> comparator = comparing(extraiNome);
    usuarios.sort(comparator);
    usuarios.forEach(u -> System.out.println(u.getNome()));

    // Por pontos
    final ToIntFunction<Usuario> extraiPontos = u -> u.getPontos();
    final Comparator<Usuario> comparator2 = comparingInt(extraiPontos);
    usuarios.sort(comparator2);
    usuarios.forEach(u -> System.out.println(u.getNome()));

    final List<String> palavras = Arrays.asList("Casa do Código", "Alura",
        "Caelum");
    palavras.sort(Comparator.naturalOrder());
    palavras.forEach(p -> System.out.println(p));
    palavras.sort(Comparator.reverseOrder());
    palavras.forEach(p -> System.out.println(p));
  }
}
