import static org.junit.Assert.*;

import java.security.PublicKey;
import org.junit.Before;
import org.junit.Test;

public class PlumbingTest {
  private Plumbing plumbing1;
  private Plumbing plumbing2;
  private Plumbing plumbing3;
  private Plumbing plumbing4;
  private String description = "address: 355 Amli, size: SMALL, monthly: true, " +
      "previous services: 7, number of employees required: 2, is the work complex: true, " +
      "total price: 420.0";
  private Plumbing plumbing5;
  private Plumbing plumbing6;
  private Plumbing plumbing7;
  private Plumbing plumbing8;
  @Before
  public void setUp() throws Exception {
    plumbing1 = new Plumbing("355 Amli", PropertySize.SMALL, true,
        7, 1, true);
    plumbing2 = new Plumbing("355 Amli", PropertySize.LARGE, true,
        7, 1, true);
    plumbing3 = new Plumbing("355 Amli", PropertySize.LARGE, true,
        7, 0, false);
    plumbing4 = new Plumbing("355 Amli", PropertySize.LARGE, true,
        7, 5, true);
    plumbing5 = new Plumbing("355 Amli", PropertySize.SMALL, true,
        7, 1, true);
    plumbing6 = new Plumbing("355 Amli", PropertySize.MEDIUM, false,
        7, 2, true);
    plumbing7 = new Plumbing("355 Amli", PropertySize.MEDIUM, false,
        7, 2, false);
    plumbing8 = new Plumbing("355 Amli", PropertySize.MEDIUM, false,
        7, 3, false);
  }

  @Test
  public void constructorTest1(){
    assertEquals(2, plumbing1.getNumEmployeesRequired());
  }

  @Test
  public void constructorTest2(){
    assertEquals(3, plumbing2.getNumEmployeesRequired());
  }

  @Test
  public void constructorTest3(){
    assertEquals(1, plumbing3.getNumEmployeesRequired());
  }

  @Test
  public void constructorTest4(){
    assertEquals(5, plumbing4.getNumEmployeesRequired());
  }

  @Test
  public void calculatePrice() {
    assertEquals(420.0, plumbing1.calculatePrice(), 0.0);
    assertEquals(420, plumbing6.calculatePrice(), 0.0);
  }

  @Test
  public void testEquals() {;
    assertTrue(plumbing1.equals(plumbing1));
    assertFalse(plumbing1.equals(null));
    assertFalse(plumbing1.equals(description));
    assertFalse(plumbing1.equals(plumbing2));
    assertTrue(plumbing1.equals(plumbing5));
    assertFalse(plumbing6.equals(plumbing7));
    assertFalse(plumbing7.equals(plumbing8));

  }

  @Test
  public void testHashCode() {
    assertTrue(plumbing1.hashCode() == plumbing5.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(description, plumbing1.toString());
  }
}