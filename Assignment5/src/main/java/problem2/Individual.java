package problem2;

import java.util.Objects;

/**
 * This class represents an Individual which is the artist who created a given Item in the library
 * collection; can be either an Author or a RecordingArtist.
 * @author Zu Yu Zhang
 */
public abstract class Individual extends Creator {

  private String firstName;
  private String lastName;

  /**
   * Constructs a new Individual instantiated with first name and last name.
   *
   * @param firstName the Individual's first name
   * @param lastName  the Individual's last name
   */
  public Individual(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets the Individual's first name.
   *
   * @return first name of the Individual
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Gets the Individual's last name.
   *
   * @return last name of the Individual
   */
  public String getLastName() {
    return this.lastName;
  }


  /**
   * This method checks whether the Individual passed into the function is the same as the current
   * Individual.
   *
   * @param creator the Individual for whom we want to check for equivalency
   * @return whether the two Individuals are the same
   */
  @Override
  public boolean sameCreator(Creator creator) {
    return this.equals(creator);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Individual)) {
      return false;
    }
    Individual that = (Individual) o;
    return getFirstName().equals(that.getFirstName()) &&
        getLastName().equals(that.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName());
  }

  @Override
  public String toString() {
    return this.firstName + " " + this.lastName + " ";
  }
}