package com.github.mdssjc.hfl.ooad.base;

public class Guitar {

  private final String serialNumber;
  private double       price;
  private GuitarSpec   spec;

  public Guitar(final String serialNumber, final double price,
      final GuitarSpec spec) {
    this.serialNumber = serialNumber;
    this.price = price;
    this.spec = spec;
  }

  public String getSerialNumber() {
    return this.serialNumber;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(final float newPrice) {
    this.price = newPrice;
  }

  public GuitarSpec getSpec() {
    return this.spec;
  }

  public void setSpec(final GuitarSpec spec) {
    this.spec = spec;
  }

  @Override
  public boolean equals(final Object other) {
    if (other instanceof Guitar) {
      return this.serialNumber.equals(((Guitar) other).getSerialNumber());
    } else if (other instanceof GuitarSpec) {
      return this.spec.matches((GuitarSpec) other);
    } else if (other instanceof String) {
      return this.serialNumber.equals(other);
    }
    return false;
  }
}
