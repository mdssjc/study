package com.github.mdssjc.hfl.ooad.base;

public class Guitar {

  private final String     serialNumber;
  private double           price;
  private final GuitarSpec spec;

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

  public boolean matches(final Object other) {
    if (other instanceof Guitar) {
      return this.serialNumber.equals(((Guitar) other).getSerialNumber());
    } else if (other instanceof GuitarSpec) {
      return this.spec.matches((GuitarSpec) other);
    } else if (other instanceof String) {
      return this.serialNumber.equals(other);
    }
    return false;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((this.serialNumber == null) ? 0 : this.serialNumber.hashCode());
    result = prime * result + ((this.spec == null) ? 0 : this.spec.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (getClass() != object.getClass()) {
      return matches(object);
    }
    final Guitar other = (Guitar) object;
    if (this.serialNumber == null) {
      if (other.serialNumber != null) {
        return false;
      }
    } else if (!this.serialNumber.equals(other.serialNumber)) {
      return false;
    }
    if (this.spec == null) {
      if (other.spec != null) {
        return false;
      }
    } else if (!this.spec.equals(other.spec)) {
      return false;
    }
    return true;
  }
}
