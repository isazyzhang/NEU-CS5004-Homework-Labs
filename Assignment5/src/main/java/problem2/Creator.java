package problem2;

/**
 * This is an abstract class representing a Creator.
 * @author  Zu Yu Zhang
 */
public abstract class Creator {

  /**
   * This method checks whether the Creator passed into the function is the same as the current
   * Creator.
   *
   * @param creator the Creator for whom we want to check for equivalency
   * @return whether the two creators are the same
   */
  public abstract boolean sameCreator(Creator creator);

}