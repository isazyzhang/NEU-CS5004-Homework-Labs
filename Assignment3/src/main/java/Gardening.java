/**
 * This class represents a gardening service offered by a company providing property
 * services.
 * @author Zu Yu Zhang
 */

public class Gardening extends AbstractExterior {

  /**
   * The company charges a 20$ waste removal fee for gardening services.
   */
  private static final int WASTE_REMOVAL = 20;

  /**
   * Creates a new gardening service object.
   *
   * @param propertyAddress the property's address
   * @param size the property's size
   * @param monthly whether or not the service is offered monthly
   * @param previousServices the number of services previously carried out at the given property
   */
  public Gardening(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices) {
    super(propertyAddress, size, monthly, previousServices);
  }

  /**
   * Calculates the price for a Gardening service.
   * @return the total price required for the given service
   */
  @Override
  public double calculatePrice() {
    return super.priceAdjustIE(super.calculatePrice() + WASTE_REMOVAL);
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
    return super.toString() +
        ", total price: " + this.calculatePrice();
  }
}
