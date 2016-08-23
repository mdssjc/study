package com.github.mdssjc.cdc.ra.ch02;

import java.io.IOException;

public class CriacaoClasse {

  public CriacaoClasse() throws IOException {
    throw new IOException();
  }

  public static void main(final String[] args) {
    try {
      final CriacaoClasse obj = CriacaoClasse.class.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
