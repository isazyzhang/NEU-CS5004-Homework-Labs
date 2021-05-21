package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
  Book book1;
  Author author1;
  String title1;
  int year1;

  Book book2;
  Author author2;
  String title2;
  int year2;

  Book book3;
  Book book4;
  Book book5;

  String bookDescription1;

  @Before
  public void setUp() throws Exception {
    author1 = new Author("Charlotte", "Bronte");
    title1 = "Jane Eyre";
    year1 = 1847;
    book1 = new Book(author1, title1, year1);
    bookDescription1 = "Author: Charlotte Bronte Title: Jane Eyre Published Year: 1847";

    author2 = new Author("Mary", "Shelley");
    title2 = "Frankenstein";
    year2 = 1823;
    book2 = new Book(author2, title2, year2);

    book3 = new Book(author1, title1, year1);
    book4 = new Book(author1, "Fairy Tales", year1);
    book5 = new Book(author2, "Fairy Tales", year1);
  }

  @Test
  public void getCreator() {
    assertTrue(author1.equals(book1.getCreator()));
  }

  @Test
  public void getTitle() {
    assertEquals(title1, book1.getTitle());
  }

  @Test
  public void getYear() {
    assertEquals(year1, book1.getYear());
  }

  @Test
  public void itemCreatedBy() {
    assertTrue(book1.itemCreatedBy(author1));
    assertFalse(book1.itemCreatedBy(author2));
  }

  @Test
  public void testEquals() {
    assertTrue(book1.equals(book1));
    assertFalse(book1.equals(null));
    assertFalse(book1.equals(bookDescription1));
    assertTrue(book1.equals(book3));
    assertFalse(book1.equals(book2));
    assertFalse(book3.equals(book4));
    assertFalse(book4.equals(book5));
  }

  @Test
  public void testHashCode() {
    assertTrue(book1.hashCode() == book3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(bookDescription1, book1.toString());
  }
}