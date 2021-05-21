import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElectricalTest {
  private Electrical elec1;
  private Electrical elec11;
  private Electrical elec2;
  private String description = "address: 555 Pontius, size: MEDIUM, monthly: true, " +
      "previous services: 19, number of employees required: 2, is the work complex: false, " +
      "total price: 450.0";

  @Before
  public void setUp() throws Exception {
    elec1 = new Electrical("555 Pontius", PropertySize.MEDIUM, true,
        19, 2,true);
    elec11 = new Electrical("555 Pontius", PropertySize.MEDIUM, true,
        19, 2,true);
    elec2 = new Electrical("555 Pontius", PropertySize.MEDIUM, true,
        19, 2,false);
  }


  @Test(expected = EmployeesExceededException.class)
  public void constructorExceptionTest() throws EmployeesExceededException {
    Electrical invalid = new Electrical("555 Pontius", PropertySize.MEDIUM,
        true, 19, 10,true);
  }

  @Test
  public void calculatePrice() {
    assertEquals(450.0, elec1.calculatePrice(), 0.0);
  }

  @Test
  public void testEquals() {
    assertTrue(elec2.equals(elec2));
    assertFalse(elec2.equals(null));
    assertFalse(elec2.equals(description));
    assertTrue(elec1.equals(elec11));
    //assertFalse(elec1.equals(elec2));
  }

  @Test
  public void testHashCode() {
    assertTrue(elec1.hashCode() == elec11.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(description, elec2.toString());
  }
}