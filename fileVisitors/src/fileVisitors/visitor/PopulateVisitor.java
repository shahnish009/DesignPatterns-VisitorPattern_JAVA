package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.TreeBuilder;
import fileVisitors.util.MyLogger;

public class PopulateVisitor implements visitorI{
	
	private FileProcessor fp = null;
	private String word = null;
	
	/**
	 * @param fpI - FileProcessor reference
	 */
	public PopulateVisitor (FileProcessor fpI) {
		fp = fpI;
	}
	
	/**
	 * @param tb - TreeBuilder reference
	 */
	public void visit(TreeBuilder tb) {
		while((word = fp.readLine()) != null) {
			try {
                tb.insert(word);
                MyLogger.writeMessage("Word: '" + word + "' inserted into tree", MyLogger.DebugLevel.IN_RESULTS);
    		}
			catch(Exception e) {
				System.err.println("Something went wrong with inserting word into tree");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
