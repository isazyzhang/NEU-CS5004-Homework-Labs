package problem2;

/**
 * Customized Exception class: occurs when user attempts to pick up mails from an empty locker.
 * @author Zu Yu Zhang
 */
public class EmptyLockerException extends Exception {
  public EmptyLockerException() {
    super("Cannot pick up mail. Locker is empty.");
  }
}
