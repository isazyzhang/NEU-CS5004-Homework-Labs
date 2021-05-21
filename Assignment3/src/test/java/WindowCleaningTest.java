import static org.junit.Assert.*;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import org.junit.Before;
import org.junit.Test;

public class WindowCleaningTest {
  private WindowCleaning small;
  private WindowCleaning medium;
  private WindowCleaning mediumLessFloors;
  private WindowCleaning large;
  private String description = "address: 777 Westlake, size: SMALL, monthly: false, " +
      "previous services: 29, total price: 42.0";
  private WindowCleaning small2;

  @Before
  public void setUp() throws Exception {
    small = new WindowCleaning("777 Westlake", PropertySize.SMALL, false,
        29, 2);
    medium = new WindowCleaning("777 Westlake", PropertySize.MEDIUM, false,
        29, 2);
    large = new WindowCleaning("777 Westlake", PropertySize.LARGE, false,
        29, 2);
    small2 = new WindowCleaning("777 Westlake", PropertySize.SMALL, false,
        29, 2);
    mediumLessFloors = new WindowCleaning("777 Westlake", PropertySize.MEDIUM,
        false, 29, 1);

  }

  @Test(expected = FloorsExceededException.class)
  public void constructorExceptionTest() throws FloorsExceededException {
    WindowCleaning invalid = new WindowCleaning("225 Terry Ave.",
        PropertySize.SMALL, false, 19, 4);
  }

  @Test
  public void calculatePrice() {
    assertEquals(42.0, small.calculatePrice(), 0.0);
    assertEquals(84.0, medium.calculatePrice(),0.0);
    assertEquals(168.0, large.calculatePrice(), 0.0);
    assertEquals(80.0, mediumLessFloors.calculatePrice(), 0.0);
  }

  @Test
  public void testEquals() {
    assertTrue(small.equals(small));
    assertFalse(small.equals(null));
    assertFalse(small.equals(description));
    assertTrue(small.equals(small2));
    assertFalse(large.equals(small));
  }

  @Test
  public void testHashCode() {
    assertTrue(small.hashCode() == small2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(description, small.toString());
  }
}