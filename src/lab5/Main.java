package lab5;

import java.util.HashMap;

public class Main {
	
	// ==== EXTENSION IDEAS ====
	// WordGroup.java:
	// - WordGroup is an immutable class (if you make words private)
	// - If is immutable, then `words` will be `private final String words`
	// - `getWordArray()` and `getWordCounts()` methods return the same Object (contents) all the time
	//   so store `private final String[] wordArray` and `private final HashMap<String, Integer> wordCounts`
	//   and precompute them in the constructor
	// - Return the Data-Structure instead of the Implementation, so `Map<String, Integer>` and `Set<String>`
	//   instead of HashMap (implementation) and HashSet (implementation)
	// - Since we already have a Map<String, Integer> stored as wordCounts, we need not iterate over an array
	//   to build new HashSet, we simply use set.addAll(wordCounts.keySet()) to this wordGroup and
	//   set.addAll(wg.getWordCounts().keySet()) which are both precomputed assuming `set` is the
	//   return value of `getWordSet()`

	// app entry point
	public static void main(String[] args) {
		// ==== BEGIN PART 1 ====
		printPartBanner(1);
		
		// create two wordgroups with quotes from the page and assign them to wg1 and wg2
		WordGroup wg1 = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
		WordGroup wg2 = new WordGroup("When you play play hard when you work dont play at all");
		
		// get the String[] (String array) corresponding to these WordGroups
		String[] wa1 = wg1.getWordArray();
		String[] wa2 = wg2.getWordArray();
		
		// debug string makes things easier to read
		System.out.println("contents of WordGroup 1");
		
		// two different For-Loops
		// this is the "enchanced" For-Loop
		for (String s : wa1) {
			System.out.println(s);
		}
		
		// separator string
		System.out.println("contents of WordGroup 2");
		
		// this is the standard loop with initialiser, conditioner and incrementer
		// i is initialised to 0, and incremeted with a step of 1 until it reaches the
		// word array length.
		for (int i = 0; i < wa2.length; i++) {
			System.out.println(wa2[i]);
		}
		
		// ==== BEGIN PART 2 ====
		printPartBanner(2);
		
		// iterate over the HashSet returned by the calling the
		// class method getWordSet of wg1 against wg2 as a parameter
		// print the strings in the set
		for (String s : wg1.getWordSet(wg2)) {
			System.out.println(s);
		}
		
		// ==== BEGIN PART 3 ====
		printPartBanner(3);
		
		// retrieve the HashMaps of String to Integer of both WordGroups
		HashMap<String, Integer> wc1 = wg1.getWordCounts();
		HashMap<String, Integer> wc2 = wg2.getWordCounts();
		
		System.out.println("WordGroup 1's getWordCounts()");
		
		// iterate over keySet of WordGroup 1 and print out word and count
		for (String s : wc1.keySet()) {
			// associated count for String s is retrieved by calling .get(String key)
			System.out.println(s + "\t" + wc1.get(s));
		}
		
		System.out.println("WordGroup 2's getWordCounts()");

		// same logic as for wc1
		for (String s : wc2.keySet()) {
			System.out.println(s + "\t" + wc2.get(s));
		}
		
		System.out.println("Words + Counts in both WordGroup 1 and WordGroup 2");
		
		// iterate over set of words in wg1 and wg2 (union of words in wc1 and wc2)
		for (String s : wg1.getWordSet(wg2)) {
			// initialise a sum (accumulator) to store occurence values
			int sum = 0;
			
			// increment accumulator by wc1 value if exists
			if (wc1.containsKey(s))
				sum += wc1.get(s);
			
			// increment accumulator by wc2 value if exists
			if (wc2.containsKey(s))
				sum += wc2.get(s);
			
			// print resulting output
			System.out.println(s + "\t" + sum);
		}

	}
	
	/**
	 * Helper method to print out banners to distinguish between parts
	 * 
	 * @param part the number representing the part being worked on
	 */
	public static void printPartBanner(int part) {
		System.out.println("==== BEGIN PART " + part + " ====");
	}

}
