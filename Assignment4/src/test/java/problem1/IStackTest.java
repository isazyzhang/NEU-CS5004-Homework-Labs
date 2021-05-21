package problem1;

import static org.junit.Assert.*;

import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

public class IStackTest {
  IStack stack;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void push() {
    stack.push(3);
    // After pushing, check if the most recently-added item is the one that we just pushed
    Integer checkPush = 3;
    assertEquals(checkPush,stack.top());
    // Right now there is one element on the stack
    assertFalse(stack.isEmpty());
  }

  @Test
  public void pop() {
    stack.push(3);
    // When we call the pop() method on a stack with one element, that element is returned and
    // the stack becomes empty
    Integer checkPop = 3;
    assertEquals(checkPop, stack.pop());
    assertTrue(stack.isEmpty());
  }

  @Test(expected = EmptyStackException.class)
  public void testPopException(){
    // If try to pop from an empty stack, exception will be thrown
    stack.pop();
  }

  @Test
  public void top() {
    stack.push(9);
    stack.push(8);
    Integer last = 8;
    assertEquals(last, stack.top());
  }

  @Test(expected = EmptyStackException.class)
  public void testTopException(){
    // If try to peek the top of an empty stack, will throw exception
    stack.top();
  }

  @Test
  public void isEmpty() {
    // Any newly created stacks are assumed to be empty
    assertTrue(stack.isEmpty());

    // Stack is no longer empty after we add elements to it
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertFalse(stack.isEmpty());
  }
}