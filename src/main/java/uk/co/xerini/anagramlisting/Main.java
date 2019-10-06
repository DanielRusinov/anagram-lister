package main.java.uk.co.xerini.anagramlisting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader fileReader = new BufferedReader(new FileReader("english2.txt"));
		String lineInFile = null;
		
		List<String> validWords = new ArrayList<String>();
		while((lineInFile = fileReader.readLine()) != null) {
			validWords.add(lineInFile);
		}
		
		fileReader.close();
		
		AnagramLister lister = new AnagramLister(validWords);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader userInput = new BufferedReader(isr);
		
		String word = null;
		
		while((word = userInput.readLine()) != null) {

			List<String> anagrams = lister.listAnagrams(word);
			if(anagrams.isEmpty()) System.out.println("No anagrams found..");
			else for(String str : anagrams) System.out.println(str);
		}
		
		userInput.close();
	}
}
