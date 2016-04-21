package scratch;

public class Coverage {

  private int count;

  public void soleMethod() {
    if (this.count > 0) {
      this.count++;
    }
  }

  public void setCount(final int count) {
    this.count = count;
  }
}
