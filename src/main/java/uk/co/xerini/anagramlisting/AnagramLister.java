package main.java.uk.co.xerini.anagramlisting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableList; 

public class AnagramLister {
	
	private final ImmutableList<String> validWords;
	private final HashMap<String, List<String>> resultMap = new HashMap<>();
	
	public AnagramLister(List<String> list) {
		this.validWords = ImmutableList.copyOf(list);
	}

	public List<String> getList() {
		return validWords;
	}

	/**
	Converts a input string to character array and sorts it.
	Then it searches for a word with the same length from the file,
	converts it to character array, sorts it and then compares the 
	string value of both arrays. 
	
	@param input 	console input
	@return 		list of all anagrams of the input from the file
	*/	
	public List<String> listAnagrams(String input) throws IOException {

		if(resultMap.containsKey(input)) {
			return resultMap.get(input);
		} else {
			char[] inputArray = input.toCharArray();
			Arrays.sort(inputArray);
			
			ArrayList<String> anagrams = new ArrayList<>();
			
			for(String word : validWords) {
				if(word.equals(input)) continue;
				else if(input.length() == word.length()){
					char[] wordArray = word.toCharArray();
					Arrays.sort(wordArray);
					
					if(String.valueOf(inputArray).equals(String.valueOf(wordArray)))
						anagrams.add(word);
				}
			}
			
			resultMap.put(input, anagrams);
			
			return anagrams;
		}
	}
}
