package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LunchTest {

  Lunch valid;

  @Before
  public void setUp() throws Exception {
    valid = new Lunch("Isabella", 80);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorExceptionTest() {
    Lunch invalid = new Lunch("Isabella", 100);
  }

  @Test
  public void getClientName() {
    assertEquals("Isabella", valid.getClientName());
  }

  @Test
  public void setClientName() {
    valid.setClientName("Michelle");
    assertEquals("Michelle", valid.getClientName());
  }

  @Test
  public void getNumAttendees() {
    assertEquals(80, valid.getNumAttendees());
  }

  @Test
  public void getNumSandwiches(){
    assertEquals(84, valid.getNumSandwiches());
  }
  @Test
  public void setNumAttendees() {
    valid.setNumAttendees(70);
    assertEquals(70, valid.getNumAttendees());
    //number of sandwiches should also be changed
    assertEquals(74, valid.getNumSandwiches());
  }

  @Test(expected=IllegalArgumentException.class)
  public void invalidChangeAttendees(){
    valid.setNumAttendees(-10);
  }
}