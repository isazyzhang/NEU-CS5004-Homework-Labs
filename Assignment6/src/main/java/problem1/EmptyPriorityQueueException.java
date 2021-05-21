package problem1;

/**
 * Customized Exception class. Thrown when trying to peek or remove an element from an empty
 * priority queue.
 * @author Zu Yu Zhang
 */
public class EmptyPriorityQueueException extends Exception {
  public EmptyPriorityQueueException(){
    super("The Priority Queue is Empty.");
  }
}
