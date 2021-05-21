package problem2;

/**
 * This class represents an Author of an item in the library collection.
 * @author Zu Yu Zhang
 */
public class Author extends Individual {

  /**
   * Constructs a new Author instantiated with first name and last name.
   *
   * @param firstName the Author's first name
   * @param lastName  the Author's last name
   */
  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return "Author: " + super.toString();
  }

}
