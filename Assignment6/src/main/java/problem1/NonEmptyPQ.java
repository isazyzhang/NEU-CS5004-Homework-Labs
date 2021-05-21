package problem1;

import java.util.Objects;

/**
 * This class represents a priority queue that is not empty (containing at least one element)
 * @author Zu Yu Zhang
 */
public class NonEmptyPQ implements IPriorityQueue {
  /**
   * Priority of the first element
   */
  private Integer priority;
  /**
   * Associated value to the first element
   */
  private String value;
  /**
   * Reference to the next element
   */
  private IPriorityQueue next;

  /**
   * Constructs a new element of the PQ
   *
   * @param priority the element's priority
   * @param value the value associated to the element
   * @param next reference to the element's next element
   */
  public NonEmptyPQ(Integer priority, String value, IPriorityQueue next){
    this.priority = priority;
    this.value = value;
    this.next = next;
  }

  /**
   * Creates and returns an empty PQ
   *
   * @return an empty PQ
   */
  public static IPriorityQueue createEmpty() {
    return new EmptyPQ();
  }

  /**
   * Checks if the PQ is empty. Returns true if the Priority Queue contains no items, false
   * otherwise.
   *
   * @return whether the PQ is empty
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Adds the given element (the priority and its associated value) to the PQ.
   *
   * When multiple elements have the same priority: elements are added according to their order of
   * arrival: new elements are inserted in the middle of the list such that the element that have
   * been in the queue for the longest time would always be dequeued first.
   *
   * @param priority the priority of the element
   * @param value the value associated to the element
   * @return the PQ with the new element added
   */
  @Override
  public IPriorityQueue add(Integer priority, String value) {
    // If priority of the new string is higher than the current highest priority, append it to the
    // start of the priority queue
    if(priority > this.priority){
      return new NonEmptyPQ(priority, value, this);
      }
    return new NonEmptyPQ(this.priority, this.value, this.next.add(priority, value));
  }

  /**
   * Returns the value in the PQ that has the highest priority. The PQ remains unchanged. For two
   * positive integers, i and j, if i is smaller than j then i has a lower priority than j. Calling
   * peek() on an empty PQ should throw an exception.
   *
   * When multiple elements have the same priority, they are dequeued according to the order that
   * they were added. (i.e. calling peek() would return the value of the element with the highest
   * priority that has been added for the longest time)
   *
   * @return the value in the PQ with the highest priority
   */
  @Override
  public String peek(){
    return this.value;
  }

  /**
   * Returns a copy of the PQ without the element with the highest priority. Calling pop() on an
   * empty PQ should throw an exception.
   *
   * When multiple elements in the PQ have the same priority: remove the element that has been in
   * the queue for the longest time first.
   *
   * @return a copy of the PQ without the element with the highest priority
   */
  @Override
  public IPriorityQueue pop() {
    return this.next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonEmptyPQ)) {
      return false;
    }
    NonEmptyPQ that = (NonEmptyPQ) o;
    return Objects.equals(priority, that.priority) &&
        Objects.equals(value, that.value) &&
        Objects.equals(next, that.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, value, next);
  }

  @Override
  public String toString() {
    return "NonEmptyPQ{" +
        "priority=" + priority +
        ", value='" + value + '\'' +
        ", next=" + next +
        '}';
  }
}
