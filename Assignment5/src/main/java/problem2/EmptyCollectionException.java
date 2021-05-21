package problem2;

/**
 * Customized Exception class. Throw this exception when trying to remove an item from an Empty
 * collection.
 * @author Zu Yu Zhang
 */
public class EmptyCollectionException extends Exception {

  public EmptyCollectionException(){
    super("No Items in the Collection.");
  }

}
