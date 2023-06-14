package com.intalio.ahmed;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReplanceAllTheOccurancesOfaKeyword {
	final static Logger LOGGER = Logger.getLogger(ReplanceAllTheOccurancesOfaKeyword.class.getName());

	public static char[] ReadFileToCharArray(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		// Creates an array of character
		char[] buf = new char[10];
		// declare a variable
		int numRead = 0;
		// while loop for reading
		while ((numRead = reader.read(buf)) != -1) {
//			System.out.println(numRead);
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		// closing the reader
		reader.close();
		LOGGER.log(Level.INFO, "Close the Reader");
		return fileData.toString().toCharArray();
	}

//	public static void main(String[] args) {
	public boolean replcaement(String FileReaderPath) throws NullPointerException {
		
		// declare the variables
//		String FileReaderPath = "C:\\io\\Read.txt";
		String FileWriterPath = "C:\\io\\w.txt";
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;

		try {
			// declare a char variable to read the file
			char[] array = ReadFileToCharArray(FileReaderPath);
			// Creates a FileOutputStream
			fileOutputStream = new FileOutputStream(FileWriterPath);
			// Creates an OutputStreamWriter and surround it by try with recourses
			outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			// converting char to string
			String stringArray = String.valueOf(array);
			stringArray.equalsIgnoreCase(stringArray);
			// Replacement of string to another one
			stringArray = stringArray.replaceAll("(?i)ahmed", "Hossam");
			// Print a message for completing the process
			System.out.println("the output done successfully");
			// writing in the new file
			outputStreamWriter.write(stringArray);
			System.out.println(stringArray);
			return true;
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			return false;
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			return false;
		} finally {
			try {
				// closing the buffers
				outputStreamWriter.close();
				fileOutputStream.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage());
				return false;
			}
		}

	}
}
