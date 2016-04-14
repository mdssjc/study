package iloveyouboss;

public class Address {

  public final String road;
  public final String city;
  public final String state;
  public final String zip;
  public final String houseNumber;

  public Address(final String houseNumber, final String road, final String city,
      final String state,
      final String zip) {
    this.houseNumber = houseNumber;
    this.road = road;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  @Override
  public String toString() {
    return this.houseNumber + " " + this.road + ", " + this.city + " "
        + this.state + " " + this.zip;
  }
}
