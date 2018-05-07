import java.util.List;
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

//    //Protects the program to have an Array Out of Bounds Exception if nothing is passed as argument
//    if (args.length > 0) {
//      //Set the Path to the file to be read on the Program Run Command
//      String path = args[0];
//      //Convert JSON file to String
//      FileManager fileManager = new FileManager();
//      List<String> listMatrix = fileManager.readFile(path);
//      System.out.println(
//          "Input File Processed!!\n");
//      //Convert String to Java Matrix
//      Importer importer = new Importer();
//      int[][] matrix = importer.importMatrix(listMatrix);
//      //Calculate Adjacent Cells
//      Brain brain = new Brain(matrix);
//      List<List<Point>> result = brain.calculate();
//      printList(result);
//    } else {
//      System.out.println("Please set the path for the Input File as Program Argument");
//    }
    int[][] matrix2 = new int[5][5];
    for (int row =0; row < matrix2.length; row++){
      for(int col=0 ; col < matrix2.length; col++){
        matrix2[row][col] = 1;
      }
    }

    Model model = new Model(matrix);
    model.labelMatrix();
    model.print();
    model.printHashmap();

  }

    private static void printList(List<List<Point>> result) {
    for (List<Point> list : result) {
      System.out.println(list);
      System.out.println("\n");
    }
  }
}