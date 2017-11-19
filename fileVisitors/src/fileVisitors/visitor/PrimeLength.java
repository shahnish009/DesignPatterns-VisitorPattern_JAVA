package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.Node;
import fileVisitors.util.TreeBuilder;
import fileVisitors.util.VisitorHelper;

/**
 *
 * @author annse
 */
public class PrimeLength implements VisitorI {
	
	private FileProcessor fp = null;
	private TreeBuilder tb = null;
	private String word = null;
    private VisitorHelper vhelper=new VisitorHelper();
	
	public PrimeLength (FileProcessor fpI, TreeBuilder tbI) {
		fp = fpI;
		tb = tbI;
	}

	public void visit() {
		inorderVal(tb.getRoot());
	}
	
	private void inorderVal(Node r) {
		if (r != null) {
			inorderVal(r.getLeft());
			if (vhelper.isLengthPrime(r.getWord())) {
				r.setWord(r.getWord() + "-PRIME");
			}
			inorderVal(r.getRight());
		}
	}

    

}  
