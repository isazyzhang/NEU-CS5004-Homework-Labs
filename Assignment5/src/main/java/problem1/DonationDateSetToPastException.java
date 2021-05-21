package problem1;

/**
 * Customized Exception class. This exception is thrown when the user attempts to set a donation
 * date of a pledge to the past.
 * @author Zu Yu Zhang
 */
public class DonationDateSetToPastException extends Exception {

  public DonationDateSetToPastException(){
    super("Donation date cannot be set to the past");
  }

}
