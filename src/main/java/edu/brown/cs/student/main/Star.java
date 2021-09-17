package edu.brown.cs.student.main;

public class Star {

  private final String starID;
  private final double xC;
  private final double yC;
  private final double zC;

  public Star(String id, double x, double y, double z) {
    this.starID = id;
    this.xC = x;
    this.yC = y;
    this.zC = z;
  }

  public double getXC() {
    return this.xC;
  }

  public double getYC() {
    return this.yC;
  }

  public double getZC() {
    return this.zC;
  }

  public double dist(double x, double y, double z) {
    return Math.sqrt((this.xC - x) * (this.xC - x) + (this.yC - y) * (this.yC - y)
        + (this.zC - z) * (this.zC - z));
  }

  @Override
  public String toString() {
    return this.starID;
  }

  public Boolean equals(Star s) {
    return this.starID.equals(s.starID) && this.xC == s.xC && this.yC == s.yC && this.zC == s.zC;
  }
}
