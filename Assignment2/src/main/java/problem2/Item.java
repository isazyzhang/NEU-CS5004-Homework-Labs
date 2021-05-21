package problem2;

/**
 * The superclass for Mail class and Locker class; represents an Item with dimensions (width,
 * height, and depth)
 * @author Zu Yu Zhang
 */

public class Item {

  private int width;
  private int height;
  private int depth;
  private static final int MIN_DIMENSION = 1;

  /**
   * Creates a new Item object initialized with its width, height, depth.
   * @param width width of the item
   * @param height height of the item
   * @param depth depth of the item
   * @throws InvalidDimensionException if the dimension(s) is(are) invalid
   */
  public Item(int width, int height, int depth) throws InvalidDimensionException {
    //allows user to construct a new Item if and only if all the dimensions are valid
    if (this.validDimension(width) && this.validDimension(height) && this.validDimension(depth)) {
      this.width = width;
      this.height = height;
      this.depth = depth;
    } else {
      throw new InvalidDimensionException();
    }
  }

  /**
   * Helper method to check if user-specified width/height/depth are valid.
   * @param dimension width/height/depth of the Locker
   */
  private boolean validDimension(int dimension){
    if(dimension >= MIN_DIMENSION){
      return true;
    }else{
      return false;
    }
  }

  /**
   * Gets the width of the item.
   * @return the item's width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Sets the width of the item (only if the new width is valid).
   * @param width new width of the item
   * @throws InvalidDimensionException if the new width doesn't meet the requirement
   */
  public void setWidth(int width) throws InvalidDimensionException{
    if(this.validDimension(width)) {
      this.width = width;
    }else{
      throw new InvalidDimensionException();
    }
  }

  /**
   * Gets the height of the item.
   * @return the item's height
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Sets the height of the item (only if the new height is valid).
   * @param height new height of the item
   * @throws InvalidDimensionException if the new height doesn't meet the requirement
   */
  public void setHeight(int height) throws InvalidDimensionException {
    if(this.validDimension(height)) {
      this.height = height;
    }else{
      throw new InvalidDimensionException();
    }
  }

  /**
   * Gets the depth of the item.
   * @return the item's depth
   */
  public int getDepth() {
    return this.depth;
  }

  /**
   * Sets the depth of the item (only if the new depth is valid).
   * @param depth new depth of the item
   * @throws InvalidDimensionException if the new height doesn't meet the requirement
   */
  public void setDepth(int depth) throws InvalidDimensionException {
    if (this.validDimension(depth)){
      this.depth = depth;
    }else{
      throw new InvalidDimensionException();
    }

  }
}
