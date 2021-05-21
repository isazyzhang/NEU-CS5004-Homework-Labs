/**
 * This class represents an interior painting service offered by a company providing property
 * services.
 * @author Zu Yu Zhang
 */
public class Painting extends AbstractInterior {

  /**
   * Number of hours needed to paint a small/medium property.
   */
  private static final int PAINT_SMALL_MEDIUM = 16;

  /**
   * Number of hours needed to paint a large property.
   */
  private static final int PAINT_LARGE = 24;

  /**
   * Creates a new painting service object.
   *
   * @param propertyAddress  the property's address
   * @param size             the property's size
   * @param monthly          whether or not the service is offered monthly
   * @param previousServices the number of services previously carried out at the given property
   * @param numPets          the number of pets living at the address
   */
  public Painting(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices, int numPets) {
    super(propertyAddress, size, monthly, previousServices, numPets);
  }

  /**
   * Calculates the final price for a painting service
   * @return the final price for painting service
   */
  @Override
  public double calculatePrice() {
    double paintingPrice = 0.0;
    //calculate price to paint property based on size
    switch(this.size) {
      case SMALL:
      case MEDIUM:
        paintingPrice = INTERIOR_BASE * PAINT_SMALL_MEDIUM;
        break;
      case LARGE:
        paintingPrice = INTERIOR_BASE * PAINT_LARGE;
    }

    return super.priceAdjustIE(priceIncreasePets(paintingPrice));
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
