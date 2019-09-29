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
	
	public List<String> listAnagrams(String word) throws IOException {
		
		char[] temp1 = word.toCharArray();
		Arrays.sort(temp1);
		
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String lineInFile = null;
		
		ArrayList<String> anagrams = new ArrayList<>();
		
		while((lineInFile = fileReader.readLine()) != null){
			if(lineInFile.equals(word)) continue;
			else if(word.length() == lineInFile.length()){
				char[] temp2 = lineInFile.toCharArray();
				Arrays.sort(temp2);
				
				if(String.valueOf(temp1).equals(String.valueOf(temp2)))
					anagrams.add(lineInFile);
			}
		}
		
		if(anagrams.isEmpty()) System.out.println("No anagrams found..");
		
		fileReader.close();
		
		return anagrams;
	}
}
