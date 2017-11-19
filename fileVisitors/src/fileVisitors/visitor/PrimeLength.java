package fileVisitors.visitor;

public class PrimeLength implements visitorI {
	
	private FileProcessor fp = null;
	private TreeBuilder tb = null;
	private String word = null;
	
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
			if (isLengthPrime(r.getWord())) {
				r.setWord(r.getWord() + "-PRIME");
			}
			inorderVal(r.getRight());
		}
	}
}
