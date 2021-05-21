package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordingArtistTest {
  RecordingArtist artist1;
  RecordingArtist artist2;
  RecordingArtist artist3;
  String artist1Name;

  @Before
  public void setUp() throws Exception {
    artist1 = new RecordingArtist("William", "Greene");
    artist2 = new RecordingArtist("William", "White");
    artist3 = new RecordingArtist("William", "Greene");
    artist1Name = "Recording Artist: William Greene ";
  }

  @Test
  public void getFirstName() {
    assertEquals("William", artist1.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Greene", artist1.getLastName());
  }

  @Test
  public void sameCreator() {
    assertTrue(artist1.sameCreator(artist3));
    assertFalse(artist1.sameCreator(artist2));

  }

  @Test
  public void testEquals() {
    assertTrue(artist1.equals(artist1));
    assertFalse(artist1.equals(null));
    assertFalse(artist1.equals(artist1Name));
    assertTrue(artist1.equals(artist3));
    assertFalse(artist1.equals(artist2));
  }

  @Test
  public void testHashCode() {
    assertTrue(artist1.hashCode() == artist3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(artist1Name, artist1.toString());
  }
}