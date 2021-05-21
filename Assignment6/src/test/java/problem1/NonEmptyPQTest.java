package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NonEmptyPQTest {
  NonEmptyPQ node1;
  IPriorityQueue node2;
  IPriorityQueue nodeEmpty;
  String node1String;

  NonEmptyPQ sameNode;
  NonEmptyPQ node3;
  NonEmptyPQ node4;
  NonEmptyPQ node5;

  @Before
  public void setUp() throws Exception {
    node1 = new NonEmptyPQ(5, "Five1", NonEmptyPQ.createEmpty());
    sameNode =  new NonEmptyPQ(5, "Five1", NonEmptyPQ.createEmpty());
    node3 = new NonEmptyPQ(3, "Three1", NonEmptyPQ.createEmpty());
    node4 = new NonEmptyPQ(5, "Five3", NonEmptyPQ.createEmpty());
    node5 = new NonEmptyPQ(5, "Five1", node3);
    nodeEmpty = NonEmptyPQ.createEmpty();
    node1String = "NonEmptyPQ{priority=5, value='Five1', next=EmptyPQ{}}";
  }

  @Test
  public void createEmpty() {
    node2 = NonEmptyPQ.createEmpty();
    assertTrue(node2.isEmpty());
  }

  @Test
  public void isEmpty() {
    assertFalse(node1.isEmpty());
    IPriorityQueue node3 = NonEmptyPQ.createEmpty();
    assertTrue(node3.isEmpty());
  }

  @Test
  public void add() throws EmptyPriorityQueueException {
    IPriorityQueue added1 = node1.add(5, "Five2");
    IPriorityQueue added2 = added1.add(1, "One1");
    String peek1 = "Five1";
    assertEquals(peek1,added2.peek());
    IPriorityQueue added3 = added2.add(8, "Eight1");
    IPriorityQueue added4 = added3.add(8, "Eight2");
    IPriorityQueue added5 = added4.add(2, "Two");
    assertFalse(added5.isEmpty());
    String peek2 = "Eight1";
    assertEquals(peek2,added5.peek());
  }

  @Test
  public void peek() throws EmptyPriorityQueueException {
    String peek2 = "Five1";
    assertEquals(peek2, node1.peek());
    IPriorityQueue added5 = node1.add(5, "FiveNew");
    assertEquals(peek2, added5.peek());
  }

  @Test(expected = EmptyPriorityQueueException.class)
  public void peekEmpty() throws EmptyPriorityQueueException{
    IPriorityQueue node4 = NonEmptyPQ.createEmpty();
    node4.peek();
  }

  @Test
  public void pop() throws EmptyPriorityQueueException {
    IPriorityQueue added6 = node1.add(5, "Five2");
    IPriorityQueue added7 = added6.add(1, "One1");
    IPriorityQueue result = NonEmptyPQ.createEmpty();
    IPriorityQueue result1 = result.add(5, "Five2");
    IPriorityQueue result2 = result1.add(1, "One1");
    assertEquals(result2, added7.pop());
  }

  @Test(expected = EmptyPriorityQueueException.class)
  public void popEmpty() throws EmptyPriorityQueueException{
    IPriorityQueue fail = nodeEmpty.pop();
  }

  @Test
  public void testEquals() {
    assertTrue(node1.equals(node1));
    assertFalse(node1.equals(null));
    assertFalse(node1.equals(node1String));
    assertTrue(node1.equals(sameNode));
    assertFalse(node1.equals(node3));
    assertFalse(node1.equals(node4));
    assertFalse(node1.equals(node5));

  }

  @Test
  public void testHashCode() {
    assertTrue(node1.hashCode() == sameNode.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(node1String, node1.toString());
  }
}