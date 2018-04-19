import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import main.Brain;
import main.Helper;
import main.Point;
import org.junit.Test;

public class BrainTest {


  @Test
  public void ensureCreate3GroupsWhenLastElementHaveConnectionWithFirstOne() {
    //Given
    Brain calculate = new Brain(Helper.matrix2);

    //When
    List<List<Point>> result = calculate.calculate();

    //Then
    List<List<Point>> expected = new ArrayList<List<Point>>();
    List<Point> expected1 = new ArrayList<>();
    List<Point> expected2 = new ArrayList<>();
    List<Point> expected3 = new ArrayList<>();
    expected1.add(new Point(0, 3));
    expected1.add(new Point(1, 1));
    expected1.add(new Point(1, 2));
    expected1.add(new Point(1, 3));
    expected1.add(new Point(1, 4));
    expected2.add(new Point(0, 6));
    expected2.add(new Point(0, 7));
    expected2.add(new Point(1, 6));
    expected2.add(new Point(1, 7));
    expected2.add(new Point(2, 6));
    expected2.add(new Point(3, 6));
    expected2.add(new Point(3, 7));
    expected2.add(new Point(4, 6));
    expected2.add(new Point(4, 7));
    expected3.add(new Point(3, 3));
    expected3.add(new Point(4, 3));
    expected.add(expected1);
    expected.add(expected2);
    expected.add(expected3);
    assertEquals(expected.size(), result.size());
    int expectedElements = 0;
    for (List<Point> list : expected) {
      expectedElements = list.size() + expectedElements;
    }
    int resultElements = 0;
    for (List<Point> list : result) {
      resultElements = list.size() + resultElements;
    }
    assertEquals(expectedElements, resultElements);

  }

  @Test
  public void ensureCreate1GroupsWhenHaveMatrixWithFullAdjacentCells() {
    //Given
    Brain calculate = new Brain(Helper.matrix2x2);

    //When
    List<List<Point>> result = calculate.calculate();

    //Then
    List<List<Point>> expected = new ArrayList<List<Point>>();
    List<Point> expected1 = new ArrayList<>();
    expected1.add(new Point(0, 0));
    expected1.add(new Point(0, 1));
    expected1.add(new Point(1, 0));
    expected1.add(new Point(1, 1));
    expected.add(expected1);
    assertEquals(expected.size(), result.size());
    int expectedElements = 0;
    for (List<Point> list : expected) {
      expectedElements = list.size() + expectedElements;
    }
    int resultElements = 0;
    for (List<Point> list : result) {
      resultElements = list.size() + resultElements;
    }
    assertEquals(expectedElements, resultElements);

  }

  @Test
  public void ensureDoesntCreateAnyGroupWithEmptyAdjacentCells() {
    //Given
    Brain calculate = new Brain(Helper.matrix2x3);

    //When
    List<List<Point>> result = calculate.calculate();

    //Then
    List<List<Point>> expected = new ArrayList<List<Point>>();
    assertEquals(expected.size(), result.size());
    int expectedElements = 0;
    for (List<Point> list : expected) {
      expectedElements = list.size() + expectedElements;
    }
    int resultElements = 0;
    for (List<Point> list : result) {
      resultElements = list.size() + resultElements;
    }
    assertEquals(expectedElements, resultElements);

  }

  @Test
  public void ensureDoesntCreateAnyGroupWith1AtCorners() {
    //Given
    Brain calculate = new Brain(Helper.matrix3x3);

    //When
    List<List<Point>> result = calculate.calculate();

    //Then
    List<List<Point>> expected = new ArrayList<List<Point>>();
    assertEquals(expected.size(), result.size());
    int expectedElements = 0;
    for (List<Point> list : expected) {
      expectedElements = list.size() + expectedElements;
    }
    int resultElements = 0;
    for (List<Point> list : result) {
      resultElements = list.size() + resultElements;
    }
    assertEquals(expectedElements, resultElements);

  }

  @Test
  public void acceptanceTest() {
    //Given
    Brain calculate = new Brain(Helper.matrix);

    //When
    List<List<Point>> result = calculate.calculate();

    //Then
    List<List<Point>> expected = new ArrayList<List<Point>>();
    List<Point> expected1 = new ArrayList<>();
    List<Point> expected2 = new ArrayList<>();
    List<Point> expected3 = new ArrayList<>();
    expected1.add(new Point(0, 3));
    expected1.add(new Point(1, 2));
    expected1.add(new Point(1, 3));
    expected1.add(new Point(1, 4));
    expected2.add(new Point(0, 6));
    expected2.add(new Point(0, 7));
    expected2.add(new Point(1, 6));
    expected2.add(new Point(1, 7));
    expected2.add(new Point(2, 6));
    expected2.add(new Point(3, 6));
    expected2.add(new Point(3, 7));
    expected2.add(new Point(4, 6));
    expected2.add(new Point(4, 7));
    expected3.add(new Point(3, 3));
    expected3.add(new Point(4, 3));
    expected.add(expected1);
    expected.add(expected2);
    expected.add(expected3);
    assertEquals(expected.size(), result.size());
    int expectedElements = 0;
    for (List<Point> list : expected) {
      expectedElements = list.size() + expectedElements;
    }
    int resultElements = 0;
    for (List<Point> list : result) {
      resultElements = list.size() + resultElements;
    }
    assertEquals(expectedElements, resultElements);

  }

  @Test
  public void acceptanceTestMatrix100x100() {
    //Given
    Brain calculate = new Brain(Helper.matrix100x100);

    //When
    List<List<Point>> result = calculate.calculate();

    //Then
    assertEquals(623,result.size());
  }
}