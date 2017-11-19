package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.Node;
import fileVisitors.util.TreeBuilder;
import fileVisitors.util.VisitorHelper;

public class PrimeLength implements visitorI {
	
	private FileProcessor fp = null;
	private TreeBuilder tb = null;
	private String word = null;
	
	private VisitorHelper vh = new VisitorHelper();
	
	/**
	 * PrimeLength constructor
	 * @param fpI - FileProcessor reference
	 * @param tbI - TreeBuilder reference
	 */
	public PrimeLength (FileProcessor fpI, TreeBuilder tbI) {
		fp = fpI;
		tb = tbI;
	}

	public void visit() {
		inorderVal(tb.getRoot());
	}
	
	/**
	 * @param r - root node for traversing
	 */
	private void inorderVal(Node r) {
		if (r != null) {
			inorderVal(r.getLeft());
			if (vh.isLengthPrime(r.getWord())) {
				r.setWord(r.getWord() + "-PRIME");
			}
			inorderVal(r.getRight());
		}
	}
}
