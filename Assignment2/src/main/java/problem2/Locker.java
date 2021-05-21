package problem2;

/**
 * This class represents a Locker which stores Mail objects. Subclass of Item.
 * @author  Zu Yu Zhang
 */
public class Locker extends Item {

  private Mail mail;

  /**
   * Constructor for the Locker class.
   * @param width the locker's maximum width
   * @param height the locker's maximum height
   * @param depth the locker's maximum depth
   * @throws InvalidDimensionException if dimension(s) of locker do not meet the requirements
   */
  public Locker(int width, int height, int depth) throws InvalidDimensionException {
    super(width, height, depth);
    this.mail = null;
  }

  /**
   * Consumes a mail item and stores it in the Locker with two exceptions:
   * 1. if the locker is occupied
   * 2. the mail item exceeds the dimensions of the locker
   * @param mailWidth width of the Mail to be added
   * @param mailHeight height of the Mail to be added
   * @param mailDepth depth of the Mail to be added
   * @param recipient recipient of the Mail to be added
   * @throws LockerOccupiedException if the locker already contains another Mail item
   * @throws MailExceedsLockerDimensionException if the dimensions of the Mail exceeds those of
   * the locker
   * @throws InvalidDimensionException if the dimensions of the Mail do not meet the requirements
   */
  public void addMail(int mailWidth, int mailHeight, int mailDepth, Recipient recipient)
      throws LockerOccupiedException, MailExceedsLockerDimensionException, InvalidDimensionException {
    //check if the locker is already occupied
    if(this.mail != null){
      throw new LockerOccupiedException();
    }
    //check if the mail's dimensions do not exceed those of the locker
    if(mailWidth <= this.getWidth() && mailHeight <= this.getHeight()
        && mailDepth <= this.getDepth()){
      this.mail = new Mail(mailWidth, mailHeight, mailDepth, recipient);
    }else{
      throw new MailExceedsLockerDimensionException();
    }
  }

  /**
   * Removes and returns a Mail item from the locker under the following conditions:
   * 1. there is a mail item in the locker AND
   * 2. the recipient passed matches the recipient of the mail item
   * @param recipient the recipient specified by user
   * @return the Mail object belonging to the user-specified recipient
   * @throws EmptyLockerException if the locker is empty
   * @throws InvalidDimensionException if the Mail's dimensions do not meet the requirements
   * @throws IncorrectRecipientException if the recipient passed does not match the Mail's intended
   * recipient
   */
  public Mail pickupMail(Recipient recipient)
      throws EmptyLockerException, InvalidDimensionException, IncorrectRecipientException {
    //throws exception if there is no mail in the locker
    if(this.mail == null){
      throw new EmptyLockerException();
    }
    //check if the recipient matches
    if(this.isRightRecipient(recipient)){
      int pickedUpWidth = this.mail.getWidth();
      int pickedUpHeight = this.mail.getHeight();
      int pickedUpDepth = this.mail.getDepth();
      //remove the mail item from the locker by setting it to null
      this.mail = null;
      return new Mail(pickedUpWidth, pickedUpHeight, pickedUpDepth, recipient);
    }else{
      throw new IncorrectRecipientException();
    }
  }

  /**
   * Helper method to check whether the recipient specified by user matches the recipient indicated
   * on the mail.
   * @param recipient the user-specified recipient
   * @return whether the recipient specified by user matches the recipient indicated on the mail.
   */
  private boolean isRightRecipient(Recipient recipient){
    return (this.mail.getRecipient().equals(recipient));
  }

  /**
   * Gets the mail currently in locker (or null if locker is empty)
   * @return the mail currently in locker
   */
  public Mail getMail() {
    return this.mail;
  }
}
