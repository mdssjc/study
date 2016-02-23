package com.github.mdssjc.java_8_cdc;

@FunctionalInterface
public interface Validador<T> {

  boolean valida(T t);
}
