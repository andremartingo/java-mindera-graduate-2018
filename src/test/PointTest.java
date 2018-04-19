import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import main.Point;
import org.junit.Test;

public class PointTest {

  @Test
  public void ensureCalculateDistanceBetweenTwoPoints() {
    //Given
    Point a = new Point(1, 1);
    Point b = new Point(0, 1);

    //when
    double distance = a.distance(b);

    //Given
    assertEquals(1, distance, 0);
  }

  @Test
  public void ensureIsDistanceValidBetweenTwoPoints() {
    //Given
    Point a = new Point(1, 1);
    Point b = new Point(0, 1);

    //when
    boolean result = a.isDistanceValid(b);

    //Then
    assertTrue(result);
  }

  @Test
  public void ensureGetCoordinatesSeparateByCommas() {
    //Given
    Point a = new Point(1, 1);

    //When
    String result = a.toString();

    //Then
    String expected = "[1,1]";
    assertEquals(expected, result);
  }

  @Test
  public void ensureHashCodeReturnsExpectedInteger() {
    //Given
    Point a = new Point(1, 1);

    //When
    int expected = "[1,1]".hashCode();

    //Then
    assertEquals(expected, a.hashCode());
  }

}