package utils;

import java.util.ArrayList;
import java.util.List;

public class Importer {

  public int [][] importMatrix(List<String> matrixFile) {
    List<String> newMatrix  = removeSpecialCharacters(matrixFile);
    int[][] matrix = this.convertListToMatrix(newMatrix);
    return matrix;

  }

  private List<String> removeSpecialCharacters(List<String> matrixFile) {
    List<String> newMatrix = new ArrayList<>();
    for(String line : matrixFile){
      line = line.replaceAll("[^\\d.]", "");
      if(line.length() > 0 ){
        newMatrix.add(line);
      }
    }
    return newMatrix;
  }

  private int[][] convertListToMatrix(List<String> matrixList){
    int [][] matrix = new int[matrixList.get(0).length()][matrixList.get(0).length()];
    int indexRow = 0;
    for(String row : matrixList){
      matrix = this.addRow(row,indexRow,matrix);
      indexRow++;
    }
    return matrix;
  }

  private int[][] addRow(String row, int indexRow, int[][] matrix) {
    String [] arr = row.split("");
    int column = 0;
    for(String ch : arr){
      matrix[indexRow][column] = Integer.parseInt(ch);
      column++;
    }
    return matrix;
  }
}