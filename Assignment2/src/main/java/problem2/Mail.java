package problem2;

/**
 * This class represents a Mail object in Locker. Subclass of Item.
 * @author Zu Yu Zhang
 */
public class Mail extends Item {

  private Recipient recipient;

  /**
   * Constructor for the Mail class.
   * @param width the mail's width
   * @param height the mail's height
   * @param depth the mail's depth
   * @param recipient the mail's recipient
   * @throws InvalidDimensionException if Mail object's dimension(s) do not meet the requirements
   */
  public Mail(int width, int height, int depth, Recipient recipient)
      throws InvalidDimensionException {
    super(width, height, depth);
    this.recipient = recipient;
  }

  /**
   * Gets the recipient of the mail
   * @return the recipient of the mail
   */
  public Recipient getRecipient() {
    return this.recipient;
  }

  /**
   * Sets the recipient of the mail
   * @param recipient new recipient of the mail
   */
  public void setRecipient(Recipient recipient) {
    this.recipient = recipient;
  }
}
