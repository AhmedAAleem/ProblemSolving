package appendString;

import java.io.FileWriter;
import java.io.IOException;

public class AppendStringToText {
	public static void main(String[] args) {

		// Initializing a variable for file path
		String filePath = "C:\\io\\MyFile.txt";
		// Initializing a variable for file writer
		FileWriter fileWriter = null;

		try {
			// the true will append the new data
			fileWriter = new FileWriter(filePath, true);

			// appends the string to the file
			fileWriter.write("add a line\n");

		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe.getMessage());
		} finally {
			// Closing the file writer
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					System.err.println("IOException: " + e.getMessage());
				}
			}
		}
	}
}