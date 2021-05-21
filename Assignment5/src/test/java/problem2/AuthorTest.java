package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {
  Author author1;
  Author author2;
  Author author3;
  String author1Name;
  @Before
  public void setUp() throws Exception {
    author1 = new Author("Charlotte", "Bronte");
    author2 = new Author("Mary", "Shelley");
    author3 = new Author("Charlotte", "Bronte");
    author1Name = "Author: Charlotte Bronte ";
  }

  @Test
  public void getFirstName() {
    assertEquals("Charlotte", author1.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Bronte", author1.getLastName());
  }

  @Test
  public void sameCreator() {
    assertTrue(author1.sameCreator(author1));
    assertFalse(author1.sameCreator(author2));
  }

  @Test
  public void testEquals() {
    assertTrue(author1.equals(author1));
    assertFalse(author1.equals(null));
    assertFalse(author1.equals(author1Name));
    assertFalse(author1.equals(author2));
    assertTrue(author1.equals(author3));

  }

  @Test
  public void testHashCode() {
    assertTrue(author1.hashCode() == author3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(author1Name, author1.toString());
  }
}