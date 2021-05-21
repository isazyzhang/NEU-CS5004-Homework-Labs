/**
 * This abstract class represents an exterior service offered by a company providing property
 * services. There are two types of exterior services:
 * - Gardening
 * - Window Cleaning
 * @author Zu Yu Zhang
 */
public abstract class AbstractExterior extends AbstractService {

  /**
   * The base rate for exterior services
   */
  protected static final int EXTERIOR_BASE = 80;

  /**
   * Number of hours needed for a small property.
   */
  private static final int EXT_SMALL = 1;

  /**
   * Number of hours needed for  a medium property.
   */
  private static final int EXT_MEDIUM = 2;

  /**
   * Number of hours needed for a large property.
   */
  private static final int EXT_LARGE = 4;


  /**
   * Creates a new exterior service object.
   * Characteristics inherited from AbstractService class: the property address, the size of the
   * property, whether the service is offered monthly, and the number of services previously carried
   * out at this property.
   *
   * @param propertyAddress the property's address
   * @param size the property's size
   * @param monthly whether or not the service is offered monthly
   * @param previousServices the number of services previously carried out at the given property
   */
  public AbstractExterior(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices){
    super(propertyAddress, size, monthly, previousServices);
  }

  /**
   * Calculates the price for a given service
   *
   * @return the total price required for the given service
   */
  @Override
  public double calculatePrice() {
    double exteriorPrice = 0.0;
    //calculate price based on size
    switch(this.size) {
      case SMALL:
        exteriorPrice = EXTERIOR_BASE * EXT_SMALL;
        break;
      case MEDIUM:
        exteriorPrice = EXTERIOR_BASE * EXT_MEDIUM;
        break;
      case LARGE:
        exteriorPrice = EXTERIOR_BASE * EXT_LARGE;
    }

    return exteriorPrice;
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
    return super.toString();
  }
}
