package com.github.mdssjc.java_8_cdc;

@FunctionalInterface
public interface UsuarioFactory {

  Usuario make(String nome, int pontos);
}
