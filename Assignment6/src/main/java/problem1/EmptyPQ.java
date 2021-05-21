package problem1;

/**
 * This class represents a Priority Queue with zero elements in it.
 * @author Zu Yu Zhang
 */
public class EmptyPQ implements IPriorityQueue {

  private static final int MADE_UP_HASHCODE = 31;
  /**
   * Constructor for empty PQ
   */
  public EmptyPQ(){
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
    return true;
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
    return new NonEmptyPQ(priority, value, this);
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
   * @throws EmptyPriorityQueueException if the queue is empty
   */
  @Override
  public String peek() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException();
  }

  /**
   * Returns a copy of the PQ without the element with the highest priority. Calling pop() on an
   * empty PQ should throw an exception.
   *
   * When multiple elements in the PQ have the same priority: remove the element that has been in
   * the queue for the longest time first.
   *
   * @return a copy of the PQ without the element with the highest priority
   * @throws EmptyPriorityQueueException if the PQ is empty
   */
  @Override
  public IPriorityQueue pop() throws EmptyPriorityQueueException{
    throw new EmptyPriorityQueueException();
  }

  @Override
  public int hashCode() {
    return MADE_UP_HASHCODE;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    return true;
  }

  @Override
  public String toString() {
    return "EmptyPQ{}";
  }
}
