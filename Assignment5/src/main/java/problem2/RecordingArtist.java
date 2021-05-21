package problem2;

/**
 * This class represents a RecordingArtist.
 * @author  Zu Yu Zhang
 */
public class RecordingArtist extends Individual{

  /**
   * Constructs a new RecordingArtist instantiated with first name and last name.
   *
   * @param firstName the RecordingArtist's first name
   * @param lastName  the RecordingArtist's last name
   */
  public RecordingArtist(String firstName, String lastName) {
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
    return "Recording Artist: " + super.toString();
  }

}
