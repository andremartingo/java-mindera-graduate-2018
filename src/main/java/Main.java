import java.util.List;
import utils.FileManager;
import utils.Importer;

public class Main {


  public static void main(String[] args) {


    String path = "src/matrix.json";
    FileManager fileManager = new FileManager();
    List<String> listMatrix = fileManager.readFile(path);
    Importer importer = new Importer();
    int [][] matrix = importer.importMatrix(listMatrix);
    Brain brain = new Brain(matrix);
    List<List<Point>> result = brain.calculate();
    System.out.println(result);

//    //Protects the program to have an Array Out of Bounds Exception if nothing is passed as argument
//    if(args.length>0) {
//      String path = args[0];
//
//      //Just set the Path to the file to be read on the Program Run Command
//      fileManager.readFile(path);
//
//      mars.init(path);
//      System.out.println("Input File Processed!!\nYou can check the Log from the Rovers right next to your Input File.\nOVER AND OUT!!");
//    }
//    else {
//      System.out.println("Please set the path for the Input File as Program Argument");
//    }

  }
}