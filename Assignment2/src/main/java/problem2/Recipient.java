package problem2;

/**
 * This class represents a recipient of the mails in the package lockers.
 * @author Zu Yu Zhang
 */
public class Recipient {

  private String firstName;
  private String lastName;
  private String email;

  /**
   * Creates a new Recipient object initialized with first and last names and Email address.
   * @param firstName first name of the recipient
   * @param lastName last name of the recipient
   * @param email Email address of the recipient
   */
  public Recipient(String firstName, String lastName, String email){
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Gets the first name of the recipient.
   * @return recipient's first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Sets the first name of the recipient
   * @param firstName new first name of the recipient
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name of the recipient.
   * @return recipient's last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Sets the last name of the recipient
   * @param lastName new last name of the recipient
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the Email address of the recipient
   * @return recipient's Email address
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the Email address of the recipient
   * @param email new Email address of the recipient
   */
  public void setEmail(String email) {
    this.email = email;
  }
}
