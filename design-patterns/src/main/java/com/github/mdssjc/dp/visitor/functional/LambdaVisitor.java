package com.github.mdssjc.dp.visitor.functional;

import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementA;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementB;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Classe LambdaVisitor.
 *
 * @author Marcelo dos Santos
 *
 */
public class LambdaVisitor<A> implements Function<Object, A> {

  public static final Function<Object, String> visitor1 = new LambdaVisitor<String>()
      .on(ConcreteElementA.class)
      .then(e -> e.operationA("Visitado"))
      .on(ConcreteElementB.class)
      .then(e -> e.operationB("Visitado"));

  public static final Function<Object, Integer> visitor2 = new LambdaVisitor<Integer>()
      .on(ConcreteElementA.class)
      .then(e -> e.operationA("A").length())
      .on(ConcreteElementB.class)
      .then(e -> e.operationB("AB").length());

  private final Map<Class<?>, Function<Object, A>> fMap = new HashMap<>();

  public <B> Acceptor<A, B> on(final Class<B> clazz) {
    return new Acceptor<>(this, clazz);
  }

  @Override
  public A apply(final Object o) {
    return this.fMap.get(o.getClass()).apply(o);
  }

  static class Acceptor<A, B> {

    private final LambdaVisitor visitor;
    private final Class<B> clazz;

    Acceptor(final LambdaVisitor<A> visitor, final Class<B> clazz) {
      this.visitor = visitor;
      this.clazz = clazz;
    }

    public LambdaVisitor<A> then(final Function<B, A> f) {
      this.visitor.fMap.put(this.clazz, f);
      return this.visitor;
    }
  }
}
