/**
 * This class represents an interior cleaning service offered by a company providing property
 * services.
 * @author Zu Yu Zhang
 */
public class Cleaning extends AbstractInterior {

  /**
   * Number of hours needed to clean a small property.
   */
  private static final int CLEAN_SMALL = 1;

  /**
   * Number of hours needed to clean a medium property.
   */
  private static final int CLEAN_MEDIUM = 2;

  /**
   * Number of hours needed to clean a large property.
   */
  private static final int CLEAN_LARGE = 4;

  /**
   * Creates a new cleaning service object.
   *
   * @param propertyAddress the property's address
   * @param size the property's size
   * @param monthly whether or not the service is offered monthly
   * @param previousServices the number of services previously carried out at the given property
   * @param numPets the number of pets living at the address
   */
  public Cleaning(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices, int numPets) {
    super(propertyAddress, size, monthly, previousServices, numPets);
  }

  /**
   * Calculates the price for a Cleaning service.
   * @return the total price required for the given service
   */
  @Override
  public double calculatePrice() {
    double cleaningPrice = 0.0;
    //calculate price to clean property based on size
    switch(this.size) {
      case SMALL:
        cleaningPrice = INTERIOR_BASE * CLEAN_SMALL;
        break;
      case MEDIUM:
        cleaningPrice = INTERIOR_BASE * CLEAN_MEDIUM;
        break;
      case LARGE:
        cleaningPrice = INTERIOR_BASE * CLEAN_LARGE;
    }

    //the final price after adjusting for number of pets and potential discounts
    return super.priceAdjustIE(priceIncreasePets(cleaningPrice));
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
