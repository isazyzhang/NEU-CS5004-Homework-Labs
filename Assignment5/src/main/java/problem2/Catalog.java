package problem2;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is used to store a collection of all the items in the library.
 * @author  Zu Yu Zhang
 */
public class Catalog {

  private ArrayList<Item> collectionItems;

   /**
   * Construct a new empty catalog (i.e. instantiating without specifying the items in the
   * collection.
   */
  public Catalog(){
    this.collectionItems = new ArrayList<Item>();
  }

  /**
   * Constructs a catalog instantiated with the items in the collection.
   *
   * @param items collection of items in the catalog
   */
  public Catalog(ArrayList<Item> items){
    this.collectionItems = items;
  }

  /**
   * Gets the items in the collection
   *
   * @return the items currently in the collection
   */
  public ArrayList<Item> getCollectionItems() {
    return this.collectionItems;
  }

  /**
   * Adds a new Item to the collection
   * @param item the Item that we want to add to the collection
   * @throws ItemAlreadyPresentException if the Item is already in the collection
   */
  public void addToCollection(Item item) throws ItemAlreadyPresentException {
    // add only if the current collection does not contain the same Item yet
    if(!this.collectionItems.contains(item)) {
      this.collectionItems.add(item);
    }else{
      throw new ItemAlreadyPresentException();
    }
  }

  /**
   * Removes an Item from the collection
   * @param item the item that we want to remove
   * @throws EmptyCollectionException If user attempts to remove items from an empty catalog
   * @throws ItemNotInCollectionException If the user attempts to remove an Item that is not in the
   * catalog's collection
   */
  public void removeFromCollection(Item item)
      throws EmptyCollectionException, ItemNotInCollectionException {
    // If there is no item in the collection and we try to remove, should throw Exception.
    if(this.collectionItems.isEmpty()){
      throw new EmptyCollectionException();
    }
    // If the specified item is not in the collection, should throw Exception.
    if(!this.collectionItems.contains(item)){
      throw new ItemNotInCollectionException();
    }else {
      this.collectionItems.remove(item);
    }
  }

  /**
   * This method retrieves and returns all items in the catalog, regardless of type, that have a
   * title containing the keyword. The search should be case-insensitive.
   *
   * @param keyword search for items whose title contains this keyword
   * @return all items in the catalog whose title contains the keyword
   */
  public ArrayList<Item> search(String keyword){
    ArrayList<Item> hasKeyword = new ArrayList<Item>();
    for(Item eachItem: this.collectionItems){
      if(eachItem.getTitle().toLowerCase().contains(keyword.toLowerCase())){
        hasKeyword.add(eachItem);
      }
    }
    return hasKeyword;
  }

  /**
   * This method retrieves and returns all items in the catalog that have an exact match for the
   * given author. As only Books have authors, it is expected that the collection returned will not
   * contain any Music.
   *
   * @param author search for Books written by this Author
   * @return all Books written by the given Author
   */
  public ArrayList<Item> search(Author author){
    ArrayList<Item> booksByThisAuthor = new ArrayList<Item>();
    for(Item eachItem: this.collectionItems){
      if(eachItem.getCreator().sameCreator(author)){
        booksByThisAuthor.add(eachItem);
      }
    }
    return booksByThisAuthor;
  }

  /**
   * This method retrieves and returns all items in the catalog that have an exact match for the
   * given artist. As only Music items have RecordingArtists, it is expected that the collection
   * returned will not contain any Books.The artist may the sole creator of the Music or one member
   * of a Band.
   *
   * @param artist search for Musics produced by this artist
   * @return all musics created by this artist
   */
  public ArrayList<Item> search(RecordingArtist artist){
    ArrayList<Item> musicByThisArtist = new ArrayList<Item>();
    for(Item eachItem: this.collectionItems){
      if(eachItem.getCreator().sameCreator(artist)){
        musicByThisArtist.add(eachItem);
      }
    }
    return musicByThisArtist;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Catalog)) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return getCollectionItems().equals(catalog.getCollectionItems());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCollectionItems());
  }

  @Override
  public String toString() {
    String itemsDescription = "";
    for(Item item: this.collectionItems){
      itemsDescription += item.toString() + "\n";
    }
    return "Catalog: " + itemsDescription;

  }
}
