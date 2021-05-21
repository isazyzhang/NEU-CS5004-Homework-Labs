package problem1;

/**
 * Customized Exception class: cannot book lunch/dinner anymore because time slot of the given day
 * is occupied.
 * @author Zu Yu Zhang
 */

public class TimeSlotOccupiedException extends Exception {
  public TimeSlotOccupiedException(){
    super("Event booking was unsuccessful; no more place for today.");
  }

}
