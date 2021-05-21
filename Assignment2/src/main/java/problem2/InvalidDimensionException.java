package problem2;

/**
 * Customized Exception class: cannot create Mail/Locker objects if the dimensions do not meet the
 * requirements.
 * @author  Zu Yu Zhang
 */

public class InvalidDimensionException extends Exception{
  public InvalidDimensionException(){
    super("Dimension(s) entered is(are) invalid. Each dimension should be an integer value greater"
        + " than or equal to 1.");
  }

}
