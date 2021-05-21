/**
 * An interface for the price calculation for services.
 * @author Zu Yu Zhang
 */
public interface Price {

  /**
   * Calculates the price for a given service
   * @return the total price required for the given service
   */
  double calculatePrice();

}
