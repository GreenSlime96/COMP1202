package lab5;

import java.util.HashMap;
import java.util.HashSet;

public class WordGroup {
	// instance variable storing lowercase words
	private String words;

	/**
	 * Constructor of a WordGroup taking a String of words and stores them in
	 * instance variable after converting them to lowercase.
	 * 
	 * @param words
	 *            a String of words
	 */
	public WordGroup(String words) {
		this.words = words.toLowerCase();
	}

	/**
	 * Returns an array of lower-case Strings which split the words by a space
	 * delimiter.
	 * 
	 * @return array of lowercase Strings which are the words split by a " "
	 */
	public String[] getWordArray() {
		return words.split(" ");
	}

	/**
	 * Takes another WordGroup as a parameter and returns a (Hash)Set of Strings
	 * that are contained in both this and the other WordGroup. A set implies no
	 * repetitions by default.
	 * 
	 * Side-comment... I used wordGroup to name the WordGroup parameter
	 * received. This is just to score marks, in reality I would prefer (and I'm
	 * sure demonstrators) agree that `wg` works just as fine. Look at
	 * Object.equals or Comparator, they use `o` and `e`!
	 * 
	 * @param wordGroup
	 *            the WordGroup whose words we will add to our set
	 * @return a (Hash)Set of Strings contained in this and given WordGroup
	 */
	public HashSet<String> getWordSet(WordGroup wordGroup) {
		HashSet<String> wordSet = new HashSet<String>();

		// adds words from this WordGroup to the Set (`this.` omitted)
		for (String s : getWordArray()) {
			wordSet.add(s);
		}

		// adds words from the given WordGroup to the set
		for (String s : wordGroup.getWordArray()) {
			wordSet.add(s);
		}

		return wordSet;
	}

	/**
	 * Returns a HashMap mapping Strings in this WordGroup to an Integer (the
	 * number of times this String occurs in the WordGroup).
	 * 
	 * @return a HashMap<String, Integer> containing the words in this WordGroup
	 *         as well as the number of times they appear
	 */
	public HashMap<String, Integer> getWordCounts() {
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

		// iterate over array... I shouldn't be writing this as it is
		// SELF-EXPLANATORY
		for (String s : getWordArray()) {
			// check if the word has been encountered before
			if (wordMap.containsKey(s)) {
				// word exists in the map, so we can get the assigned value and
				// increment it by `1` storing it back into the map
				wordMap.put(s, wordMap.get(s) + 1);
			} else {
				// word doesn't exist in map, we encounter it for the first time
				// therefore we assign `1` to it
				wordMap.put(s, 1);
			}
		}

		return wordMap;
	}

}
