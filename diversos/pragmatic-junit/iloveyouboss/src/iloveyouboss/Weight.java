package iloveyouboss;

public enum Weight {
  MustMatch(Integer.MAX_VALUE),
  VeryImportant(5000),
  Important(1000),
  WouldPrefer(100),
  DontCare(0);

  private int value;

  Weight(final int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
