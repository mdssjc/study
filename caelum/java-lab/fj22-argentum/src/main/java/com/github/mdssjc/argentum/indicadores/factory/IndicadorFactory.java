package com.github.mdssjc.argentum.indicadores.factory;

import com.github.mdssjc.argentum.indicadores.Indicador;
import com.github.mdssjc.argentum.indicadores.IndicadorFechamento;
import com.github.mdssjc.argentum.indicadores.MediaMovelSimples;

import java.lang.reflect.Constructor;

public class IndicadorFactory {

  private static final int INTERVALO = 3;
  private final String nomeMedia;
  private final String nomeIndicadorBase;

  public IndicadorFactory(final String nomeMedia, final String nomeIndicadorBase) {
    this.nomeMedia = nomeMedia;
    this.nomeIndicadorBase = nomeIndicadorBase;
  }

  public Indicador defineIndicador() {
    if (this.nomeIndicadorBase == null || this.nomeMedia == null) {
      return new MediaMovelSimples(new IndicadorFechamento(), INTERVALO);
    }

    try {
      final String pacote = "com.github.mdssjc.argentum.indicadores.";
      final Class<?> classeIndicadorBase = Class.forName(
          pacote + this.nomeIndicadorBase);
      final Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();

      final Class<?> classeMedia = Class.forName(pacote + this.nomeMedia);
      final Constructor<?> construtorMedia = classeMedia.getConstructor(
          Indicador.class, int.class);

      final Indicador indicador = (Indicador) construtorMedia.newInstance(
          indicadorBase, INTERVALO);

      return indicador;
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }
}
