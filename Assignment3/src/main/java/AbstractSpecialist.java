import java.util.Objects;

/**
 * This abstract class represents a specialist service offered by a company providing property
 * services. There are two types of specialist services:
 * - Electrical
 * - Plumbing
 * @author Zu Yu Zhang
 */
public abstract class AbstractSpecialist extends AbstractService {

  /**
   * The number of licensed employees required to complete the work
   */
  protected int numEmployeesRequired;
  /**
   * Boolean indicating whether the work to be done is complex
   */
  protected boolean isComplex;
  /**
   * Minimum number of employees required for complex work done on a small/medium household.
   */
  protected static final int MIN_COMPLEX_SMALL_MEDIUM = 2;
  /**
   * Minimum number of employees required for complex work done on a large house.
   */
  protected static final int MIN_COMPLEX_LARGE = 3;
  /**
   * Minimum number of employees required for all specialist services.
   */
  protected static final int MIN_EMPLOYEE = 1;
  /**
   * Base rate per hour for specialist services: 200$ per licensed employee
   */
  protected static final int SPECIALIST_BASE_PER_EMPLOYEE = 200;

  /**
   * Creates a new specialist service object with the following details: the number of licensed
   * employees required to complete the work, and whether the work to be done is complex.
   * Characteristics inherited from AbstractService class: the property address, the size of the
   * property, whether the service is offered monthly, and the number of services previously carried
   * out at this property.
   *
   * @param propertyAddress the property's address
   * @param size the property's size
   * @param monthly whether or not the service is offered monthly
   * @param previousServices the number of services previously carried out at the given property
   * @param numEmployeesRequired the number of employees required
   * @param isComplex whether the work is complex
   */
  public AbstractSpecialist(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices, int numEmployeesRequired, boolean isComplex){
    super(propertyAddress, size, monthly, previousServices);
    this.isComplex = isComplex;
    this.numEmployeesRequired = this.setNumEmployees(numEmployeesRequired);
  }

  /**
   * Alternative constructor, later to be used by the "Electrical" class, since it will inherit all
   * parent instance variables except for the number of employees required.
   *
   *@param propertyAddress the property's address
   *@param size the property's size
   *@param monthly whether or not the service is offered monthly
   *@param previousServices the number of services previously carried out at the given property
   *@param isComplex whether the work is complex
   */
  public AbstractSpecialist(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices, boolean isComplex) {
    super(propertyAddress, size, monthly, previousServices);
  }

  /**
   * Helper method to set the number of employees in case the one that the user entered doesn't
   * meet the requirement:
   * @param numEmployeesRequired number of employees required entered by user
   * @return the number of employees that will work on the property
   */
  private int setNumEmployees(int numEmployeesRequired){
    if(this.isComplex) {
      //for complex work done small and medium properties
      if (this.size == PropertySize.SMALL || this.size == PropertySize.MEDIUM) {
        if(numEmployeesRequired < MIN_COMPLEX_SMALL_MEDIUM){
          //set to default (2) if requirement is not met
          return MIN_COMPLEX_SMALL_MEDIUM;
        }
      }
      //for complex work done on large properties
      if (size == PropertySize.LARGE && numEmployeesRequired < MIN_COMPLEX_LARGE) {
        //set to default (3) if requirement is not met
        return MIN_COMPLEX_LARGE;
      }
    }
    //for non-complex works on all properties of all sizes
    if(numEmployeesRequired < MIN_EMPLOYEE) {
      //set to default (1) if requirement is not met
      return MIN_EMPLOYEE;
    }
    //if requirement is met, set to user-specified number of employees
    return numEmployeesRequired;
  }


  /**
   * Gets the number of employees required.
   * @return the number of employees required
   */
  public int getNumEmployeesRequired() {
    return this.numEmployeesRequired;
  }

  /**
   * Gets whether the work to be done is complex
   * @return whether the work is complex
   */
  public boolean isComplex() {
    return this.isComplex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractSpecialist)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    AbstractSpecialist that = (AbstractSpecialist) o;
    return getNumEmployeesRequired() == that.getNumEmployeesRequired() &&
        isComplex() == that.isComplex();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumEmployeesRequired(), isComplex());
  }

  @Override
  public String toString() {
    return super.toString() +
        ", number of employees required: " + this.numEmployeesRequired +
        ", is the work complex: " + this.isComplex;
  }
}
