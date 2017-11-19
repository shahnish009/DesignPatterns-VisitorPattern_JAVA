package fileVisitors.visitor;

import fileVisitors.store.Results;

public class PrintTree implements visitorI {
	
	private FileProcessor fp = null;
	private TreeBuilder tb = null;
	private Results r = null;
	private String word = null;
	
	public PrintTree (FileProcessor fpI, TreeBuilder tbI) {
		fp = fpI;
		tb = tbI;
		r = rI;
	}

	public void visit() {
		inorderVal(tb.getRoot());
	}
	
	private void inorderVal(Node r) {
		if (r != null) {
			inorderVal(r.getLeft());
			r.storeNewResult(r.getWord());
			inorderVal(r.getRight());
		}
	}
}
