package main;

import java.util.ArrayList;
import java.util.List;

public class Brain {


  private int[][] matrix;

  public Brain(int[][] matrix) {
    this.matrix = matrix;
  }

  /**
   * Method to return Lists Grouped by Distance
   */
  public List<List<Point>> calculate() {
    List<Point> adjacentCells = this.adjacentCells();
    return splitAdjacentCellsInGroups(adjacentCells);
  }

  /**
   * Get all adjacent cells
   */
  private List<Point> adjacentCells() {
    List<Point> adjacent = new ArrayList();
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] == 1 && isAdjacent(row, col)) {
          adjacent.add(new Point(row, col));
        }
      }
    }
    return adjacent;
  }

  /**
   * Check if the cell is adjacent
   */
  private boolean isAdjacent(int row, int col) {
    if (isAdjacentRight(row, col)) {
      return true;
    }
    if (isAdjacentLeft(row, col)) {
      return true;
    }
    if (isAdjacentTop(row, col)) {
      return true;
    }
    if (isAdjacentDown(row, col)) {
      return true;
    }
    return false;
  }

  /**
   * Check if a point is Adjacent on the Right side
   */
  private boolean isAdjacentRight(int row, int col) {
    if (col + 1 >= matrix[row].length) {
      return false;
    }
    return (matrix[row][col + 1] == 1);
  }

  /**
   * Check if a point is Adjacent on the Left side
   */
  private boolean isAdjacentLeft(int row, int col) {
    if (col - 1 < 0) {
      return false;
    }
    return (matrix[row][col - 1] == 1);
  }

  /**
   * Check if a point is Adjacent on Top
   */
  private boolean isAdjacentTop(int row, int col) {
    if (row - 1 < 0) {
      return false;
    }
    return (matrix[row - 1][col] == 1);
  }

  /**
   * Check if a point is Adjacent on the Bottom side
   */
  private boolean isAdjacentDown(int row, int col) {
    if (row + 1 >= matrix.length) {
      return false;
    }
    return (matrix[row + 1][col] == 1);
  }

  /**
   * Create List of Lists separate by group
   *
   * @param adjacentCells - All Coordinates which have distance 1 to another coordinate
   */
  private List<List<Point>> splitAdjacentCellsInGroups(List<Point> adjacentCells) {
    List<List<Point>> listOLists = new ArrayList<>();
    listOLists = splitInGroups(listOLists, adjacentCells);
    listOLists = splitInGroups(listOLists, adjacentCells);
    listOLists = eliminateDuplicates(listOLists, adjacentCells);
    return (cleanLists(listOLists));
  }

  /**
   * Create One List per Group
   */
  private List<List<Point>> splitInGroups(List<List<Point>> listOLists,
      List<Point> adjacentCells) {
    for (Point point : adjacentCells) {
      listOLists = updateLists(listOLists, point);
    }
    return listOLists;
  }

  /**
   * Add a Point to a List based on Points Distance, if it doesn't have the correct distance create
   * new list with it
   */
  private List<List<Point>> updateLists(List<List<Point>> listOLists, Point point) {
    boolean flag = false;
    for (List<Point> list : listOLists) {
      if (isValid(list, point)) {
        list.add(point);
        flag = true;
      }
    }
    if (!flag) {
      List<Point> list = new ArrayList<>();
      list.add(point);
      listOLists.add(list);
    }
    return listOLists;
  }

  /**
   * Check in a list if exist any element with distance 1 to Point
   */
  private boolean isValid(List<Point> list, Point point) {
    for (Point eachPoint : list) {
      if (eachPoint.isDistanceValid(point)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Eliminate Duplicate Coordinates from List
   */
  private List<List<Point>> eliminateDuplicates(List<List<Point>> listOLists,
      List<Point> adjacentCells) {
    int totalElements = this.getTotalElements(listOLists);
    while (totalElements > adjacentCells.size()) {
      for (Point point : adjacentCells) {
        this.removeDuplicatePoint(listOLists, point);
      }
      totalElements = this.getTotalElements(listOLists);
    }
    return listOLists;
  }

  /**
   * Return number of elements from all lists
   */
  private int getTotalElements(List<List<Point>> listOLists) {
    int totalElements = 0;
    for (List<Point> list : listOLists) {
      totalElements = list.size() + totalElements;
    }
    return totalElements;
  }

  /**
   * Remove point from the first list
   */
  private void removeDuplicatePoint(List<List<Point>> listOLists, Point point) {
    boolean flag = true;
    if (occurrence(listOLists, point) > 1) {
      int aux = 0;
      while (flag) {
        List<Point> list = listOLists.get(aux);
        if (list.contains(point)) {
          list.remove(point);
          flag = false;
        }
        aux = aux + 1;
      }
    }
  }

  /**
   * Retrieve number of occurrences for a Point in all Lists
   *
   * @return number of occurrencess
   */
  private int occurrence(List<List<Point>> listOLists,
      Point point) {
    int occurrence = 0;
    for (List<Point> list : listOLists) {
      for (Point point1 : list) {
        if (point1.equals(point)) {
          occurrence++;
        }
      }
    }
    return occurrence;
  }

  /**
   * Remove List with 1 or 0 elements
   */
  private List<List<Point>> cleanLists(List<List<Point>> listOLists) {
    List<List<Point>> cleanLists = new ArrayList<>();
    for (List<Point> list : listOLists) {
      if (list.size() > 1) {
        cleanLists.add(list);
      }
    }
    return cleanLists;
  }


}
