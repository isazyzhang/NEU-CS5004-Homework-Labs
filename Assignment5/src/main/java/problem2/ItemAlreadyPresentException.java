package problem2;

/**
 * Customized Exception. Is thrown when we try to add an Item that is already in the collection.
 */
public class ItemAlreadyPresentException extends Exception{

  public ItemAlreadyPresentException(){
    super("Item in the Collection already. Duplicates are not allowed.");
  }

}
