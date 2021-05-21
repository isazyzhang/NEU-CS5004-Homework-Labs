package problem2;
import java.util.ArrayList;
import java.util.Objects;

public class Band extends Creator {

  private String bandName;
  private ArrayList<RecordingArtist> members;

  /**
   * Constructs a new Band.
   * @param bandName name of the band
   * @param members list of the members of the band
   */
  public Band(String bandName, ArrayList<RecordingArtist> members) {
    this.bandName = bandName;
    this.members = members;
  }

  /**
   * Gets the Band's name
   * @return name of the Band
   */
  public String getBandName() {
    return this.bandName;
  }

  /**
   * Gets the Band's members list.
   * @return the list of members of the Band.
   */
  public ArrayList<RecordingArtist> getMembers() {
    return this.members;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Band)) {
      return false;
    }
    Band band = (Band) o;
    return getBandName().equals(band.getBandName()) &&
        getMembers().equals(band.getMembers());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getBandName(), getMembers());
  }

  @Override
  public String toString() {
    return "Band: " + this.bandName;
  }

  /**
   * This method checks whether the recording artist passed in is a member of this band.
   *
   * @param creator check whether this recording artist is in the band
   * @return whether the given recording artist is a member of the band
   */
  @Override
  public boolean sameCreator(Creator creator) {
    if (this.members.contains(creator)) {
      return true;
    }
    return false;
  }
}
