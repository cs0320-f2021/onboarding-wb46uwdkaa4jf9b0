package edu.brown.cs.student.main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Neighbor {

  private final HashMap<String, Star> starHashMap;
  private final int number;
  private final double xCoord;
  private final double yCoord;
  private final double zCoord;

  public Neighbor(HashMap<String, Star> hmap, int k, double x, double y, double z) {
    this.starHashMap = hmap;
    this.number = k;
    this.xCoord = x;
    this.yCoord = y;
    this.zCoord = z;
  }

  public LinkedList<Star> insert(Star e, LinkedList<Star> toSort) {
    if (!toSort.isEmpty()) {
      for (Star compare : toSort) {
        if (e.dist(xCoord, yCoord, zCoord) < compare.dist(xCoord, yCoord, zCoord)) {
          toSort.add(toSort.indexOf(compare), e);
          return toSort;
        }
      }
    }
    toSort.add(e);
    return toSort;
  }

  public LinkedList<Star> nearestNeighbors() {
    LinkedList<Star> neighbors = new LinkedList<>();

    if (this.number == 0) {
      return neighbors;
    }

    for (Star current : starHashMap.values()) {
      double distance = current.dist(xCoord, yCoord, zCoord);
      // make sure you aren't comparing the star to itself
      if (distance != 0.0) {
        // check if the neighbors array is full
        if (neighbors.size() == this.number) {
          double distToFurthest = neighbors.getLast().dist(xCoord, yCoord, zCoord);
          if (distance < distToFurthest) {
            insert(current, neighbors);
            neighbors.removeLast();
          } else if (distance == distToFurthest) {
            Random rand = new Random();
            if (rand.nextInt(2) == 0) {
              insert(current, neighbors);
              neighbors.removeLast();
            }
          }
        } else {
          // if the neighbors array is not full, fill the next open space and sort it.
          neighbors = insert(current, neighbors);
        }
      }
    }
    return neighbors;
  }
}

