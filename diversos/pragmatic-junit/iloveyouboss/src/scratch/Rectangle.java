package scratch;

public class Rectangle {

  private Point origin;
  private Point opposite;

  public Rectangle(final Point origin, final Point oppositeCorner) {
    this.origin = origin;
    this.opposite = oppositeCorner;
  }

  public Rectangle(final Point origin) {
    this.opposite = this.origin = origin;
  }

  public int area() {
    return Math.abs(this.origin.x - this.opposite.x)
        * Math.abs(this.origin.y - this.opposite.y);
  }

  public void setOppositeCorner(final Point opposite) {
    this.opposite = opposite;
  }

  public Point origin() {
    return this.origin;
  }

  public Point opposite() {
    return this.opposite;
  }

  @Override
  public String toString() {
    return "Rectangle(origin " + this.origin + " opposite " + this.opposite
        + ")";
  }
}
