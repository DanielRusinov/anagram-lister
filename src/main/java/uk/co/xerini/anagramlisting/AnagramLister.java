package main.java.uk.co.xerini.anagramlisting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramLister {
	
	private File file;

	public AnagramLister(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
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
		
		char[] inputArray = input.toCharArray();
		Arrays.sort(inputArray);
		
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String lineInFile = null;
		
		ArrayList<String> anagrams = new ArrayList<>();
		
		while((lineInFile = fileReader.readLine()) != null){
			if(lineInFile.equals(input)) continue;
			else if(input.length() == lineInFile.length()){
				char[] lineInFileArray = lineInFile.toCharArray();
				Arrays.sort(lineInFileArray);
				
				if(String.valueOf(inputArray).equals(String.valueOf(lineInFileArray)))
					anagrams.add(lineInFile);
			}
		}
		
		fileReader.close();
		
		return anagrams;
	}
}
