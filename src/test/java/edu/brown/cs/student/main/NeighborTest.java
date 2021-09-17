package edu.brown.cs.student.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.LinkedList;

public class NeighborTest {

  @Test
  public void testInsert() {
    ParseCSV parseCSV = new ParseCSV("data/stars/three-star.csv");
    Neighbor neighbor = new Neighbor(parseCSV.getStars(), 2, 0, 0, 0);
    LinkedList<Star> expected = new LinkedList<>();
    expected.add(parseCSV.getStars().get("Star One"));
    expected.add(parseCSV.getStars().get("Star Two"));
    expected.add(parseCSV.getStars().get("Star Three"));
    LinkedList<Star> output = neighbor.insert(parseCSV.getStars().get("Star Two"), new LinkedList<>());
    output = neighbor.insert(parseCSV.getStars().get("Star One"), output);
    output = neighbor.insert(parseCSV.getStars().get("Star Three"), output);

    assertEquals(expected, output);
  }

  @Test
  public void testNearestNeighbors() {
    ParseCSV parseCSV = new ParseCSV("data/stars/three-star.csv");
    Neighbor neighbor = new Neighbor(parseCSV.getStars(), 3, 0, 0, 0);
    LinkedList<Star> expected = new LinkedList<>();
    expected.add(parseCSV.getStars().get("Star One"));
    expected.add(parseCSV.getStars().get("Star Two"));
    expected.add(parseCSV.getStars().get("Star Three"));
    LinkedList<Star> output = neighbor.nearestNeighbors();

    assertEquals(expected, output);
  }
}
