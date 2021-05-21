package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class CatalogTest {
  Catalog catalog1;
  Catalog catalog2;
  Catalog catalog3;
  String catalog1Description;
  Catalog catalog4;
  ArrayList<Item> collection4;
  ArrayList<Item> collection1;
  ArrayList<Item> collection3;
  Book ulysses;
  Author joyce;
  Book mockingbird;
  Author lee;
  Author morrison;
  Book beloved;
  Author kafka;
  Book trial;

  Band ledZeppelin;
  RecordingArtist plant;
  RecordingArtist page;
  RecordingArtist jones;
  RecordingArtist bonham;
  ArrayList<RecordingArtist> zeppelin;
  Music byLedZeppelin;

  RecordingArtist coltrane;
  Music supreme;
  RecordingArtist davis;
  Music blue;
  RecordingArtist dylan;
  Music blonde;
  RecordingArtist crow;
  Music loveIs;


  @Before
  public void setUp() throws Exception {
    coltrane = new RecordingArtist("John", "Coltrane");
    supreme = new Music(coltrane, "A Love Supreme", 1964);
    davis = new RecordingArtist("Miles", "Davis");
    blue = new Music(davis, "Kind of Blue", 1959);
    dylan = new RecordingArtist("Bob", "Dylan");
    blonde = new Music(dylan, "Blonde on Blonde", 1966);
    crow = new RecordingArtist("Sheryl", "Crow");
    loveIs = new Music(crow, "Love Is A Good Thing", 1996);

    joyce = new Author("James", "Joyce");
    ulysses = new Book(joyce, "Ulysses", 1922);
    lee = new Author("Harper", "Lee");
    mockingbird = new Book(lee, "To Kill a Mockingbird", 1960);
    morrison = new Author("Toni", "Morrison");
    beloved = new Book(morrison, "Beloved", 1987);
    kafka = new Author("Franz", "Kafka");
    trial = new Book(kafka, "The Trial", 1925);

    plant = new RecordingArtist("Robert", "Plant");
    page = new RecordingArtist("Jimmy", "Page");
    jones = new RecordingArtist("John", "Jones");
    bonham = new RecordingArtist("John", "Bonham");
    zeppelin = new ArrayList<RecordingArtist>();
    zeppelin.add(plant);
    zeppelin.add(page);
    zeppelin.add(jones);
    zeppelin.add(bonham);
    ledZeppelin = new Band("Led Zeppelin", zeppelin);
    byLedZeppelin = new Music(ledZeppelin, "Stairway to Heaven", 1971);

    collection1 = new ArrayList<Item>();
    collection1.add(supreme);
    collection1.add(loveIs);
    collection1.add(blue);
    collection1.add(mockingbird);
    catalog1 = new Catalog(collection1);
    catalog1Description = "Catalog: " + "Recording Artist: John Coltrane Title: A Love Supreme Published Year: 1964" +
        "\nRecording Artist: Sheryl Crow Title: Love Is A Good Thing Published Year: 1996" +
        "\nRecording Artist: Miles Davis Title: Kind of Blue Published Year: 1959" +
        "\nAuthor: Harper Lee Title: To Kill a Mockingbird Published Year: 1960\n";

    collection4= new ArrayList<Item>(Arrays.asList(supreme, loveIs, blue, mockingbird));
    catalog4 = new Catalog(collection4);

    catalog2 = new Catalog();

    collection3 = new ArrayList<Item>();
    collection3.add(byLedZeppelin);
    collection3.add(blonde);
    collection3.add(ulysses);
    collection3.add(trial);
    collection3.add(beloved);
    catalog3 = new Catalog(collection3);
  }

  @Test
  public void getCollectionItems() {
    assertTrue(collection1.equals(catalog1.getCollectionItems()));
  }

  @Test
  public void addToCollection() throws ItemAlreadyPresentException {
    catalog1.addToCollection(ulysses);
    ArrayList<Item> ulyssesOnly = new ArrayList<Item>(Arrays.asList(ulysses));
    assertTrue(ulyssesOnly.equals(catalog1.search("ULYSSES")));
  }

  @Test(expected = ItemAlreadyPresentException.class)
  public void addToCollection1() throws ItemAlreadyPresentException {
    catalog1.addToCollection(blue);
  }

  @Test(expected = ItemNotInCollectionException.class)
  public void removeFromCollection() throws ItemNotInCollectionException, EmptyCollectionException {
    catalog1.removeFromCollection(trial);
  }

  @Test(expected = EmptyCollectionException.class)
  public void removeFromCollection1() throws ItemNotInCollectionException, EmptyCollectionException{
    catalog2.removeFromCollection(trial);
  }

  @Test
  public void removeFromCollection2() throws ItemNotInCollectionException, EmptyCollectionException {
    catalog1.removeFromCollection(blue);
    catalog1.removeFromCollection(mockingbird);
    ArrayList<Item> left = new ArrayList<Item>(Arrays.asList(supreme, loveIs));
    assertEquals(left, catalog1.getCollectionItems());
  }

  @Test
  public void search() {
    ArrayList<Item> containingLove = new ArrayList<Item>(Arrays.asList(supreme, loveIs));
    assertEquals(containingLove, catalog1.search("LOVE"));
  }

  @Test
  public void testSearch() {
    ArrayList<Book> byLee = new ArrayList<Book>(Arrays.asList(mockingbird));
    assertEquals(byLee, catalog1.search(lee));
  }

  @Test
  public void testSearch1() {
    ArrayList<Music> byZ = new ArrayList<Music>(Arrays.asList(byLedZeppelin));
    assertEquals(byZ, catalog3.search(bonham));
  }

  @Test
  public void testEquals() {
    assertTrue(catalog1.equals(catalog1));
    assertFalse(catalog1.equals(null));
    assertFalse(catalog1.equals(catalog1Description));
    assertFalse(catalog1.equals(catalog3));
    assertTrue(catalog1.equals(catalog4));

  }

  @Test
  public void testHashCode() {
    assertTrue(catalog1.hashCode() == catalog4.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(catalog1Description, catalog1.toString());
  }
}