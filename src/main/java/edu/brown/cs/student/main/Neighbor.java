package edu.brown.cs.student.main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Class that handles finding a Star's nearest neighbors.
 */
public class Neighbor {

  /**
   * Field to hold the star hashmap created during parsing.
   */
  private final HashMap<String, Star> starHashMap;

  /**
   * Field to hold the number of desired neighbors to look for.
   */
  private final int number;

  /**
   * Fields to hold the coordinates from which to calculate the distance to other stars.
   * x-coordinate, y-coordinate, z-coordinate, respectively
   */
  private final double xCoord;
  private final double yCoord;
  private final double zCoord;

  /**
   * Constructor for the Neighbor Class.
   * @param hmap - a hashmap containing star data
   * @param k - an integer representing the number of desired neighbors to look for
   * @param x - the x-coordinate from which to calculate distance
   * @param y - the y-coordinate from which to calculate distance
   * @param z - the z-coordinate from which to calculate distance
   */
  public Neighbor(HashMap<String, Star> hmap, int k, double x, double y, double z) {
    this.starHashMap = hmap;
    this.number = k;
    this.xCoord = x;
    this.yCoord = y;
    this.zCoord = z;
  }

  /**
   * Method to insert a Star into a sorted list, based on its distance to the target coordinates.
   * @param s - the star to insert
   * @param toSort - a sorted list of stars, based on minimum distance to xCoord, yCoord, and zCoord
   * @return - a new sorted list of stars, with the Star s inserted into it
   */
  public LinkedList<Star> insert(Star s, LinkedList<Star> toSort) {
    if (!toSort.isEmpty()) {
      for (Star compare : toSort) {
        if (s.dist(xCoord, yCoord, zCoord) < compare.dist(xCoord, yCoord, zCoord)) {
          toSort.add(toSort.indexOf(compare), s);
          return toSort;
        }
      }
    }
    toSort.add(s);
    return toSort;
  }

  /**
   * Method to find the nearest neighbors to a set of coordinates.
   * @return - a sorted list of stars, with the first star being closest and the last furthest from
   *           the coordinates xCoord, yCoord, zCoord.
   */
  public LinkedList<Star> nearestNeighbors() {
    // Initialize a new list of Stars (that will be sorted as Stars are added)
    LinkedList<Star> neighbors = new LinkedList<>();

    // If the user inputs 0 neighbors, return an empty list
    if (this.number == 0) {
      return neighbors;
    }

    // Otherwise, loop over all the stars in the star hashmap
    for (Star current : starHashMap.values()) {
      // store the distance to the current star
      double distance = current.dist(xCoord, yCoord, zCoord);
      // make sure you aren't comparing the star to itself
      if (distance != 0.0) {
        // check if we have the desired number of neighbors
        if (neighbors.size() == this.number) {
          // store the distance to the furthest star (the last one in the neighbors list)
          double distToFurthest = neighbors.getLast().dist(xCoord, yCoord, zCoord);
          // If the current star is closer than the furthest star, insert it into the neighbors
          //   list and remove the last element (to maintain the desired number of neighbors)
          if (distance < distToFurthest) {
            insert(current, neighbors);
            neighbors.removeLast();
          } else if (distance == distToFurthest) {
            // If two stars are the same distance, randomly decide which one gets to be on the list
            Random rand = new Random();
            if (rand.nextInt(2) == 0) {
              insert(current, neighbors);
              neighbors.removeLast();
            }
          }
        } else {
          // If we don't yet have the desired number of neighbors, insert the current star into
          // the list
          neighbors = insert(current, neighbors);
        }
      }
    }
    // Return the resultant list of neighbors
    return neighbors;
  }
}

