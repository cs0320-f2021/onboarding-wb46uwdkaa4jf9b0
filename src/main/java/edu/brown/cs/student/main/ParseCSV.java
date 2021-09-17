package edu.brown.cs.student.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ParseCSV {

  // Hashmap from star names to stars
  private final HashMap<String, Star> stars = new HashMap<>();

  public ParseCSV(String inputFile) {

    try (BufferedReader bReader = new BufferedReader(new FileReader(inputFile))) {

      try {
        String topLine = bReader.readLine();
        if (!topLine.equals("StarID,ProperName,X,Y,Z")) {
          throw new IllegalArgumentException();
        }

        String current = bReader.readLine();
        while (current != null) {

          String[] line = current.split(",");

          if (line[1].isEmpty()) {
            line[1] = "Star ID: " + line[0];
          }

          Star newStar =
              new Star(line[0], Double.parseDouble(line[2]), Double.parseDouble(line[3]),
                  Double.parseDouble(line[4]));

          stars.put(line[1], newStar);

          current = bReader.readLine();
        }

      } catch (IllegalArgumentException e) {
        System.out.println("ERROR: Invalid CSV format");
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("ERROR: File not found");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("ERROR: There was an error processing the input");
    }
  }

  public HashMap<String, Star> getStars() {
    return this.stars;
  }
}
