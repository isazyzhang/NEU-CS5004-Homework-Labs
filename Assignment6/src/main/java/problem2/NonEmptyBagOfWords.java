package problem2;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents a non-empty BagOfWords.
 * @author Zu Yu Zhang
 */
public class NonEmptyBagOfWords implements IBagOfWords {

  private String s;
  private IBagOfWords next;

  /**
   * Constructor for a non-empty BagOfWords. Consists of a "node" containing the first word.
   * @param s the first word in the BagOfWords
   * @param next the next element
   */
  public NonEmptyBagOfWords(String s, IBagOfWords next){
    this.s = s;
    this.next = next;
  }
  /**
   * Creates and returns an empty BagOfWords.
   *
   * @return an empty BagOfWords.
   */
  public static IBagOfWords emptyBagOfWords() {
    return new EmptyBagOfWords();
  }

  /**
   * Checks if the BagOfWords is empty. Returns true if the BagOfWords​contains no items, false
   * otherwise.
   *
   * @return whether the BagOfWords is empty
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Returns the number of elements in the BagOfWords. Duplicates should be counted as separate
   * elements.
   *
   * @return the number of elements in the BagOfWords.
   */
  @Override
  public Integer size() {
    return 1 + this.next.size();
  }

  /**
   * Returns a new BagOfWords that contains all elements in the original BagOfWords​plus s.
   *
   * @param s - The new word to be added
   * @return a new BagOfWords now containing the new word s
   */
  @Override
  public IBagOfWords add(String s) {
    NonEmptyBagOfWords updatedBagOfWords = new NonEmptyBagOfWords(s, this);
    return updatedBagOfWords;
  }

  /**
   * Checks if s is in the ​BagOfWords​.Returns true if the BagOfWords​contains s​and false
   * otherwise.
   *
   * @param s - The word for which we want to check existence in the BagOfWords
   * @return whether the given word is in the BagOfWords
   */
  @Override
  public Boolean contains(String s) {
    if(this.s.equals(s)){
      return true;
    }else{
      return this.next.contains(s);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonEmptyBagOfWords)) {
      return false;
    }
    NonEmptyBagOfWords that = (NonEmptyBagOfWords) o;
    int selfSize = this.size();
    int compareSize = ((NonEmptyBagOfWords) o).size();
    // If the two BagofWords do not contain the same number of words, return false
    if(selfSize != compareSize){
      return false;
    }
    String[] self = new String[selfSize];
    String[] other = new String[compareSize];

    IBagOfWords thisHead = this;
    for(int i = 0; i < selfSize; i++){
      self[i] = ((NonEmptyBagOfWords) thisHead).s;
      thisHead = ((NonEmptyBagOfWords) thisHead).next;
    }

    IBagOfWords otherHead = (IBagOfWords) o;
    for(int i = 0; i < compareSize; i++){
      other[i] = ((NonEmptyBagOfWords) otherHead).s;
      otherHead = ((NonEmptyBagOfWords) otherHead).next;
    }

    // Sort the two String arrays
    Arrays.sort(self);
    Arrays.sort(other);

    for(int i = 0; i < selfSize; i++){
      if(!(self[i].equals(other[i]))){
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(s, next);
  }

  @Override
  public String toString() {
    return "NonEmptyBagOfWords{" +
        "s=" + s +
        ", next=" + next +
        '}';
  }
}
