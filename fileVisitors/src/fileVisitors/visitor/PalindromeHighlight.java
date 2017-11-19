package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.Node;
import fileVisitors.util.TreeBuilder;
import fileVisitors.util.VisitorHelper;

public class PalindromeHighlight implements visitorI {
	
	private FileProcessor fp = null;
	private String word = null;
	
	private VisitorHelper vh = new VisitorHelper();
	
	/**
	 * constructor for Palindrome Highlight
	 * @param fpI - FileProcessor reference
	 */
	public PalindromeHighlight (FileProcessor fpI) {
		fp = fpI;
	}

	public void visit(TreeBuilder tb) {
		inorderVal(tb.getRoot());
	}
	
	/**
	 * @param r - root node of tree to traverse
	 */
	private void inorderVal(Node r) {
		if (r != null) {
			inorderVal(r.getLeft());
			if (vh.isPalindrome(r.getWord().toUpperCase())) {
				r.setWord(r.getWord().toUpperCase());
			}
			inorderVal(r.getRight());
		}
	}
}
