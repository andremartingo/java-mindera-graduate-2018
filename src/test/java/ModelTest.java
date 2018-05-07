import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import utils.Helper;

public class ModelTest {

  @Test
  public void ensureCreate3GroupsWhenLastElementHaveConnectionWithFirstOne() {
    //Given
    Model brain = new Model(Helper.matrix2);

    //When
    List<List<Point>> result = brain.labelMatrix();

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
    Model brain = new Model(Helper.matrix2x2);

    //When
    List<List<Point>> result = brain.labelMatrix();

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
  public void ensureCanNotCreateAnyGroupWithEmptyAdjacentCells() {
    //Given
    Model calculate = new Model(Helper.matrix2x3);

    //When
    List<List<Point>> result = calculate.labelMatrix();

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
  public void ensureCanNotCreateAnyGroupWith1AtCorners() {
    //Given
    Model calculate = new Model(Helper.matrix3x3);

    //When
    List<List<Point>> result = calculate.labelMatrix();

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
    Model calculate = new Model(Helper.matrix);

    //When
    List<List<Point>> result = calculate.labelMatrix();

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
  public void acceptanceTestMatrix20000x20000() {
    //Given
    int[][] matrix = new int[20000][20000];
    matrix[19999][19999] = 1;
    matrix[19998][19999] = 1;
    Model calculate = new Model(matrix);

    //When
    List<List<Point>> result = calculate.labelMatrix();

    //Then
    Point point1 = new Point(19999, 19999);
    Point point2 = new Point(19998, 19999);
    assertTrue(result.get(0).contains(point1));
    assertTrue(result.get(0).contains(point2));
    assertEquals(2, result.get(0).size());
    assertEquals(1, result.size());
  }




}