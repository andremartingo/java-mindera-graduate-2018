public class Point {

  private final int x;
  private final int y;

  public Point(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point point) {
    return (Math.hypot(this.x - point.x, this.y - point.y));
  }

  public String toString() {
    return String.format("[%d,%d]", this.x, this.y);
  }

  public int hashCode() {
    return this.toString().hashCode();
  }

  public boolean isDistanceValid(Point point) {
    return distance(point) == 1 ? true : false;
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
