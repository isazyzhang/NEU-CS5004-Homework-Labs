/**
 * This class represents a Plumbing service offered by the company.
 * @author Zu Yu Zhang
 */
public class Plumbing extends AbstractSpecialist {

  /**
   * For plumbing work, a permitting fee of 20$ is added to the total
   */
  private static final int PLUMBING_PERMITTING_FEE = 20;

  /**
   * Creates a new plumbing service object.
   *
   * @param propertyAddress      the property's address
   * @param size                 the property's size
   * @param monthly              whether or not the service is offered monthly
   * @param previousServices     the number of services previously carried out at the given property
   * @param numEmployeesRequired the number of employees required
   * @param isComplex            whether the work is complex
   */
  public Plumbing(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices, int numEmployeesRequired, boolean isComplex) {
    super(propertyAddress, size, monthly, previousServices, numEmployeesRequired, isComplex);
  }

  /**
   * Calculates the price for a Plumbing service.
   * @return the total price required for the given service
   */
  @Override
  public double calculatePrice() {
    return numEmployeesRequired * SPECIALIST_BASE_PER_EMPLOYEE + PLUMBING_PERMITTING_FEE;
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
