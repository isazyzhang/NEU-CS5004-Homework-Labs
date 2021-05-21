package problem2;

/**
 * This class represents a Book in the library collection.
 * @author  Zu Yu Zhang
 */
public class Book extends Item {

  /**
   * Creates a new Book object.
   *
   * @param author the Book's creator, must be an Author.
   * @param title   the Book's title
   * @param year    the Book's published year
   */
  public Book(Author author, String title, int year) {
    super(author, title, year);
  }

  /**
   * This method takes in an Author, and checks whether it is the Author of this Book.
   *
   * @param creator the Author for whom we want to check if he/she has ownership of this Book
   * @return whether the Author wrote the given Book
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
