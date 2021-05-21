package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScheduleTest {
  Schedule today;

  @Before
  public void setUp() throws Exception {
    today = new Schedule();
  }

  @Test
  public void isLunchBooked() {
    assertFalse(today.isLunchBooked());
  }

  @Test
  public void isDinnerBooked() {
    assertFalse(today.isDinnerBooked());
  }

  @Test
  public void bookingLunch() throws TimeSlotOccupiedException {
    today.bookingLunch("Melissa", 30);
    assertTrue(today.isLunchBooked());
  }

  @Test
  public void bookingDinner() throws TimeSlotOccupiedException {
    today.bookingDinner("Bob", 40);
    assertTrue(today.isDinnerBooked());
  }

  @Test(expected=TimeSlotOccupiedException.class)
  public void cannotBookLunch() throws TimeSlotOccupiedException {
    today.bookingLunch("Melissa", 20);
    today.bookingLunch("Hailee", 40);
  }

  @Test(expected=TimeSlotOccupiedException.class)
  public void cannotBookDinner() throws TimeSlotOccupiedException{
    today.bookingDinner("Mike", 10);
    today.bookingDinner("Egan", 45);
  }

}