package wordTree.util;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileProcessor {
	
	private Scanner sc = null;
	private String word = null;

	/**
	 * constructor for FileProcessor
	 * @param inputFile - file to be processed
	 * @throws FileNotFoundException
	 */
	public FileProcessor(String inputFile) throws FileNotFoundException{
		MyLogger.writeMessage("FileProcessor constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		sc = new Scanner(new File(inputFile));
	}

	/**
	 * synchronized method to read word from file word by word
	 * @return one line at a time from the input file
	 */
	public synchronized String readLine() {
		
		try {
			if(sc != null) {
				
				while(sc.hasNext()) {
					word = sc.next();
					return word;
				}
			}
			else {
				throw new RuntimeException("unable to open file");
			}
			return null;
		}
		catch(Exception e) {
			System.err.println(e + " occurred during readLine");
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
