package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyPQTest {
  IPriorityQueue empty1;
  IPriorityQueue empty2;
  IPriorityQueue empty4;
  IPriorityQueue empty5;
  IPriorityQueue empty6;
  String empty1Description;

  @Before
  public void setUp() throws Exception {
    empty1 = EmptyPQ.createEmpty();
    empty4 = EmptyPQ.createEmpty();
    empty5 = EmptyPQ.createEmpty();
    empty6 = empty5.add(10, "Ten");
    empty1Description = "EmptyPQ{}";
  }

  @Test
  public void createEmpty() {
    empty2 = EmptyPQ.createEmpty();
    assertTrue(empty2.isEmpty());
  }

  @Test
  public void isEmpty() {
    assertTrue(empty1.isEmpty());
  }

  @Test
  public void add() throws EmptyPriorityQueueException {
    IPriorityQueue nonEmpty1 = empty1.add(5, "Five1");
    assertFalse(nonEmpty1.isEmpty());
    assertTrue("Five1".equals(nonEmpty1.peek()));
    IPriorityQueue empty3 = EmptyPQ.createEmpty();
    assertTrue(empty3.equals(nonEmpty1.pop()));
  }

  @Test
  public void peek() throws EmptyPriorityQueueException {
    IPriorityQueue nonEmpty1 = empty1.add(5, "Five1");
    assertTrue("Five1".equals(nonEmpty1.peek()));
  }

  @Test(expected = EmptyPriorityQueueException.class)
  public void peekEmpty() throws EmptyPriorityQueueException {
    String fail = empty1.peek();
  }

  @Test
  public void pop() throws EmptyPriorityQueueException {
    IPriorityQueue nonEmpty2 = empty1.add(3, "Three1");
    IPriorityQueue empty4 = EmptyPQ.createEmpty();
    assertTrue(empty4.equals(nonEmpty2.pop()));
  }

  @Test(expected = EmptyPriorityQueueException.class)
  public void popEmpty() throws EmptyPriorityQueueException{
    IPriorityQueue fail = empty1.pop();
  }

  @Test
  public void testEquals() {
    assertTrue(empty1.equals(empty1));
    assertFalse(empty1.equals(null));
    assertFalse(empty1.equals(empty1Description));
    assertTrue(empty1.equals(empty4));
    assertFalse(empty1.equals(empty6));
  }

  @Test
  public void testHashCode() {
    assertTrue(empty1.hashCode() == empty4.hashCode());
  }


  @Test
  public void testToString() {
    assertEquals(empty1Description, empty1.toString());
  }
}