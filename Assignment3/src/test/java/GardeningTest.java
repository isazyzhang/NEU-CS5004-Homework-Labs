import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GardeningTest {
  private Gardening small;
  private Gardening medium;
  private Gardening large;
  private String description = "address: 100 Mercer, size: MEDIUM, monthly: false, " +
      "previous services: 8, total price: 180.0";
  private Gardening medium2;
  private Gardening large2;

  @Before
  public void setUp() throws Exception {
    medium  = new Gardening("100 Mercer", PropertySize.MEDIUM, false,
        8);
    small = new Gardening("100 Mercer", PropertySize.SMALL, false,
        8);
    large = new Gardening("100 Mercer", PropertySize.LARGE, false,
        8);
    medium2 = new Gardening("100 Mercer", PropertySize.MEDIUM, false,
        8);
    large2 = new Gardening("100 Mercer", PropertySize.LARGE, true,
        8);

  }

  @Test
  public void calculatePrice() {
    assertEquals(180.0, medium.calculatePrice(), 0.0);
    assertEquals(100.0, small.calculatePrice(), 0.0);
    assertEquals(340, large.calculatePrice(), 0.0);
  }

  @Test
  public void testEquals() {
    assertTrue(medium.equals(medium));
    assertFalse(medium.equals(null));
    assertFalse(medium.equals(description));
    assertTrue(medium.equals(medium2));
    assertFalse(medium.equals(large));
    assertFalse(large.equals(large2));
  }

  @Test
  public void testHashCode() {
    assertTrue(medium.hashCode() == medium2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(description, medium.toString());
  }
}