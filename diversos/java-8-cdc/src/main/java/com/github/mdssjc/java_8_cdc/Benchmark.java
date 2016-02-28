package com.github.mdssjc.java_8_cdc;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Benchmark {

  public static void main(final String[] args) throws RunnerException {
    final Options opt = new OptionsBuilder()
                                            .include(
                                                Capitulo9.class.getSimpleName())
                                            .forks(1)
                                            .build();
    new Runner(opt).run();
  }
}
