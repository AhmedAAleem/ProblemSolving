package com.intalio.ahmed;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
//import java.io.IOException;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class ReplanceAllTheOccurancesOfaKeywordTest {
	final static Logger LOGGER = Logger.getLogger(ReplanceAllTheOccurancesOfaKeywordTest.class.getName());

	@Test
	public void checkNotExistingFile() {
		// Expected result should be the not existing file
		try {
			ReplanceAllTheOccurancesOfaKeyword replanceAllTheOccurancesOfaKeyword = new ReplanceAllTheOccurancesOfaKeyword();
			assertEquals(true, replanceAllTheOccurancesOfaKeyword.replcaement("C:\\io\\Read.txt"));
			assertEquals(false, replanceAllTheOccurancesOfaKeyword.replcaement("C:\\io\\eee.txt"));

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void checkNormalScenario() {
		String FileReaderPath = "C:\\io\\Read.txt";
		String FileWriterPath = "C:\\io\\w.txt";
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;

		String stringArray = null;
		String replacer = "Hossam";

		try {
			// declare a char variable to read the file
			char[] array = ReplanceAllTheOccurancesOfaKeyword.ReadFileToCharArray(FileReaderPath);
			// Creates a FileOutputStream
			fileOutputStream = new FileOutputStream(FileWriterPath);
			// Creates an OutputStreamWriter and surround it by try with recourses
			outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			// converting char to string
			stringArray = String.valueOf(array);
			stringArray.equalsIgnoreCase(stringArray);
			// Replacement of string to another one
			stringArray = stringArray.replaceAll("(?i)ahmed", "Empty");
			// Print a message for completing the process
			System.out.println("the output done successfully");
			// writing in the new file
			outputStreamWriter.write(stringArray);
			System.out.println(stringArray);

		} catch (FileNotFoundException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());

		} finally {
			try {
				// closing the buffers
				outputStreamWriter.close();
				fileOutputStream.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage());

			}
		}
		int i = 0;
		while (i == stringArray.length()) {
			
			assertEquals(replacer, stringArray);
			// counter
			i++;
		}

	}
}
