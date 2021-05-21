package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NonEmptyBagOfWordsTest {
  String word1;
  String word2;
  String word3;
  NonEmptyBagOfWords bag1;
  NonEmptyBagOfWords bag2;
  IBagOfWords updatedBag2;
  NonEmptyBagOfWords sameAsBag2;
  IBagOfWords updatedSameAsBag2;
  IBagOfWords emptyBag1;
  String bag1Description = "NonEmptyBagOfWords{s=cat, next=EmptyBagOfWords{}}";

  @Before
  public void setUp() throws Exception {
    emptyBag1 = NonEmptyBagOfWords.emptyBagOfWords();
    word1 = "cat";
    bag1 = new NonEmptyBagOfWords(word1, emptyBag1);
    word2 = "bird";
    word3 = "lion";
    bag2 = new NonEmptyBagOfWords(word2, emptyBag1);
    updatedBag2 = bag2.add(word3);
    sameAsBag2 = new NonEmptyBagOfWords(word3,emptyBag1);
    updatedSameAsBag2 = sameAsBag2.add(word2);
  }

  @Test
  public void emptyBagOfWords() {
    assertFalse(emptyBag1.equals(null));
    assertTrue(emptyBag1.isEmpty());
    assertFalse(emptyBag1.contains("cat"));
  }

  @Test
  public void isEmpty() {
    IBagOfWords emptyBag2 = NonEmptyBagOfWords.emptyBagOfWords();
    assertTrue(emptyBag2.isEmpty());
    assertFalse(bag1.isEmpty());
  }

  @Test
  public void size() {
    assertEquals((Integer)0, emptyBag1.size());
    assertEquals((Integer)1, bag1.size());
  }

  @Test
  public void add() {
    IBagOfWords updated1 = bag1.add("dog");
    assertEquals((Integer)2, updated1.size());
    assertTrue(updated1.contains("cat"));
    assertTrue(updated1.contains("dog"));
  }

  @Test
  public void contains() {
    IBagOfWords updated2 = emptyBag1.add("yellow");
    IBagOfWords updated3 = updated2.add("red");
    IBagOfWords updated4 = updated3.add("green");
    IBagOfWords updated5 = updated4.add("yellow");
    assertEquals((Integer)4, updated5.size());
    assertTrue(updated5.contains("red"));
    assertTrue(updated5.contains("green"));
    assertFalse(updated5.contains("purple"));
  }

  @Test
  public void testEquals() {
    assertTrue(bag1.equals(bag1));
    assertFalse(bag1.equals(null));
    assertFalse(bag1.equals(bag1Description));
    assertTrue(updatedBag2.equals(updatedSameAsBag2));
    assertFalse(bag1.equals(updatedBag2));
    assertFalse(bag1.equals(bag2));
  }

  @Test
  public void testHashCode() {
    assertTrue(updatedBag2.hashCode() == updatedSameAsBag2.hashCode());
    assertFalse(bag1.hashCode() == updatedSameAsBag2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(bag1Description, bag1.toString());
  }
}