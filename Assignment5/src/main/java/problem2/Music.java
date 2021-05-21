package problem2;

/**
 * This class represents a musical item stored in the library's collection.
 * @author  Zu Yu Zhang
 */
public class Music extends Item {

  /**
   * Creates a new Music object (where its Creator is a RecordingArtist).
   *
   * @param artist the Music's creator
   * @param title   the Music's title
   * @param year    the Music's published year
   */
  public Music(RecordingArtist artist, String title, int year) {
    super(artist, title, year);
  }

  /**
   * Creates a new Music object (where its Creator consists of a Band).
   *
   * @param band the Music's creator
   * @param title the Music's title
   * @param year the Music's published year
   */
  public Music(Band band, String title, int year){
    super(band, title, year);
  }

  /**
   * This method takes in a Creator, and checks whether it is the creator of this Music.
   *
   * @param creator the creator for whom we want to check if he/she has ownership of this Music
   * @return whether the creator produced the given Music
   */
  @Override
  public boolean itemCreatedBy(Creator creator) {
    return this.getCreator().sameCreator(creator);
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
    return super.toString();
  }

}
