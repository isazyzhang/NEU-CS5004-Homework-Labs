package problem2;

/**
 * Customized Exception class. Should be thrown when we try to remove an item that is not in the
 * collection.
 * @author  Zu Yu Zhang
 */
public class ItemNotInCollectionException extends Exception {

  public ItemNotInCollectionException(){
    super("No such Item in the Collection.");
  }
}
