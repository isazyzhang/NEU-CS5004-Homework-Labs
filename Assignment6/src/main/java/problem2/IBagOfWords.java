package problem2;

/**
 * This interface will be implemented by classes EmptyBagOfWords and NonEmptyBagOfWords.
 * @author Zu Yu Zhang
 */
public interface IBagOfWords {

  /**
   * Checks if the BagOfWords is empty. Returns true if the BagOfWords​contains no items,
   * false otherwise.
   *
   * @return whether the BagOfWords is empty
   */
  Boolean isEmpty();

  /**
   * Returns the number of elements in the BagOfWords. Duplicates should be counted as separate elements.
   *
   * @return the number of elements in the BagOfWords.
   */
  Integer size();

  /**
   * Returns a new BagOfWords that contains all elements in the original BagOfWords​plus s.
   *
   * @param s - The new word to be added
   * @return a new BagOfWords now containing the new word s
   */
  IBagOfWords add(String s);

  /**
   * Checks if s is in the ​BagOfWords​.Returns true if the BagOfWords​contains s​and false otherwise.
   *
   * @param s - The word for which we want to check existence in the BagOfWords
   * @return whether the given word is in the BagOfWords
   */
  Boolean contains(String s);

}