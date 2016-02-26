package com.github.mdssjc.java_8_cdc;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Capitulo7 {

  public static void main(final String[] args) {
    final UsuarioFactory factory = Usuario::new;
    final Usuario user1 = factory.make("Paulo Silveira", 150);
    final Usuario user2 = factory.make("Rodrigo Turini", 120);
    final Usuario user3 = factory.make("Guilherme Silveira", 90);

    final List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

    final Predicate<Usuario> predicate = u -> u.getPontos() > 100;

    usuarios.stream()
            .filter(predicate)
            .peek(Usuario::tornaModerador)
            .forEach(System.out::println);

    final Supplier<ArrayList<Usuario>> supplier = ArrayList::new;
    final BiConsumer<ArrayList<Usuario>, Usuario> accumulator = ArrayList::add;
    final BiConsumer<ArrayList<Usuario>, ArrayList<Usuario>> combiner = ArrayList::addAll;

    final List<Usuario> maisQue100 = usuarios.stream()
                                             .filter(predicate)
                                             .collect(supplier,
                                                 accumulator,
                                                 combiner);
    maisQue100.forEach(System.out::println);

    final List<Usuario> outroMaisQue100 = usuarios.stream()
                                                  .filter(predicate)
                                                  .collect(toList());
    outroMaisQue100.forEach(System.out::println);

    final double pontuacaoMedia = usuarios.stream()
                                          .mapToInt(Usuario::getPontos)
                                          .average()
                                          .getAsDouble();
    System.out.println(pontuacaoMedia);

    // usuarios = Arrays.asList();
    final Optional<String> maxNome = usuarios.stream()
                                             .max(comparingInt(
                                                 Usuario::getPontos))
                                             .map(Usuario::getNome);
    System.out.println(maxNome.orElse("Sem Participantes"));
  }
}
