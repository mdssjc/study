package com.github.mdssjc.hfooad.ricksguitars.types;

/**
 * Instrument Type Enum.
 * 
 * @author Marcelo dos Santos
 *
 */
public enum InstrumentType {
  GUITAR,
  BANJO,
  DOBRO,
  FIDDLE,
  BASS,
  MANDOLIN;

  @Override
  public String toString() {
    switch (this) {
      case GUITAR:
        return "Guitar";
      case BANJO:
        return "Banjo";
      case DOBRO:
        return "Dobro";
      case FIDDLE:
        return "Fiddle";
      case BASS:
        return "Bass";
      case MANDOLIN:
        return "Mandolin";
      default:
        return "Unspecified";
    }
  }
}
