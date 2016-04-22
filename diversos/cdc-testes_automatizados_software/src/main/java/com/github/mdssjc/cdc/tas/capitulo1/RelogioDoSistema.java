package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.Calendar;

public class RelogioDoSistema implements Relogio {

  @Override
  public Calendar hoje() {
    return Calendar.getInstance();
  }
}
