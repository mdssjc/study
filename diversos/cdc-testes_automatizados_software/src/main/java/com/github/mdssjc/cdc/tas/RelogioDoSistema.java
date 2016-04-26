package com.github.mdssjc.cdc.tas;

import java.util.Calendar;

public class RelogioDoSistema implements Relogio {

  @Override
  public Calendar hoje() {
    return Calendar.getInstance();
  }
}
