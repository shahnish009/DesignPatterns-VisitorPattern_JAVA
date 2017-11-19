package fileVisitors.visitor;

public class PalindromeHighlight implements visitorI {
	
	private FileProcessor fp = null;
	private TreeBuilder tb = null;
	private String word = null;
	
	private VisitorHelper vh = new VisitorHelper();
	
	/**
	 * constructor for Palindrome Highlight
	 * @param fpI - FileProcessor reference
	 * @param tbI - TreeBuilder Reference
	 */
	public PalindromeHighlight (FileProcessor fpI, TreeBuilder tbI) {
		fp = fpI;
		tb = tbI;
	}

	public void visit() {
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
