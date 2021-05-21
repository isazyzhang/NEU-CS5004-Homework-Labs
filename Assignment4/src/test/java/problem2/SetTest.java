package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
  Set initEmpty;
  Set anotherEmpty;
  Set notEmpty;
  String notEmptyDescription;

  @Before
  public void setUp() throws Exception {
    initEmpty = new Set();
    anotherEmpty = Set.emptySet();
    Integer[] init = {1, 2, 3};
    notEmpty = new Set(init, 3);
    notEmptyDescription = "{1, 2, 3}";
  }

  @Test
  public void constructorTest1(){
    // When a new Set is created using the Set() constructor, from the user's point of view, the Set
    // has size 0. However, the underlying data structure is an integer array with 1 slot.
    assert(initEmpty.getItems().length == 1);
  }

  @Test
  public void getItems(){
    // When a new Set is initialized using the Set() constructor, element in the underlying array is
    // null.
    for(int i = 0; i < initEmpty.getItems().length; i++){
      assertNull(initEmpty.getItems()[i]);
    }

  }

  @Test
  public void getSize() {
    assertEquals(0, initEmpty.getSize());
  }


  @Test
  public void isEmpty() {
    assertTrue(initEmpty.isEmpty());
    assertFalse(notEmpty.isEmpty());
  }

  @Test
  public void add() {
    Set added1 = initEmpty.add(1);
    Integer[] added1Elems = {1};
    assertArrayEquals(added1Elems, added1.getItems());

    Set added2 = anotherEmpty.add(2);
    Set added3 = added2.add(2);
    Integer[] added2Elems = {2};
    assertArrayEquals(added2Elems, added3.getItems());

    Set added4 = added3.add(12);
    Set added5 = added4.add(15);
    Set added6 = added5.add(28);
    Integer[] added6Elems = {2, 12, 15, 28};
    assertArrayEquals(added6Elems, added6.getItems());

  }

  @Test
  public void contains() {
    assertTrue(notEmpty.contains(1));
    assertFalse(notEmpty.contains(50));
  }

  @Test
  public void remove() {
    Set removed = notEmpty.remove(20);
    assertArrayEquals(notEmpty.getItems(), removed.getItems());

    Set removed2 = notEmpty.remove(1);
    Integer[] afterRemoval = {2, 3};
    assertArrayEquals(afterRemoval, removed2.getItems());

    Set removed3 = removed2.remove(3);
    Integer[] afterRemoval2 = {2};
    assertArrayEquals(afterRemoval2, removed3.getItems());

  }

  @Test
  public void size() {
    Integer zero = 0;
    Integer three = 3;
    assertEquals(zero, initEmpty.size());
    assertEquals(three,notEmpty.size());
  }

  @Test
  public void testEquals(){
    Integer[] asc = {1, 2, 3, 4, 5, 6};
    Integer[] des = {6, 5, 4, 3, 2, 1};
    Set ascending = new Set(asc, 6);
    Set descending = new Set(des, 6);
    assertTrue(ascending.equals(descending));

    assertTrue(initEmpty.equals(initEmpty));
    assertFalse(notEmpty.equals(notEmptyDescription));
    assertFalse(initEmpty.equals(notEmpty));

    Integer[] trial = {4, 5, 6};
    Set trial1 = new Set(trial, 3);
    assertFalse(notEmpty.equals(trial1));
  }

  @Test
  public void testHashCode(){
    Set hash1 = Set.emptySet();
    Set hash2 = hash1.add(3);
    Set hash3 = hash2.add(2);
    Set hash4 = hash3.add(1);
    assertEquals(notEmpty.hashCode(), hash4.hashCode());

    assertEquals(initEmpty.hashCode(), Set.emptySet().hashCode());
  }

  @Test
  public void testToString(){
    assertEquals(notEmptyDescription, notEmpty.toString());
  }


}