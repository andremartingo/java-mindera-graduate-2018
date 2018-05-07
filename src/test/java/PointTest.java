import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointTest {

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