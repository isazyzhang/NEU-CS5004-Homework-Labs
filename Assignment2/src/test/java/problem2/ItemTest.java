package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Lunch;

public class ItemTest {
  private Item valid;

  @Before
  public void setUp() throws Exception {
    valid = new Item(2, 2, 2);
  }

  @Test(expected = InvalidDimensionException.class)
  public void constructorExceptionTest1() throws InvalidDimensionException {
    Item invalidWidth = new Item(0, 9, 9);
  }

  @Test(expected = InvalidDimensionException.class)
  public void constructorExceptionTest2() throws InvalidDimensionException{
    Item invalidHeight = new Item(2, -100, 7);
  }

  @Test(expected = InvalidDimensionException.class)
  public void constructorExceptionTest3() throws InvalidDimensionException{
    Item invalidDepth = new Item(2, 2, 0);
  }

  @Test
  public void getWidth() {
    assertEquals(2, valid.getWidth());
  }

  @Test
  public void setWidth() throws InvalidDimensionException {
    valid.setWidth(5);
    assertEquals(5, valid.getWidth());
  }

  @Test(expected = InvalidDimensionException.class)
  public void setInvalidWidth() throws InvalidDimensionException{
    valid.setWidth(-100);
  }

  @Test
  public void getHeight() {
    assertEquals(2, valid.getHeight());
  }

  @Test
  public void setHeight() throws InvalidDimensionException {
    valid.setHeight(10);
    assertEquals(10, valid.getHeight());
  }

  @Test(expected = InvalidDimensionException.class)
  public void setInvalidHeight() throws InvalidDimensionException{
    valid.setHeight(0);
  }

  @Test
  public void getDepth() {
    assertEquals(2, valid.getDepth());
  }

  @Test
  public void setDepth() throws InvalidDimensionException {
    valid.setDepth(100);
    assertEquals(100, valid.getDepth());
  }

  @Test(expected = InvalidDimensionException.class)
  public void setInvalidDepth() throws InvalidDimensionException{
    valid.setDepth(-10);
  }
}