package edu.brown.cs.student.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Class that handles parsing a CSV file.
 */
public class ParseCSV {

  /**
   * Field that stores a Hashmap from star names to Stars.
   */
  private final HashMap<String, Star> stars = new HashMap<>();

  /**
   * Constructor for ParseCSV.
   * @param inputFile - a string that represents the path to the file
   */
  public ParseCSV(String inputFile) {

    // Try with resources to open a buffered reader
    try (BufferedReader bReader = new BufferedReader(new FileReader(inputFile))) {

      try {
        // Read the top line of the CSV
        String topLine = bReader.readLine();
        // Check that the CSV matches the proper format
        if (!topLine.equals("StarID,ProperName,X,Y,Z")) {
          throw new IllegalArgumentException();
        }

        // Loop over the lines of the CSV
        String current = bReader.readLine();
        while (current != null) {

          // Split the line into a string array
          String[] line = current.split(",");

          // If the star doesn't have a name, create one using the Star ID
          if (line[1].isEmpty()) {
            line[1] = "Star ID: " + line[0];
          }

          // Create a new Star based on the information in the line
          Star newStar =
              new Star(line[0], Double.parseDouble(line[2]), Double.parseDouble(line[3]),
                  Double.parseDouble(line[4]));

          // Put the new star into the hashmap
          stars.put(line[1], newStar);

          // Read the next line
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

  /**
   * Method to retrieve the hashmap created during parsing.
   * @return - a hashmap from star names to Stars, created during parsing
   */
  public HashMap<String, Star> getStars() {
    return this.stars;
  }
}
