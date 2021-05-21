package problem1;

/**
 * This is a class which represents a Schedule that tracks the events booked for each meal on a
 * single day.
 * @author Zu Yu Zhang
 */

public class Schedule {

  private boolean lunchBooked;
  private boolean dinnerBooked;

  /**
   * Creates a new instance of Schedule, initialized as empty (no events booked yet)
   */
  public Schedule(){
    this.lunchBooked = false;
    this.dinnerBooked = false;
  }

  /**
   * Method for booking lunch.
   * @param clientName the client's name
   * @param numAttendees the number of attendees
   * @throws TimeSlotOccupiedException if the lunch time slot is already occupied
   */
  public void bookingLunch(String clientName, int numAttendees) throws TimeSlotOccupiedException {
    //can only book lunch if there is no other lunch event going on
    if(!this.lunchBooked){
      Lunch newLunch = new Lunch(clientName, numAttendees);
      this.lunchBooked = true;
    }else{
      throw new TimeSlotOccupiedException();
    }
  }

  /**
   * Method for booking dinner.
   * @param clientName the client's name
   * @param numAttendees the number of attendees
   * @throws TimeSlotOccupiedException if the dinner time slot is already occupied
   */
  public void bookingDinner(String clientName, int numAttendees) throws TimeSlotOccupiedException {
    //can only book dinner if there is no other dinner event going on
    if(!this.dinnerBooked){
      Dinner newDinner = new Dinner(clientName, numAttendees);
      this.dinnerBooked = true;
    }else{
      throw new TimeSlotOccupiedException();
    }
  }

  /**
   * Gets the lunch-booking status
   * @return whether the lunch booking is open
   */
  public boolean isLunchBooked() {
    return this.lunchBooked;
  }

  /**
   * Gets the dinner-booking status
   * @return whether the dinner booking is open
   */
  public boolean isDinnerBooked() {
    return this.dinnerBooked;
  }

}
