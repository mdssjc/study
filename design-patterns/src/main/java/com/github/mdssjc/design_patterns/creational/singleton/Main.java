package com.github.mdssjc.design_patterns.creational.singleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Padrão de projeto: Singleton.
 * <p>
 * Design Pattern
 * Object Creational / Responsibility - Singleton
 * <p>
 * O padrão Singleton garante que uma classe tenha somente uma instância e
 * forneça um ponto global de acesso para a mesma.
 * <p>
 * Pode ser substituído pelo Dependency Injection.
 * DoubleCheckSingleton é um anti-pattern.
 * <p>
 * Benefícios:
 * - cross platform;
 * - applicable to any class;
 * - can be created through derivation; and
 * - lazy evaluation.
 * Custos:
 * - destruction is undefined;
 * - not inherited;
 * - efficiency; and
 * - nontransparent.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Singleton singleton = Singleton.instance();
    final SimpleLazySingleton lazy = SimpleLazySingleton.instance();
    final SimpleEagerSingleton eager = SimpleEagerSingleton.instance();
    final SynchronizedSingleton sync = SynchronizedSingleton.instance();
    final DoubleCheckSingleton doubleCheck = DoubleCheckSingleton.instance();
    final EnumSingleton enumerated = EnumSingleton.INSTANCE;
    final InitializeOnDemandSingleton ondemand = InitializeOnDemandSingleton.instance();

    display(singleton);
    display(lazy);
    display(eager);
    display(sync);
    display(doubleCheck);
    display(enumerated);
    display(ondemand);
  }

  private static void display(final Object singleton) {
    try {
      System.out.println(singleton.getClass()
                                  .getSimpleName());

      final Method getData = singleton.getClass()
                                      .getMethod("getData");
      String message = (String) getData.invoke(singleton);
      System.out.println(message);

      final Method operation = singleton.getClass()
                                        .getMethod("operation");
      operation.invoke(singleton);
      message = (String) getData.invoke(singleton);
      System.out.println(message);
    } catch (final NoSuchMethodException | InvocationTargetException |
        IllegalAccessException e) {
      System.out.println(e.getMessage());
    }
  }
}
