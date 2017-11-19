package fileVisitors.driver;

import java.lang.NumberFormatException;
import java.lang.RuntimeException;
import fileVisitors.store.Results;
import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.TreeBuilder;
import fileVisitors.store.Results;
//import fileVisitors.threadMgmt.CreateWorkers;
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
		int debugValueSetter = -1;
		
		FileProcessor fileP = null;
		Results r = null;
	    TreeBuilder tb = null;
		
		try {
			if(3 == args.length) {
       	        ipFile = args[0];
	            opFile = args[1];
	            
	            debugValueSetter = Integer.parseInt(args[2]);
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
		
		
		
		tb=new TreeBuilder();
               r=new Results(opFile);
               
               
               Visitor PopulateVisitor=(Visitor) new PopulateVisitor(fileP,tb);
               Visitor PalindromeHighlight=(Visitor) new PalindromeHighlight();
               Visitor PrimeLength=(Visitor) new PrimeLength(fileP,tb);
               Visitor PrintTree=(Visitor) new PrintTree(fileP,tb,r);
               
               
               tb.accept(PopulateVisitor);
               tb.accept(PalindromeHighlight);
               tb.accept(Primelength);
               tb.accept(Primelength);
			   
			   
/*		
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
		}*/
	}
}
