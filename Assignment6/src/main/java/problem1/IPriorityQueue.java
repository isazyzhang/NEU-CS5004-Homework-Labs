package problem1;

/**
 * Interface to be implemented by EmptyPQ and NonEmptyPQ.
 * @author Zu Yu Zhang
 */
public interface IPriorityQueue {

  /**
   * Checks if the PQ is empty. Returns true if the Priority Queue contains no items,
   * false otherwise.
   *
   * @return whether the PQ is empty
   */
  Boolean isEmpty();

  /**
   * Adds the given element (the priority and its associated value) to the PQ.
   *
   * When multiple elements have the same priority: elements are added according to their order of
   * arrival: new elements are inserted in the middle of the list such that the element that have
   * been in the queue for the longest time would always be dequeued first.
   *
   * @param priority the priority of the element to be added
   * @param value the value of the element to be added
   * @return the PQ with the new element added
   */
  IPriorityQueue add(Integer priority, String value);

  /**
   * Returns the value in the PQ that has the highest priority. The PQ remains unchanged.
   * For two positive integers, i and j, if i is smaller than j then i has a lower priority than j.
   * Calling peek() on an empty PQ should throw an exception.
   *
   * When multiple elements have the same priority, they are dequeued according to the order that
   * they were added. (i.e. calling peek() would return the value of the element with the highest
   * priority that has been added for the longest time.
   *
   * @return the value in the PQ with the highest priority
   * @throws EmptyPriorityQueueException if the PQ is empty
   */
  String peek() throws EmptyPriorityQueueException;

  /**
   * Returns a copy of the PQ without the element with the highest priority.
   * Calling pop() on an empty PQ should throw an exception.
   *
   * When multiple elements in the PQ have the same priority: remove the element that has been in
   * the queue for the longest time first.
   *
   * @return a copy of the PQ without the element with the highest priority
   * @throws EmptyPriorityQueueException if the PQ is empty
   */
  IPriorityQueue pop() throws EmptyPriorityQueueException;
}
