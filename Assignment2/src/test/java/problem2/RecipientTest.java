package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipientTest {
  private Recipient me;

  @Before
  public void setUp() throws Exception {
    me = new Recipient("Isabella", "Zhang", "zhang@yahoo.com");
  }

  @Test
  public void getFirstName() {
    assertEquals("Isabella", me.getFirstName());
  }

  @Test
  public void setFirstName() {
    me.setFirstName("Zuyu");
    assertEquals("Zuyu", me.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Zhang", me.getLastName());
  }

  @Test
  public void setLastName() {
    me.setLastName("Wang");
    assertEquals("Wang", me.getLastName());
  }

  @Test
  public void getEmail() {
    assertEquals("zhang@yahoo.com", me.getEmail());
  }

  @Test
  public void setEmail() {
    me.setEmail("isabella@gmail.com");
    assertEquals("isabella@gmail.com", me.getEmail());
  }
}