package problem2;
import java.util.Objects;

/**
 * This class represents an Item in the library's collection; this is an abstract class so it cannot
 * be instantiated directly; other specific kinds of items will extend this class.
 * @author Zu Yu Zhang
 */
public abstract class Item {

  /**
   * The Item's Creator. Can be Author, Band, or RecordingArtist.
   */
  private Creator creator;
  /**
   * The Item's title.
   */
  private String title;
  /**
   * The year the item was released or published.
   */
  private int year;

  /**
   * Creates a new Item object.
   *
   * @param creator the Item's creator
   * @param title the Item's title
   * @param year the Item's published year
   */
  public Item(Creator creator, String title, int year){
    this.creator = creator;
    this.title = title;
    this.year = year;
  }

  /**
   * Gets the Item's Creator
   *
   * @return the Creator of the Item
   */
  public Creator getCreator() {
    return this.creator;
  }

  /**
   * Gets the Item's title.
   *
   * @return the title of the Item
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Gets the Item's publish year.
   *
   * @return the publishing year of the Item
   */
  public int getYear() {
    return this.year;
  }

  /**
   * This method takes in a Creator, and checks whether he or she is the Creator of this Item.
   * Will be implemented by child classes.
   *
   * @param creator the creator for whom we want to check if he/she has ownership of this item
   * @return whether the given creator produced this given item
   */
  public abstract boolean itemCreatedBy(Creator creator);

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    Item item = (Item) o;
    return year == item.year &&
        creator.equals(item.creator) &&
        title.equals(item.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creator, title, year);
  }

  @Override
  public String toString() {
    return this.creator.toString() +
        "Title: " + this.title +
        " Published Year: " + this.year;
  }
}
