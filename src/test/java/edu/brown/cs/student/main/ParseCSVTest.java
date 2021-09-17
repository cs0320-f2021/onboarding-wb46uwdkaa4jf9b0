package edu.brown.cs.student.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.HashMap;

public class ParseCSVTest {

  @Test
  public void testParse() {
    ParseCSV parseCSV = new ParseCSV("data/stars/three-star.csv");
    HashMap<String, Star> output = parseCSV.getStars();
    HashMap<String, Star> expected = new HashMap<>();
    expected.put("Star One", new Star("1", 1, 0, 0));
    expected.put("Star Two", new Star("2", 2, 0, 0));
    expected.put("Star Three", new Star("3", 3, 0, 0));

    assertEquals(expected.size(), output.size());
    assertTrue(expected.get("Star One").equals(output.get("Star One")));
    assertTrue(expected.get("Star Two").equals(output.get("Star Two")));
    assertTrue(expected.get("Star Three").equals(output.get("Star Three")));
  }

}
