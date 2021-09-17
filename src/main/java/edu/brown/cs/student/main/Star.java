package edu.brown.cs.student.main;

/**
 * Class to hold information about a Star.
 */
public class Star {

  /**
   * Fields that hold information about the star.
   * StarID, x-coordinate, y-coordinate, z-coordinate, respectively
   */
  private final String starID;
  private final double xC;
  private final double yC;
  private final double zC;

  /**
   * Constructor for a Star.
   * @param id - the Star's ID
   * @param x - the Star's x-coordinate
   * @param y - the Star's y-coordinate
   * @param z - the Star's z-coordinate
   */
  public Star(String id, double x, double y, double z) {
    this.starID = id;
    this.xC = x;
    this.yC = y;
    this.zC = z;
  }

  /**
   * Method to retrieve the Star's x-coordinate.
   * @return - this Star's x-coordinate, a double
   */
  public double getXC() {
    return this.xC;
  }

  /**
   * Method to retrieve the Star's y-coordinate.
   * @return - this Star's y-coordinate, a double
   */
  public double getYC() {
    return this.yC;
  }

  /**
   * Method to retrieve the Star's z-coordinate.
   * @return - this Star's z-coordinate, a double
   */
  public double getZC() {
    return this.zC;
  }

  /**
   * Method to calculate the distance from this star to a set of coordinates.
   * @param x - the x-coordinate of the target
   * @param y - the y-coordinate of the target
   * @param z - the z-coordinate of the target
   * @return - the distance from this star to the coordinates x,y,z, defined as the square root of
   *           the sum of the squares of the differences between the respective coordinates.
   */
  public double dist(double x, double y, double z) {
    return Math.sqrt((this.xC - x) * (this.xC - x) + (this.yC - y) * (this.yC - y)
        + (this.zC - z) * (this.zC - z));
  }

  /**
   * Method that prints the Star's ID as a string.
   * @return - this Star's ID, a string
   */
  @Override
  public String toString() {
    return this.starID;
  }

  /**
   * Method that compares this star to another star s.
   * @param s - the star to be compared with
   * @return - a boolean indicating whether this Star and the star s have the same ID
   *            and coordinates.
   */
  public Boolean equals(Star s) {
    return this.starID.equals(s.starID) && this.xC == s.xC && this.yC == s.yC && this.zC == s.zC;
  }
}
