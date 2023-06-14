package com.intalio.ahmed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PrintShortestAndLongestWordTest {
	final static Logger LOGGER = Logger.getLogger(PrintShortestAndLongestWordTest.class.getName());

	@Test
	public void checkNotExistingFile() {
		// Expected result should be the not existing file
		PrintShortestAndLongestWord printShortestAndLongestWord = new PrintShortestAndLongestWord();
		try {
			assertEquals(true, printShortestAndLongestWord.printTheWord("C:\\io\\s.txt"));
			assertEquals(false, printShortestAndLongestWord.printTheWord("C:\\io\\sos.txt"));
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			}
	}

	@Test
	public void checkNormalScenario() {
		// Expected result should be a log with the not existing file

		PrintShortestAndLongestWord printShortestAndLongestWord = new PrintShortestAndLongestWord();

		try {
			boolean result = printShortestAndLongestWord.printTheWord("C:\\io\\s.txt");
			String expectedLongestWord = "non-characteristic";
			String expectedShortestWord = "a";

			String resultLongestWord = printShortestAndLongestWord.getLongestWord();
			String resultShortestWord = printShortestAndLongestWord.getShortestWord();

			// if the function returns false that means the file is not exist
			assertEquals(true, result && expectedLongestWord.equals(resultLongestWord)
					&& expectedShortestWord.equals(resultShortestWord));

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}

	}
}
