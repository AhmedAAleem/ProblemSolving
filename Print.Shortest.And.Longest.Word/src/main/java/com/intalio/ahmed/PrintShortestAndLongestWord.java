package com.intalio.ahmed;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintShortestAndLongestWord {
	final static Logger LOGGER = Logger.getLogger(PrintShortestAndLongestWord.class.getName());

	private String shortestWord = "";
	private String longestWord = "";

	// Creating a method for reading the file
	public static char[] ReadFileToCharArray(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		// Creates an array of character
		char[] buf = new char[10];
		// declare a variable
		int numRead = 0;
		// while loop for reading
		while ((numRead = reader.read(buf)) != -1) {
//				System.out.println(numRead);
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		// closing the reader
		reader.close();
		LOGGER.log(Level.INFO, "Closed the Reader");
		return fileData.toString().toCharArray();
	}

	public boolean printTheWord(String filePath) throws IOException {
	

		// Check if the file exist
		try {

			String fileContent = new String(ReadFileToCharArray(filePath));
			fileContent = fileContent.replace("  ", " ");
			fileContent = fileContent.replace(",", " ");
			String[] spaces = fileContent.split(" ");
			// Creates and array of string
			List<String> list = Arrays.asList(spaces);
			// declare a variable

			// For Loop
			for (String word : list) {
				if (word.length() > longestWord.length()) {
					longestWord = word;
				}
			}
			// declare a variable
			shortestWord = longestWord;
			for (String word : list) {
				if (word.length() < shortestWord.length() && word.length() > 0) {
					shortestWord = word;
				}
			}
			// Printing the results
			System.out.println("Longest Word: " + longestWord);
			System.out.println("Shortest Word: " + shortestWord);
			return true;
		} catch (FileNotFoundException f) {
			LOGGER.log(Level.SEVERE, f.getMessage());
			throw new IOException("File Not Found");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			throw new IOException("IO Error");
		}

	}

	public String getShortestWord() {
		return shortestWord;
	}

	public String getLongestWord() {
		return longestWord;
	}

}