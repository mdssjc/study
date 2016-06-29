package com.javacodegeeks.advanced.construction.patterns;

import java.text.DateFormat;
import java.util.Date;

public class Dependant {

  // Before
  // private final DateFormat format = DateFormat.getDateInstance();
  //
  // public String format(final Date date) {
  // return format.format(date);
  // }

  // After
  private final DateFormat format;

  public Dependant(final DateFormat format) {
    this.format = format;
  }

  public String format(final Date date) {
    return format.format(date);
  }
}
