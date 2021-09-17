package edu.brown.cs.student.main;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StarTest {

  @Test
  public void testGetXC() {
    Star star = new Star("0", -1, 0, 1);
    double output = star.getXC();
    assertEquals(-1,output,0.1);
  }

  @Test
  public void testGetYC() {
    Star star = new Star("1", -1, 0, 1);
    double output = star.getYC();
    assertEquals(0,output,0.1);
  }

  @Test
  public void testGetZC() {
    Star star = new Star("2", -1, 0, 1);
    double output = star.getZC();
    assertEquals(1,output,0.1);
  }

  @Test
  public void testDist() {
    Star star = new Star("3", 1, 0, -1);
    double output = star.dist(-50, 100, 0);
    assertEquals(112.25863, output, 0.00001);
  }

  @Test
  public void testToString() {
    Star star = new Star("4", 1, 0, -1);
    String output = star.toString();
    assertEquals("4", output);
  }
}
