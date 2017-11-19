/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nishant_shah_sean_annunciation_assign5.fileVisitors.src.fileVisitors.util;

import nishant_shah_sean_annunciation_assign5.fileVisitors.src.fileVisitors.store.Results;

/**
 *
 * @author annse
 */
public class TreeBuilder {
	private Node root;
	private int uniqueWords = 0;
	private int totalWords = 0;
	private int totalChar = 0;
	
	private Results rs = null;
	
	public TreeBuilder(Results rI) {
		MyLogger.writeMessage("TreeBuilder constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		rs = rI;
		root = null;
	}
	
	/**
	 * insert node into BST
	 * @param wordI - word to be stored in node
	 */
	public synchronized void insert (String wordI) {
		root = insertVal(root, wordI);
	}
	
	/**
	 * helper function for inserting
	 * @param rootI - root as incoming parameter
	 * @param val - String to be inserted in Node
	 * @return root node
	 */
	private Node insertVal(Node rootI, String val) {
		if(rootI == null) {
			rootI = new Node(val);
		}
		else {
			if (((rootI.getWord()).compareTo(val)) > 0) {
				rootI.setLeft(insertVal(rootI.getLeft(), val));
			}
			else if (((rootI.getWord()).compareTo(val)) < 0) {
				rootI.setRight(insertVal(rootI.getRight(), val));
			}
			else if (((rootI.getWord()).compareTo(val)) == 0) {
				rootI.increaseCount();
			}
		}
		return rootI;
	}

	/**
	 * method to delete course
	 * @param wordI - word to be deleted
	 */
	public synchronized void delete(String wordI) {
		deleteVal(root, wordI);
	}
	
	/**
	 * helper method for deletion
	 * @param r - incoming root node
	 * @param w - word to be deleted
	 */
	private void deleteVal(Node r, String w) {
		if (r == null) {
			return;
		}
		if(((r.getWord()).compareTo(w)) == 0) {
			if(r.getCount() > 0) {
				r.decreaseCount();
			}
		}
		else if(((r.getWord()).compareTo(w)) < 0) {
			deleteVal(r.getRight(), w);
		}
		else if(((r.getWord()).compareTo(w)) > 0){
			deleteVal(r.getLeft(), w);
		}
	}
	
	public void calcValues() {
		inorderVal(root);
		printValues();
	}
	
	/**
	 * helper method to calculate values traversing inorder
	 * @param r - Node instance
	 */
	private void inorderVal(Node r) {
		if (r != null) {
			inorderVal(r.getLeft());
			if (r.getCount() > 0) {
				uniqueWords++;
				totalWords += r.getCount();
				totalChar += r.charCount();
			}
			inorderVal(r.getRight());
		}
	}
	
	private void printValues() {
		rs.storeNewResult("The total number of words: " + totalWords);
		rs.storeNewResult("The total number of characters: " + totalChar);
		rs.storeNewResult("The total number of distinct words: " + uniqueWords);
	}
	
	/**
	 * @return word at root node
	 */
	public String toString() {
		return "Word in root node: " + root.getWord();
	}
}

/**Binary Search Tree implementation references:
 *http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 *http://www.sanfoundry.com/java-program-implement-binary-search-tree/
*/
