package printLines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class printTheFirstFifthOnly {

	final static Logger LOGGER = Logger.getLogger(printTheFirstFifthOnly.class.getName());

	public static void main(String[] args) {

		// Initializing a variable for file path
		String filePath = "C:\\io\\r.txt";
		// Initializing a variable
		String line = null;
		// Initializing a variable for Buffer reader
		BufferedReader bufferedReader = null;
		// Initializing a variable
		int i = 0;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
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
	}

}
