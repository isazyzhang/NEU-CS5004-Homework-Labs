package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyBagOfWordsTest {
  IBagOfWords empty1;
  IBagOfWords empty2;
  IBagOfWords empty3;
  IBagOfWords empty4;
  IBagOfWords nonEmpty4;
  String empty1Description = "EmptyBagOfWords{}";

  @Before
  public void setUp() throws Exception {
    empty1 = EmptyBagOfWords.emptyBagOfWords();
    empty3 = EmptyBagOfWords.emptyBagOfWords();
    empty4 = EmptyBagOfWords.emptyBagOfWords();
    nonEmpty4 = empty4.add("tiger");
  }

  @Test
  public void emptyBagOfWords() {
    empty2 = EmptyBagOfWords.emptyBagOfWords();
    assertTrue(empty2.isEmpty());
  }

  @Test
  public void isEmpty() {
    assertTrue(empty1.isEmpty());
  }

  @Test
  public void size() {
    assertEquals((Integer)0, empty1.size());
  }

  @Test
  public void add() {
    IBagOfWords nonEmpty1 = empty1.add("hello");
    assertFalse(nonEmpty1.isEmpty());
    assertTrue(nonEmpty1.contains("hello"));
    assertFalse(nonEmpty1.contains("HELLO"));
  }

  @Test
  public void contains() {
    assertFalse(empty1.contains("hi"));
    IBagOfWords nonEmpty2 = empty1.add("hey");
    assertTrue(nonEmpty2.contains("hey"));
    assertFalse(nonEmpty2.contains("hi"));
  }

  @Test
  public void testEquals() {
    assertTrue(empty1.equals(empty1));
    assertFalse(empty1.equals(null));
    assertFalse(empty1.equals(empty1Description));
    assertTrue(empty1.equals(empty3));
    assertFalse(empty1.equals(nonEmpty4));

  }

  @Test
  public void testHashCode() {
    assertTrue(empty1.hashCode() == empty3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(empty1Description, empty1.toString());
  }
}