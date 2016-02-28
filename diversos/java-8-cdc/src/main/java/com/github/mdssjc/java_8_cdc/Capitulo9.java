package com.github.mdssjc.java_8_cdc;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

public class Capitulo9 {

  private static final String REF = "./src/main/java/com/github/mdssjc/java_8_cdc";

  static Stream<String> lines(final Path p) {
    try {
      return Files.lines(p);
    } catch (final IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  public static void main(final String[] args) {
    try {
      final Map<Path, Long> lines;
      lines = Files.list(Paths.get(Capitulo9.REF))
                   .filter(p -> p.toString()
                                 .endsWith(".java"))
                   .collect(
                       Collectors.toMap(
                           Function.identity(),
                           p -> lines(p).count()));
      System.out.println(lines);
    } catch (final Exception e) {
      System.err.println(e);
    }

    final Usuario user1 = new Usuario("Paulo Silveira", 150, true);
    final Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
    final Usuario user3 = new Usuario("Guilherme Silveira", 90);
    final Usuario user4 = new Usuario("Sergio Lopes", 120);
    final Usuario user5 = new Usuario("Adriano Almeida", 100);

    final List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4,
        user5);

    final Map<Integer, List<Usuario>> pontuacao;
    pontuacao = usuarios.stream()
                        .collect(
                            Collectors.groupingBy(
                                Usuario::getPontos));

    final Map<Boolean, Integer> pontuacaoPorTipo;
    pontuacaoPorTipo = usuarios.stream()
                               .collect(
                                   Collectors.partitioningBy(
                                       Usuario::isModerador,
                                       Collectors.summingInt(
                                           Usuario::getPontos)));

    System.out.println(pontuacao);
    System.out.println(pontuacaoPorTipo);

    final List<Usuario> filtradosOrdenados;
    filtradosOrdenados = usuarios.parallelStream()
                                 .filter(
                                     u -> u.getPontos() > 100)
                                 .sorted(
                                     Comparator.comparing(
                                         Usuario::getNome))
                                 .collect(
                                     Collectors.toList());

    final long sum = pipelineP();
    System.out.println(sum);
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public static long pipelineP() {
    return LongStream.range(0, 1000000000)
                     // .parallel()
                     .filter(x -> (x & 1) == 0)
                     // .filter(x -> x % 2 == 0)
                     .sum();
  }
}
