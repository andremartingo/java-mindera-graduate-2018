import java.util.List;
import javax.jws.WebParam.Mode;
import utils.FileManager;
import utils.Importer;

public class Main {

  public static int[][] matrix = new int[][]{
      {0, 0, 0, 1, 0, 0, 1, 1},
      {0, 0, 1, 1, 1, 0, 1, 1},
      {0, 0, 0, 0, 0, 0, 1, 0},
      {0, 0, 0, 1, 0, 0, 1, 1},
      {0, 0, 0, 1, 0, 0, 1, 1}
  };

  public static int[][] matrix3 = new int[][]{
      {0, 0, 0, 1, 0, 0, 1, 1},
      {0, 0, 1, 1, 1, 0, 1, 1},
      {0, 1, 1, 0, 0, 0, 1, 0},
      {0, 0, 0, 1, 0, 0, 1, 1},
      {0, 0, 0, 1, 0, 0, 1, 1}
  };

  public static void main(String[] args) {

    //Protects the program to have an Array Out of Bounds Exception if nothing is passed as argument
    if (args.length > 0) {
      //Set the Path to the file to be read on the Program Run Command
      String path = args[0];
      //Convert JSON file to String
      FileManager fileManager = new FileManager();
      List<String> listMatrix = fileManager.readFile(path);
      System.out.println(
          "Input File Processed!!\n");
      //Convert String to Java Matrix
      Importer importer = new Importer();
      int[][] matrix = importer.importMatrix(listMatrix);
      //Calculate Adjacent Cells
      Model brain = new Model(matrix);
      List<List<Point>> result = brain.labelMatrix();
      result.toString();
    } else {
      System.out.println("Please set the path for the Input File as Program Argument");
    }
    Model brain = new Model(matrix);
    List<List<Point>> result = brain.labelMatrix();
    printList(result);

  }

  private static void printList(List<List<Point>> result) {
    for (List<Point> list : result) {
      System.out.print(list);
      System.out.println("\n");
    }
  }
}