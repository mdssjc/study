package com.github.mdssjc.argentum.modelo;

import org.junit.Test;

public class SerieTemporalTest {

  @Test(expected = IllegalArgumentException.class)
  public void receberListaNula() {
    new SerieTemporal(null);
  }
}
