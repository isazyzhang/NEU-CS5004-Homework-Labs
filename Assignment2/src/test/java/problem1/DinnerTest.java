package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DinnerTest {

  Dinner valid;

  @Before
  public void setUp() throws Exception {
    valid = new Dinner("Amy", 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorExceptionTest(){
    Dinner invalid = new Dinner("Amy", -1000);
  }

  @Test
  public void getClientName() {
    assertEquals("Amy", valid.getClientName());
  }

  @Test
  public void getNumAttendees() {
    assertEquals(15, valid.getNumAttendees());
  }

  @Test
  public void getNonVegetarian() {
    assertEquals(12,valid.getNonVegetarian());
  }

  @Test
  public void getVegetarian() {
    assertEquals(3, valid.getVegetarian());
  }

  @Test
  public void setClientName() {
    valid.setClientName("Emmy");
    assertEquals("Emmy",valid.getClientName());
  }

  @Test
  public void setNumAttendees() {
    valid.setNumAttendees(20);
    assertEquals(20, valid.getNumAttendees());
    //number of entrees should also be changed
    assertEquals(16, valid.getNonVegetarian());
    assertEquals(4, valid.getVegetarian());
  }

  @Test(expected=IllegalArgumentException.class)
  public void invalidChangeAttendees(){
    valid.setNumAttendees(100);
  }
}