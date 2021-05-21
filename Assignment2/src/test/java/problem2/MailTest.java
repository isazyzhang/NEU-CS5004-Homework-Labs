package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailTest {
  private Recipient jake;
  private Mail jakeMail;

  @Before
  public void setUp() throws Exception {
    jake = new Recipient("Jake", "Marshall", "jake@111.com");
    jakeMail = new Mail(1, 1, 1, jake);
  }

  @Test
  public void getRecipient() {
    assertTrue(jake.equals(jakeMail.getRecipient()));
  }

  @Test
  public void setRecipient() {
    Recipient mike = new Recipient("Mike", "Lala", "mike@amazon.com");
    jakeMail.setRecipient(mike);
    assertTrue(mike.equals(jakeMail.getRecipient()));
  }
}