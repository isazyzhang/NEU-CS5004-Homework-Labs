package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IQueueTest {

  IQueue queue;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void enqueue() throws EmptyQueueException {
    // Adding one element to an empty queue should result in a size of 1
    queue.enqueue(15);
    Integer withOneElem = 1;
    assertEquals(withOneElem, queue.size());
    // Since there is only one element in the queue now, 15 is both the front and end of the queue
    // if peek on the front of the queue, should return 15
    Integer curFront = 15;
    assertEquals(curFront, queue.front());
    // Peeking on the front item does not remove it from the queue; the size should still be one
    assertEquals(withOneElem, queue.size());

  }

  @Test
  public void dequeue() throws EmptyQueueException {
    queue.enqueue(70);
    queue.enqueue(80);
    queue.enqueue(90);
    // When queue is not empty, should return the first element added to the queue
    Integer firstElem = 70;
    assertEquals(firstElem, queue.dequeue());
    // After the element was removed, size of queue should decrease by one.
    Integer newSize = 2;
    assertEquals(newSize, queue.size());

    queue.dequeue();
    queue.dequeue();
    // Now, all elements has been removed; size of queue should be 0.
    assertTrue(queue.size() == 0);
  }

  @Test(expected = EmptyQueueException.class)
  public void testDequeueException() throws EmptyQueueException {
    // An exception should be thrown if we try to dequeue an empty queue
    queue.enqueue(99);
    queue.dequeue();
    queue.dequeue();
  }

  @Test
  public void front() throws EmptyQueueException {
    queue.enqueue(111);
    queue.enqueue(222);

    // When queue is not empty, should return the first element of queue
    Integer firstAdded = 111;
    assertEquals(firstAdded, queue.front());
    // Since the element is only checked, not removed, size should not change
    Integer curSize = 2;
    assertEquals(curSize, queue.size());
  }

  @Test(expected = EmptyQueueException.class)
  public void testFrontException() throws EmptyQueueException {
    queue.enqueue(2);
    queue.enqueue(6);
    queue.dequeue();
    queue.dequeue();

    // Queue is empty now
    queue.front();  // throws exception

  }

  @Test
  public void size() {
    assertTrue(queue.size() == 0);

    queue.enqueue(999);
    queue.enqueue(777);
    queue.enqueue(1010);
    queue.enqueue(99);
    queue.enqueue(800);
    assertTrue(queue.size() == 5);
  }
}