package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class BandTest {
  Band coldplay;
  RecordingArtist chris;
  RecordingArtist guy;
  RecordingArtist will;
  RecordingArtist jonny;
  RecordingArtist phil;
  RecordingArtist random;
  ArrayList<RecordingArtist> members;
  ArrayList<RecordingArtist> missingOne;

  Band coldbrew;
  Band coldlight;
  Band coldhot;

  String cBandName;

  @Before
  public void setUp() throws Exception {
    chris = new RecordingArtist("Chris", "Martin");
    guy = new RecordingArtist("Guy", "Berryman");
    will = new RecordingArtist("Will", "Champion");
    jonny = new RecordingArtist("Jonny", "Buckland");
    phil = new RecordingArtist("Phil", "Harvey");
    random = new RecordingArtist("Jane", "Doe");
    cBandName = "Band: Coldplay";

    members = new ArrayList<RecordingArtist>();
    members.add(chris);
    members.add(guy);
    members.add(will);
    members.add(jonny);
    members.add(phil);

    missingOne = new ArrayList<RecordingArtist>();
    missingOne.add(chris);
    missingOne.add(guy);
    missingOne.add(will);
    missingOne.add(jonny);

    coldplay = new Band("Coldplay", members);
    coldbrew = new Band("Coldbrew", members);
    coldlight = new Band("Coldplay", members);
    coldhot = new Band("Coldbrew", missingOne);
  }

  @Test
  public void getBandName() {
    assertEquals("Coldplay", coldplay.getBandName());
  }

  @Test
  public void getMembers() {
    assertEquals(members, coldplay.getMembers());
  }

  @Test
  public void testEquals() {
    assertTrue(coldplay.equals(coldplay));
    assertFalse(coldplay.equals(null));
    assertFalse(coldplay.equals(cBandName));
    assertFalse(coldplay.equals(coldbrew));
    assertTrue(coldplay.equals(coldlight));
    assertFalse(coldbrew.equals(coldhot));
  }

  @Test
  public void testHashCode() {
    assertTrue(coldplay.hashCode() == coldlight.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(cBandName, coldplay.toString());
  }

  @Test
  public void sameCreator() {
    assertTrue(coldplay.sameCreator(jonny));
    assertFalse(coldplay.sameCreator(random));
  }
}