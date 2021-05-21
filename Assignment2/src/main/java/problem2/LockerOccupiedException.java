package problem2;

/**
 * Customized Exception class: cannot add a Mail to a Locker, because the Locker already contains
 * another Mail object.
 * @author Zu Yu Zhang
 */

public class LockerOccupiedException extends Exception{
  public LockerOccupiedException(){
    super("This locker is occupied.");
  }
}
