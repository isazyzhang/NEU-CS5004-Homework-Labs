package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class MusicTest {
  Music music1;
  RecordingArtist artist1;
  String title1;
  int year1;
  String music1Description;

  Music music2;
  RecordingArtist artist2;
  String title2;
  int year2;

  Music music3;

  Music music4;
  Band sisters;
  ArrayList<RecordingArtist> sis;
  RecordingArtist may;
  RecordingArtist june;
  String title4;
  int year4;


  @Before
  public void setUp() throws Exception {
    artist1 = new RecordingArtist("Pink", "Floyd");
    title1 = "The Wall";
    year1 = 1979;
    music1 = new Music(artist1, title1, year1);
    music1Description = "Recording Artist: Pink Floyd Title: The Wall Published Year: 1979";

    artist2 = new RecordingArtist("Michael", "Jackson");
    title2 = "Thriller";
    year2 = 1982;
    music2 = new Music(artist2, title2, year2);

    music3 = new Music(artist1, title1, year1);

    may = new RecordingArtist("May", "Cuoco");
    june = new RecordingArtist("June", "Fly");
    sis = new ArrayList<RecordingArtist>();
    sis.add(may);
    sis.add(june);
    sisters = new Band("Sista", sis);
    title4 = "Revolution";
    year4 = 2019;

    music4 = new Music(sisters, title4, year4);

  }

  @Test
  public void getCreator() {
    assertTrue(artist1.equals(music1.getCreator()));
  }

  @Test
  public void getTitle() {
    assertEquals(title1, music1.getTitle());
  }

  @Test
  public void getYear() {
    assertEquals(year1, music1.getYear());
  }

  @Test
  public void itemCreatedBy() {
    assertTrue(music1.itemCreatedBy(artist1));
    assertFalse(music1.itemCreatedBy(artist2));
  }

  @Test
  public void testEquals() {
    assertTrue(music1.equals(music1));
    assertFalse(music1.equals(null));
    assertFalse(music1.equals(music1Description));
    assertTrue(music1.equals(music3));
    assertFalse(music1.equals(music2));
  }

  @Test
  public void testHashCode() {
    assertTrue(music1.hashCode() == music3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(music1Description, music1.toString());
  }
}