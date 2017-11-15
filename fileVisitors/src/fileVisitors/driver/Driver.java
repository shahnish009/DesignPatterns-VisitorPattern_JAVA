package wordTree.driver;

import java.lang.NumberFormatException;
import java.lang.RuntimeException;
import wordTree.store.Results;
import wordTree.util.MyLogger;
import wordTree.util.FileProcessor;
import wordTree.util.TreeBuilder;
import wordTree.store.Results;
import wordTree.threadMgmt.CreateWorkers;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class Driver {
	
	/**
	 * main method in Driver class
	 * @param args
	 */
	public static void main(String[] args) {

		String ipFile = null;
		String opFile = null;
		
		String[] dlWords = null;
		
		int NUM_THREADS = 0;
		int debugValueSetter = -1;
		
		FileProcessor fileP = null;
		Results r = null;
	    TreeBuilder tb = null;
		
		try {
			if(5 == args.length) {
       	        ipFile = args[0];
	            opFile = args[1];
	            
	            NUM_THREADS = Integer.parseInt(args[2]);
	            if(!(NUM_THREADS >= 1 && NUM_THREADS <= 3)) {
	            	throw new RuntimeException("Number of threads must be integers between 1 and 3 inclusive");
	            }
	            
	            dlWords = args[3].split("\\s+");
	            if(!(NUM_THREADS == dlWords.length)) {
	            	throw new RuntimeException("Delete words should be same as number of threads");
	            }
	            
	            debugValueSetter = Integer.parseInt(args[4]);
	            if(!(debugValueSetter >= 0 && debugValueSetter <= 4)) {
	            	throw new RuntimeException("Debug value must be integers between 0 and 4 inclusive");
	            }
	            MyLogger.setDebugValue(debugValueSetter);
			}
			else {
				throw new RuntimeException("Invalid number of arguments. Please enter 5 arguments");
			}
		}
		catch (Exception e) {
			System.err.println("exception occurred while parsing arguments");
			e.printStackTrace();
			System.exit(1);
		}
		

		try {
			fileP = new FileProcessor(ipFile);
		}
		catch(FileNotFoundException e) {
			System.err.println(" input file not found.");
			e.printStackTrace();
			System.exit(1);
		}
		
		r = new Results(opFile);
	    tb = new TreeBuilder(r);
	
		CreateWorkers cw = new CreateWorkers(fileP, r, tb);
		cw.startPopulateWorkers(NUM_THREADS);
		cw.startDeleteWorkers(NUM_THREADS, dlWords);
		
		tb.calcValues();
		r.writeToStdout();
		
		try {
			r.writeToFile();
		}
		catch(FileNotFoundException e) {
			System.err.println("Output file cannot be generated");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
