package test.java.uk.co.xerini.anagramlisting;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
	
import main.java.uk.co.xerini.anagramlisting.AnagramLister;

import org.junit.BeforeClass;
import org.junit.Test;


public class AnagramListerTest {
	
	private static File file;
	private static AnagramLister lister;

	@BeforeClass
	public static void setup() {
		file = new File("english2.txt");
		lister = new AnagramLister(file);
	}
	
	@Test
	public void testNumberOfAnagramsInList() throws IOException {
		String message = "Number of listed anagrams is not correct";
		assertEquals(message, 1, lister.listAnagrams("dog").size());
		assertEquals(message, 2, lister.listAnagrams("read").size());
		assertEquals(message, 4, lister.listAnagrams("listen").size());
	}
	
	@Test
	public void testIfListIsEmpty() throws IOException {
		assertTrue("List should be empty" , lister.listAnagrams("dot").isEmpty());
		assertFalse("List souldn't be empty", lister.listAnagrams("listen").isEmpty());
	}
	
	@Test
	public void testRetunedListIsSameAsCustom() throws IOException {
		List<String> list = Arrays.asList("enlist", "listen", "tinsel", "inlets");
		assertTrue("Lists sizes doesn't match", list.size() == lister.listAnagrams("silent").size());
		assertTrue("Entities doesn't match", list.containsAll(lister.listAnagrams("silent")));
	}	
}	
