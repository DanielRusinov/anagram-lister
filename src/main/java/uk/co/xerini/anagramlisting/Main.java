package main.java.uk.co.xerini.anagramlisting;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader userInput = new BufferedReader(isr);
		String word = userInput.readLine();

		AnagramLister lister = new AnagramLister(new File("english2.txt"));
		
		List<String> anagrams = lister.listAnagrams(word);
		if(anagrams.isEmpty()) System.out.println("No anagrams found..");
		else for(String str : anagrams) System.out.println(str);
		
		userInput.close();
	}
}
