import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleaningTest {
  private Cleaning myHouse;
  private Cleaning myHouse2;
  private String description = "address: 111 Bell St., size: SMALL, monthly: true, " +
      "previous services: 9, number of pets: 1, total price: 42.0";
  private Cleaning myHouseWithMorePets;
  private Cleaning mediumHouse;
  private Cleaning largeHouse;
  private Cleaning largeHouseMorePets;
  private Cleaning mediumHouseTwoPets;

  @Before
  public void setUp() throws Exception {
    myHouse = new Cleaning("111 Bell St.", PropertySize.SMALL, true,
        9, 1 );
    myHouse2 = new Cleaning("111 Bell St.", PropertySize.SMALL, true,
        9, 1 );
    myHouseWithMorePets = new Cleaning("111 Bell St.", PropertySize.SMALL,
        true, 9, 8 );
    mediumHouse = new Cleaning("111 Bell St.", PropertySize.MEDIUM, true,
        9, 1 );
    mediumHouseTwoPets = new Cleaning("111 Bell St.", PropertySize.MEDIUM, true,
        9, 2 );
    largeHouse = new Cleaning("111 Bell St.", PropertySize.LARGE, true,
        9, 1 );
    largeHouseMorePets = new Cleaning("111 Bell St.", PropertySize.LARGE,
        true, 9, 8 );
  }

  @Test
  public void calculatePrice() {
    assertEquals(42.0, myHouse.calculatePrice(), 0.0);
    assertEquals(84.0, mediumHouse.calculatePrice(), 0.0);
    assertEquals(168.0, largeHouse.calculatePrice(), 0.0);
    assertEquals(171.2, largeHouseMorePets.calculatePrice(), 0.001);
    assertEquals(84.0, mediumHouseTwoPets.calculatePrice(), 0.0);
  }

  @Test
  public void testEquals() {
    assertTrue(myHouse.equals(myHouse));
    assertFalse(myHouse.equals(null));
    assertFalse(myHouse.equals(description));
    assertTrue(myHouse.equals(myHouse2));
    assertFalse(myHouse.equals(myHouseWithMorePets));

  }

  @Test
  public void testHashCode() {
    assertTrue(myHouse.hashCode() == myHouse2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(description, myHouse.toString());
  }
}