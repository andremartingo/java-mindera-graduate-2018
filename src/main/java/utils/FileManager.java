package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

  private String filePath = "";

  public List<String> readFile(String filePath) {

    String line;
    List <String> lines = new ArrayList<>();

    //This is a simple File Reader

    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));


      while ((line = reader.readLine()) != null){
        lines.add(line);

      }
      reader.close();

      this.filePath = filePath;

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return lines;
  }

}
