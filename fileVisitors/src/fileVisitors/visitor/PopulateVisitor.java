package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.TreeBuilder;
import fileVisitors.util.MyLogger;

public class PopulateVisitor implements visitorI{
	
	private FileProcessor fp = null;
	private TreeBuilder tb = null;
	private String word = null;
	
	public PopulateVisitor (FileProcessor fpI, TreeBuilder tbI) {
		fp = fpI;
		tb = tbI;
	}
	
	public void visit() {
		while((word = fp.readLine()) != null) {
			try {
                tb.insert(word);
                MyLogger.writeMessage("Word: '" + word + "' inserted into tree", MyLogger.DebugLevel.IN_RESULTS);
    		}
			catch(Exception e) {
				System.err.println("Something went wrong with reading word from file");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
