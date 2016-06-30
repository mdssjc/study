package com.github.mdssjc.fpij;

@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {

  void accept(T instance) throws X;
}
