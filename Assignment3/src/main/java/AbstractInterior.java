import java.util.Objects;

/**
 * This abstract class is a subclass of the AbstractService class, it represents an interior service
 * done on the property.
 * @author Zu Yu Zhang
 */
public abstract class AbstractInterior extends AbstractService{

  /**
   * The number of pets living at the address
   */
  protected int numPets;

  /**
   * The base rate for interior services
   */
  protected static final int INTERIOR_BASE = 80;

  /**
   * Number of pets requiring 5% fee (one pet)
   */
  protected static final int ONE_PET = 1;

  /**
   * Number of pets requiring 5% fee (two pets)
   */
  protected static final int TWO_PETS = 2;

  /**
   * Number of pets requiring 7% fee (three pets or more)
   */
  protected static final int THREE_PETS_OR_MORE = 3;

  /**
   * 5% service fee added to the price if the property has 1 or 2 pets.
   */
  protected static final double EXTRA_FIVE = 1.05;

  /**
   * 7% service fee added to the price if the property has 3 pets or more.
   */
  protected static final double EXTRA_SEVEN = 1.07;

  /**
   * Creates a new interior service object with the following details: number of pets living at the
   * property.
   * Characteristics inherited from AbstractService class: the property address, the size of the
   * property, whether the service is offered monthly, and the number of services previously carried
   * out at this property.
   *
   * @param propertyAddress the property's address
   * @param size the property's size
   * @param monthly whether or not the service is offered monthly
   * @param previousServices the number of services previously carried out at the given property
   * @param numPets the number of pets living at the address
   */
  protected AbstractInterior(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices, int numPets){
    super(propertyAddress, size, monthly, previousServices);
    this.numPets = numPets;
  }

  /**
   * Gets the number of pets living on the property.
   * @return the number of pets
   */
  public int getNumPets() {
    return numPets;
  }

  /**
   * Helper method to apply an extra fee on the interior service price if there are pets living
   * on the property.
   *
   * @param interiorPrice the price for cleaning/painting without considering pets
   * @return the total price for interior service after considering for pets
   */
  protected double priceIncreasePets(double interiorPrice){
    if(this.numPets == ONE_PET || this.numPets == TWO_PETS){
      interiorPrice *= EXTRA_FIVE;
    }

    if(this.numPets >= THREE_PETS_OR_MORE){
      interiorPrice *= EXTRA_SEVEN;
    }
    return interiorPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractInterior)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    AbstractInterior that = (AbstractInterior) o;
    return getNumPets() == that.getNumPets();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumPets());
  }

  @Override
  public String toString() {
    return super.toString() +
        ", number of pets: " + this.numPets;
  }
}
