public class Point {

  private final short x;
  private final short y;

  public Point(final short x, final short y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return String.format("[%d,%d]", this.x, this.y);
  }

  public int hashCode() {
    return this.toString().hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return x == point.x &&
        y == point.y;
  }
}
