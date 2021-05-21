package problem1;

/**
 * Customized Exception class. Should be thrown when user attempts to set the cancellation date of
 * a monthly donation to the past.
 * @author Zu Yu Zhang
 */
public class CancelDateInThePastException extends Exception {

  public CancelDateInThePastException(){
    super("Cannot set cancellation to the past");
  }
}
