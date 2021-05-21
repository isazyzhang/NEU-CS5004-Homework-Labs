package problem1;

/**
 * Customized Exception class. This exception is thrown when the user attempts to change the
 * donation date of a pledge after the pledge has occurred.
 * @author  Zu Yu Zhang
 */
public class DonationHasOccurredException extends Exception {

  public DonationHasOccurredException(){
    super("Donation has occurred already.");
  }

}
