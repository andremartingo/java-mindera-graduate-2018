import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Model {


  private int[][] matrix;


  private int label = 1;
  public int conflict = 0;

  private HashMap<Integer, List<Integer>> hmap = new HashMap<>();

  public Model(int[][] matrix) {
    this.matrix = matrix;
    hmap.put(1, new ArrayList<>());
  }

  public void labelMatrix() {
    updateFirstRow();
    for (int row = 1; row < matrix.length; row++) {
      updateRow(row);
    }
    updateGroups();
  }

  public void updateRow(int row) {
    for (int col = 0; col < matrix[row].length; col++) {
      if (matrix[row][col] == 1) {
        if (existConflict(row, col)) {
          matrix[row][col] = matrix[row][col - 1];
          continue;
        }
        if (isAdjacentLeft(row, col)) {
          matrix[row][col] = matrix[row][col - 1];
        } else if (isAdjacentUp(row, col)) {
          matrix[row][col] = matrix[row - 1][col];
        } else {
          matrix[row][col] = label;
          hmap.put(label, new ArrayList<>());
          label++;
        }
      }
    }
  }

  public Integer findRoot(int root) {
    for (Integer key : hmap.keySet()) {
      if (key == root) {
        return key;
      } else {
        List<Integer> values = hmap.get(key);
        for (Integer val : values) {
          if (val == root) {
            return key;
          }
        }
      }
    }
    return 0;
  }

  public void updateFirstRow() {
    for (int col = 0; col < matrix[0].length; col++) {
      if (matrix[0][col] == 1) {
        if (isAdjacentLeft(0, col)) {
          matrix[0][col] = matrix[0][col - 1];
        } else {
          matrix[0][col] = label;
          hmap.put(label, new ArrayList<>());
          label++;
        }
      }
    }
  }

  public boolean isAdjacentLeft(int row, int col) {
    if (col - 1 < 0) {
      return false;
    }
    if (matrix[row][col - 1] > 0) {
      return true;
    }
    return false;
  }

  public boolean isAdjacentUp(int row, int col) {
    if (row - 1 < 0) {
      return false;
    }
    if (matrix[row - 1][col] > 0) {
      return true;
    }
    return false;
  }

  public boolean existConflict(int row, int col) {
    if (col - 1 < 0 || row - 1 < 0) {
      return false;
    }
    if (matrix[row - 1][col] > 0 && matrix[row][col - 1] > 0
        && matrix[row - 1][col] != matrix[row][col - 1]) {
      conflict++;
      int root = findRoot(matrix[row - 1][col]);
      List<Integer> list = hmap.get(root);
      list.add(matrix[row][col - 1]);
      return true;
    }
    return false;
  }

  public void printHashmap() {
    hmap.forEach((k, v) -> {
      System.out.print("Key : " + k + " Value : ");
      System.out.print(v.toString());
      System.out.print("\n");
    });
  }

  public void print() {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        System.out.print(matrix[row][col]);
      }
      System.out.print("\n");
    }
  }

  public void updateGroups() {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix.length; col++) {
        updateGroup(row, col);
      }
    }
  }

  public void updateGroup(int row, int col) {
    for (Integer key : hmap.keySet()) {
      List<Integer> values = hmap.get(key);
      for (Integer val : values) {
        if (val == matrix[row][col]) {
          matrix[row][col] = key;
        }
      }
    }
  }
}