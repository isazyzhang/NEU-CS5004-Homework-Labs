package problem2;

/**
 * This class represents an empty BagOfWords.
 * @author Zu Yu Zhang
 */
public class EmptyBagOfWords implements IBagOfWords {

  private static final int MADE_UP_HASHCODE = 31;

  /**
   * Constructor for an empty BagOfWords.
   */
  public EmptyBagOfWords(){
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
    return true;
  }

  /**
   * Returns the number of elements in the BagOfWords. Duplicates should be counted as separate
   * elements.
   *
   * @return the number of elements in the BagOfWords.
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * Returns a new BagOfWords that contains all elements in the original BagOfWords​plus s.
   *
   * @param s - The new word to be added
   * @return a new BagOfWords now containing the new word s
   */
  @Override
  public IBagOfWords add(String s) {
    return new NonEmptyBagOfWords(s, this);
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
    return false;
  }

  @Override
  public int hashCode() {
    return MADE_UP_HASHCODE;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    return true;
  }

  @Override
  public String toString() {
    return "EmptyBagOfWords{}";
  }
}
