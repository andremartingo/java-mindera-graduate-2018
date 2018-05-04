package utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ImporterTest {

  @Test
  public void ensureCreate3GroupsWhenLastElementHaveConnectionWithFirstOne() {
    //Given a Matrix File
    List<String> matrixString = new ArrayList<>();
    matrixString.add("[");
    matrixString.add("[1,1],");
    matrixString.add("[1,1]");
    matrixString.add("]");
    //When
    Importer importer = new Importer();
    int [][] matrix = importer.importMatrix(matrixString);
    assertEquals(2,matrix[0].length);
    assertEquals(1,matrix[0][0]);
  }
}