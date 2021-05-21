import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingTest {
  private Painting house1;
  private String description = "address: 222 Terry Ave., size: LARGE, monthly: true, " +
      "previous services: 0, number of pets: 0, total price: 1728.0";
  private Painting house2;
  private Painting house3;
  private Painting house4;
  private Painting house5;
  private Painting house6;

  @Before
  public void setUp() throws Exception {
    house1 = new Painting("222 Terry Ave.", PropertySize.LARGE, true,
        0, 0);
    house2 = new Painting("222 Terry Ave.", PropertySize.MEDIUM, true,
        0, 0);
    house3 = new Painting("222 Terry Ave.", PropertySize.SMALL, true,
        0, 0);
    house4 = new Painting("222 Terry Ave.", PropertySize.LARGE, true,
        0, 0);
    house5 = new Painting("222 Terry Ave.", PropertySize.LARGE, true,
        1, 0);
    house6 = new Painting("22 Terry Ave.", PropertySize.LARGE, true,
        1, 0);
  }

  @Test
  public void calculatePrice() {
    assertEquals(1728.0, house1.calculatePrice(), 0.0);
    assertEquals(1152.0, house2.calculatePrice(), 0.0);
    assertEquals(1152.0, house3.calculatePrice(), 0.0);
  }

  @Test
  public void testEquals() {
    assertTrue(house1.equals(house1));
    assertFalse(house1.equals(null));
    assertFalse(house1.equals(description));
    assertTrue(house1.equals(house4));
    assertFalse(house1.equals(house2));
    assertFalse(house4.equals(house5));
    assertFalse(house5.equals(house6));
  }

  @Test
  public void testHashCode() {
    assertTrue(house1.hashCode() == house4.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(description, house1.toString());
  }
}