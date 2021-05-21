/**
 * Customized Exception class: an electrical service cannot require more than 4 employees.
 * @author Zu Yu Zhang
 */
public class EmployeesExceededException extends Exception {
  public EmployeesExceededException(){
    super("An electrical service cannot require more than four employees.");
  }

}
