package problem2;

/**
 * Customized Exception class: cannot pick up a Mail item, because the recipient's information
 * doesn't match with that on the mail.
 * @author Zu Yu Zhang
 */
public class IncorrectRecipientException extends Exception{
  public IncorrectRecipientException() {
    super("Cannot pick up mail. Recipient's information doesn't match with record.");
  }
}
