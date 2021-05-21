/**
 * Customized Exception class: A company can only offer window cleaning services to properties
 * having three floors or less.
 * @author  Zu Yu Zhang
 */
public class FloorsExceededException extends Exception {
  public FloorsExceededException(){
    super("Window cleaning service cannot be offered; property has more than three floors.");
  }


}