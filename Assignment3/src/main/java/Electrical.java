/**
 * This class represents an electrical service offered by the company.
 * @author Zu Yu Zhang
 */
public class Electrical extends AbstractSpecialist {

  /**
   * Electrical services can require a maximum number of 4 employees
   */
  private static final int MAX_ELEC_EMPLOYEES = 4;
  /**
   * For electrical work, a permitting fee of 50$ is added to the total
   */
  private static final int ELECTRICAL_PERMITTING_FEE = 50;

  /**
   * Creates a new electrical service object.
   * RESTRICTION: impossible to create an electrical service if more than 4 employees are required.
   *
   * @param propertyAddress the property's address
   * @param size the property's size
   * @param monthly whether or not the service is offered monthly
   * @param previousServices the number of services previously carried out at the given property
   * @param numEmployeesRequired the number of employees required
   * @param isComplex whether the work is complex
   * @throws EmployeesExceededException if the number of required employees is more than four
   */
  public Electrical(String propertyAddress, PropertySize size, boolean monthly,
      int previousServices, int numEmployeesRequired, boolean isComplex)
      throws EmployeesExceededException {
    super(propertyAddress, size, monthly, previousServices,isComplex);
    this.numEmployeesRequired = this.validNumOfEmployees(numEmployeesRequired);
  }

  /**
   * Helper method to check whether the number of employees entered by user is valid: impossible
   * to create an electrical service object if more than 4 employees are required.
   * @param numEmployeesRequired the number of required employees specified by user
   * @return the number of employees that will work on the property
   * @throws EmployeesExceededException if more than 4 employees are required
   */
  private int validNumOfEmployees(int numEmployeesRequired) throws EmployeesExceededException {
    if(numEmployeesRequired > MAX_ELEC_EMPLOYEES) {
      throw new EmployeesExceededException();
    }else {
      return numEmployeesRequired;
    }
  }

  /**
   * Calculates the price for an Electrical service.
   * @return the total price required for the given service
   */
  @Override
  public double calculatePrice() {
    return numEmployeesRequired * SPECIALIST_BASE_PER_EMPLOYEE + ELECTRICAL_PERMITTING_FEE;
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
