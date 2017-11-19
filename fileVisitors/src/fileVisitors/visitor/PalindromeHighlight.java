package fileVisitors.visitor;

public class PalindromeHighlight implements visitorI {
	
	private FileProcessor fp = null;
	private TreeBuilder tb = null;
	private String word = null;
	
	public PalindromeHighlight (FileProcessor fpI, TreeBuilder tbI) {
		fp = fpI;
		tb = tbI;
	}

	public void visit() {
		inorderVal(tb.getRoot());
	}
	
	private void inorderVal(Node r) {
		if (r != null) {
			inorderVal(r.getLeft());
			if (isPalindrome(r.getWord())) {
				r.setWord(r.getWord().toUpperCase());
			}
			inorderVal(r.getRight());
		}
	}
}
