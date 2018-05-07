import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model implements Label {

  private int[][] matrix;
  private int label = 1;

  private HashMap<Integer, List<Integer>> conflicts = new HashMap<>();
  private HashMap<Integer, List<Point>> result = new HashMap<>();

  public Model(int[][] matrix) {
    this.matrix = matrix;
    conflicts.put(1, new ArrayList<>());
  }

  /**
   * Return Lists of Point
   */
  public List<List<Point>> labelMatrix() {
    updateFirstRow();
    for (int row = 1; row < matrix.length; row++) {
      updateRow(row);
    }
    updateGroups();
    mapGroups();
    return convertHashMapToList();
  }

  /**
   * Label First Row
   */
  private void updateFirstRow() {
    for (int col = 0; col < matrix[0].length; col++) {
      if (matrix[0][col] == 1) {
        if (isAdjacentLeft(0, col)) {
          matrix[0][col] = matrix[0][col - 1];
        } else {
          matrix[0][col] = label;
          conflicts.put(label, new ArrayList<>());
          label++;
        }
      }
    }
  }

  /**
   * Label Row Elements
   */
  private void updateRow(int row) {
    for (int col = 0; col < matrix[row].length; col++) {
      if (get(row, col) == 1) {
        if (existConflict(row, col)) {
          set(row, col, get(row, col - 1));
          continue;
        }
        if (isAdjacentLeft(row, col)) {
          set(row, col, get(row, col - 1));
        } else if (isAdjacentUp(row, col)) {
          set(row, col, get(row - 1, col));
        } else {
          set(row, col, label);
          conflicts.put(label, new ArrayList<>());
          label++;
        }
      }
    }
  }

  /**
   * Find Parent Label in Hashmap
   */
  private Integer findRoot(int root) {
    for (Integer key : conflicts.keySet()) {
      if (key == root) {
        return key;
      } else {
        List<Integer> values = conflicts.get(key);
        for (Integer val : values) {
          if (val == root) {
            return key;
          }
        }
      }
    }
    return 0;
  }

  /**
   * Check if a point is Adjacent on the Left side
   */
  private boolean isAdjacentLeft(int row, int col) {
    if (col - 1 < 0) {
      return false;
    }
    if (matrix[row][col - 1] > 0) {
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
    return (matrix[row][col + 1] > 0);
  }

  /**
   * Check if a point is Adjacent on the Bottom side
   */
  private boolean isAdjacentDown(int row, int col) {
    if (row + 1 >= matrix.length) {
      return false;
    }
    return (matrix[row + 1][col] > 0);
  }


  /**
   * Check if a point is Adjacent on the Up side
   */
  private boolean isAdjacentUp(int row, int col) {
    if (row - 1 < 0) {
      return false;
    }
    if (matrix[row - 1][col] > 0) {
      return true;
    }
    return false;
  }

  /**
   * Check if a point is Adjacent
   */
  private boolean isAdjacent(int row, int col) {
    if (matrix[row][col] > 0 && isAdjacentLeft(row, col)) {
      return true;
    }
    if (matrix[row][col] > 0 && isAdjacentUp(row, col)) {
      return true;
    }
    if (matrix[row][col] > 0 && isAdjacentRight(row, col)) {
      return true;
    }
    if (matrix[row][col] > 0 && isAdjacentDown(row, col)) {
      return true;
    }
    return false;
  }

  /**
   * Check if exist Label Conflicts between Left Point and Up Point
   */
  private boolean existConflict(int row, int col) {
    if (col - 1 < 0 || row - 1 < 0) {
      return false;
    }
    if (matrix[row - 1][col] > 0 && matrix[row][col - 1] > 0
        && matrix[row - 1][col] != matrix[row][col - 1]) {
      int root = findRoot(matrix[row - 1][col]);
      List<Integer> list = conflicts.get(root);
      list.add(matrix[row][col - 1]);
      return true;
    }
    return false;
  }


  /**
   * Update Matrix Numbers with Root Label
   */
  public void updateGroups() {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix.length; col++) {
        updateGroup(row, col);
      }
    }
  }

  /**
   * Find for each Number the Root Label
   */
  private void updateGroup(int row, int col) {
    for (Integer key : conflicts.keySet()) {
      List<Integer> values = conflicts.get(key);
      for (Integer val : values) {
        if (val == matrix[row][col]) {
          matrix[row][col] = key;
        }
      }
    }
  }

  /**
   * Add to HashMap all Adjacent Points
   */
  private void mapGroups() {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (isAdjacent(row, col)) {
          if (result.containsKey(matrix[row][col])) {
            List<Point> list = result.get(matrix[row][col]);
            list.add(new Point(row, col));
          } else {
            List<Point> list = new ArrayList<>();
            list.add(new Point(row, col));
            result.put(matrix[row][col], list);
          }
        }
      }
    }
  }

  /**
   * Convert HashMap to List
   */
  private List<List<Point>> convertHashMapToList() {
    List<List<Point>> resultList = new ArrayList<>();
    for (Integer key : result.keySet()) {
      resultList.add(result.get(key));
    }
    return resultList;
  }

  @Override
  public int get(int y, int x) {
    return matrix[y][x];
  }

  @Override
  public void set(int y, int x, int label) {
    matrix[y][x] = label;
  }
}