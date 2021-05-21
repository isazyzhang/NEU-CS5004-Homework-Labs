package problem2;

import java.util.Arrays;
import java.util.Objects;

/**
 * A mathematical Set represents an unordered collection of unique values. A Set expands as items
 * are added. This class is immutable.
 * @author Zu Yu Zhang
 */
public class Set{

  private Integer[] items;
  private int size;
  private static final int NUM_SLOT = 1;

  /**
   * Constructor for a Set. Underlying data structure: integer array of length 1
   */
  public Set(){
    this.items = new Integer[NUM_SLOT];
    this.size = 0;

  }
  /**
   * Alternative constructor to be used by add() and remove() methods; a new Set is returned, but it
   * is not empty; instead it is already initialized with the items it contains and its size.
   *
   * @param items the elements that the Set contains
   * @param size number of elements currently in the Set
   */
  public Set(Integer[] items, int size){
    this.items = items;
    this.size = size;
  }

  /**
   * Creates and returns an empty set.
   *
   * @return an empty set
   */
  public static Set emptySet(){
    return new Set();
  }

  /**
   * Gets the list of integers contained in the Set
   *
   * @return the integers in the Set
   */
  public Integer[] getItems() {
    return this.items;
  }

  /**
   * Gets the size of the Set
   *
   * @return the number of integers in the Set
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Checks if the Set is empty.
   *
   * @return whether the set is empty
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Adds an integer to the Set if and only if that Integer is not already in the Set.
   *
   * @param n the integer to be added to the Set
   * @return a new Set object with the integer added if it was not already present, and the original
   * set if it was already in the Set
   */
  public Set add(Integer n) {
    for(int i = 0; i < this.size; i++){
      //Traverse the whole Set, as soon as we find that the integer is already present, return the
      //original set.
      if(this.items[i] == n){
        return new Set(this.items, this.size);
      }
    }

    // If the Integer is not in the Set, add it
    Integer[] newSize = new Integer[this.size + 1];
    for(int i = 0; i < this.size; i++){
      newSize[i] = this.items[i];
    }
    newSize[this.size] = n;
    size++;
    return new Set(newSize, this.size);
}

  /**
   * Checks if a given integer is in the Set.
   *
   * @param n the integer for which presence is checked in the Set
   * @return whether the given integer is in the Set.
   */
  public boolean contains(Integer n) {
    for(int i = 0; i < this.size; i++){
      if(this.items[i] == n){
        return true;
      }
    }
    return false;
  }

  /**
   * Removes an integer from the Set.
   *
   * @param n the integer to be removed
   * @return a new Set object with the given integer removed if it was in the Set, and the original
   * Set if the integer was not present.
   */
  public Set remove(Integer n) {
    for(int i = 0; i < this.size; i++){
      if(this.items[i] == n){
        // Create a new Integer array containing one less slot
        int newSize = this.size - 1;
        Integer[] afterRemoval = new Integer[newSize];
        // Copy the leftover elements into the new array
        for(int j = 0; j < i; j++){
          afterRemoval[j] = this.items[j];
        }
        for(int j = i; j < newSize; j++){
          afterRemoval[j] = this.items[j + 1];
        }

        this.size--;
        return new Set(afterRemoval, this.size);
      }
    }
    // If the specified integer is not in the Set, return the original Set
    return new Set(this.items, this.size);
  }

  /**
   * Gets the number of items in the Set.
   *
   * @return the number of items in the Set
   */
  public Integer size() {
    return this.size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Set)) {
      return false;
    }
    Set set = (Set) o;
    if(getSize() != set.getSize()){
      return false;
    }

    // For Sets having the same size, as long as they contain the same element, they are considered
    // as same sets (not necessarily in order)
    Arrays.sort(getItems());
    Arrays.sort(set.getItems());
    for(int i = 0; i < getItems().length; i++){
      if(getItems()[i] != set.getItems()[i]){
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getSize());
    result = 31 * result;
    for(int i = 0; i < this.size; i++){
      result += Objects.hash(this.items[i]);
    }
    return result;
  }

  @Override
  public String toString() {
    return "{" +
        Arrays.toString(this.items).replaceAll("\\[", "").replaceAll("\\]", "")
        + '}';
  }
}
