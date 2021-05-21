/**
 * This class represents a window cleaning service offered by the company.
 * @author  Zu Yu Zhang
 */
public class WindowCleaning extends AbstractExterior {

  /**
   * The number of floor the property has
   */
  private int numFloors;
  /**
   * The maximum number of floors the company can work with.
   */
  private static final int MAX_FLOORS = 3;
  /**
   * A 5% fee is added to the price if the property has more than one floor
   */
  private static final int MORE_THAN_ONE_FLOOR = 1;
  /**
   * A 5% fee is applied
   */
  private static final double EXTRA_FIVE = 1.05;


  /**
   * Creates a new window cleaning service object.
   *
   * @param propertyAddress the property's address
   * @param size the property's size
   * @param monthly whether or not the service is offered monthly
   * @param previousServices the number of services previously carried out at the given property
   * @param numFloors the number of floor the property has
   * @throws FloorsExceededException if the property has more than three floors
   */
  public WindowCleaning(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices, int numFloors) throws FloorsExceededException {
    super(propertyAddress, size, monthly, previousServices);
    //check if the number of floors meets the requirement; if not, object cannot be created and
    //exception is thrown.
    this.numFloors = this.validNumFloors(numFloors);
  }

  /**
   * Helper method to check if the property's number of floors exceeds the company's capacity. The
   * maximum number of floors that the company can work with is 3. It should not be possible to
   * create a window cleaning service for a property with more than 3 floors.
   *
   * @param numFloors the number of floors that the user enters
   * @return the number of floor that the user entered
   * @throws FloorsExceededException if user entered more than three floors
   */
  private int validNumFloors(int numFloors) throws FloorsExceededException {
    if(numFloors <= MAX_FLOORS){
      return numFloors;
    }else{
      throw new FloorsExceededException();
    }
  }

  /**
   * Calculates the price for a Window Cleaning service
   * @return the total price required for the given service
   */
  @Override
  public double calculatePrice() {
    double gardeningPrice = super.calculatePrice();
    if(this.numFloors > MORE_THAN_ONE_FLOOR) {
      gardeningPrice *= EXTRA_FIVE;
    }
    return super.priceAdjustIE(gardeningPrice);
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
