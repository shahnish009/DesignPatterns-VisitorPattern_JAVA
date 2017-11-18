package fileVisitors.store;

import wordTree.util.StdoutDisplayInterface;
import wordTree.util.FileDisplayInterface;
import wordTree.util.MyLogger;
import java.io.FileNotFoundException;
import java.lang.RuntimeException;
import java.util.ArrayList;
import java.io.PrintWriter;

public class Results implements StdoutDisplayInterface, FileDisplayInterface{
	
	private String outputFile;	
	private ArrayList<String> storeResults = new ArrayList<String>();
	
	/**
	 * constructor for results
	 * @param outputFileIN - file for writing Result
	 */
	public Results(String outputFileIN) {
		MyLogger.writeMessage("Results constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		outputFile = outputFileIN;
	}

	public void writeToStdout() {
		for(String op : storeResults) {
			MyLogger.writeMessage(op, MyLogger.DebugLevel.FROM_RESULTS);
		}
	}
	
	/**
	 * method to write to file
	 * @throws FileNotFoundException
	 */
	public void writeToFile() throws FileNotFoundException {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(outputFile);
		}
		catch(FileNotFoundException e) {
			System.err.println("OutputFile cannot be created");
			e.printStackTrace();
			System.exit(1);
		}
		
		for(String op : storeResults) {
			pw.println(op);
		}
		pw.close();
	}
	
	/**
	 * @param s - string to be added to results
	 */
	public void storeNewResult(String s) {
		storeResults.add(s);
	}
}
