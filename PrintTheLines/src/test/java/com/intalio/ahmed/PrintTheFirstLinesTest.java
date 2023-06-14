package com.intalio.ahmed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class PrintTheFirstLinesTest {
	final static Logger LOGGER = Logger.getLogger(PrintTheFirstLinesTest.class.getName());

	@Test
	public void printTheLines() {
		PrintTheFirstLines PrintTheFirstLines = new PrintTheFirstLines();
		PrintTheFirstLines.printLines("C:\\io\\r.txt");
		assertEquals(true, PrintTheFirstLines.printLines("C:\\io\\r.txt"));
		assertEquals(false, PrintTheFirstLines.printLines("C:\\io\\ro.txt"));
		assertEquals(false, PrintTheFirstLines.printLines(""));

		File inputfile = new File("C:\\io\\r.txt");
		// Check if the file exist
		if (inputfile.exists()) {

			// Initializing a variable
			String line = null;
			// Initializing a variable for Buffer reader
			BufferedReader bufferedReader = null;
			// Initializing a variable
			int i = 0;
			try {
				bufferedReader = new BufferedReader(new FileReader(inputfile));
				LOGGER.log(Level.INFO, "Loaded the file in bufferreader variable");

				// print first 5 lines or all if file has less than 5 lines
				while (((line = bufferedReader.readLine()) != null) && i < 5) {
					// Printing the results
					System.out.println(line);
					// counter
					i++;
				}
			} catch (IOException e) {
				LOGGER.log(Level.ALL, e.getMessage());
			}
			finally {
				try {
					// closing buffer
					bufferedReader.close();
					LOGGER.log(Level.INFO, "Closed the bufferreader");

				} catch (IOException e) {
					LOGGER.log(Level.ALL, e.getMessage());
				}
			}
			assertEquals(5, i);

		} else {
			LOGGER.log(Level.WARNING, "File doesn't Exist");
		}

	}

}
