import java.util.Objects;

/**
 * This abstract class represents a Service offered by a company providing property services. There
 * are three main types of service that the company provides:
 * Interior - work done on the inside of a home.
 * Exterior - work done on the outside of a home.
 * Specialist - work that requires particular qualifications or licenses.
 * @author Zu Yu Zhang
 */
public abstract class AbstractService implements Price{

  /**
   * The property address represented as a String
   */
  protected String propertyAddress;
  /**
   * The property size represented as an enum (SMALL/MEDIUM/LARGE)
   */
  protected PropertySize size;
  /**
   * A boolean indicating whether the service is provided monthly.
   */
  protected boolean monthly;
  /**
   * The number of services previously carried out at the address.
   */
  protected int previousServices;

  //Constants
  private static final int PREVIOUS_SER_ADJUST = 1;
  private static final double HALF_PRICE = 0.5;
  private static final double TEN_PERCENT_DISCOUNT = 0.9;

  /**
   * Creates a new Service object initialized with the following information: the property address,
   * the size of the property, whether the service is offered monthly, and the number of services
   * previously carried out at this property.
   *
   * @param propertyAddress the property's address
   * @param size the property's size
   * @param monthly whether or not the service is offered monthly
   * @param previousServices the number of services previously carried out at the given property
   */
  protected AbstractService(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices) {
    this.propertyAddress = propertyAddress;
    this.size = size;
    this.monthly = monthly;
    this.previousServices = previousServices;
  }

  /**
   * Gets the property's address
   * @return the property's address
   */
  public String getPropertyAddress() {
    return this.propertyAddress;
  }

  /**
   * Gets the property's size
   * @return the property's size
   */
  public PropertySize getSize() {
    return this.size;
  }

  /**
   * Gets whether the service is offered monthly on the property
   * @return whether the service is offered monthly on the property
   */
  public boolean isMonthly() {
    return this.monthly;
  }

  /**
   * Gets the number of previous services on this property
   * @return number of previous services
   */
  public int getPreviousServices() {
    return this.previousServices;
  }

  /**
   * Helper method to calculate the final price for interior/exterior services after adjusting for
   * number of previous services and whether the service is offered monthly
   * @param currentPrice current price for interior/exterior services
   * @return the final price of the service
   */
  protected double priceAdjustIE(double currentPrice){
    //the company will discount every 10th service by 50%
    int servicesAccumulated = this.previousServices + PREVIOUS_SER_ADJUST;
    if(servicesAccumulated % 10 == 0){
      currentPrice *= HALF_PRICE;
    }else{
      //if the number of services accumulated is not a multiple of 10, check if customer has
      //monthly service; if yes, apply a 10% discount
      if(this.monthly){
        currentPrice *= TEN_PERCENT_DISCOUNT;
      }
    }
    return currentPrice;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null|| getClass() != o.getClass()) {
      return false;
    }
    AbstractService that = (AbstractService) o;
    return Objects.equals(getPreviousServices(), that.getPreviousServices()) &&
        Objects.equals(getPropertyAddress(), that.getPropertyAddress()) &&
        Objects.equals(isMonthly(), that.isMonthly()) &&
        Objects.equals(getSize(), that.getSize());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPropertyAddress(), getSize(), isMonthly(), getPreviousServices());
  }

  @Override
  public String toString() {
    String size = "";
    switch(this.size){
      case SMALL:
        size = PropertySize.SMALL.name();
        break;
      case MEDIUM:
        size = PropertySize.MEDIUM.name();
        break;
      case LARGE:
        size = PropertySize.LARGE.name();
    }
    return "address: " + this.propertyAddress +
        ", size: " + size +
        ", monthly: " + this.monthly +
        ", previous services: " + this.previousServices;
  }
}
