# DesignPatterns-VisitorPattern_JAVA

# By using this code, you agree to appropriate licences

# This code is a part of academic project and is for illustration purposes only

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile src/build.xml run -Darg0=input.txt  -Darg1=output.txt -Darg2=debugLevel

-----------------------------------------------------------------------
## Data Structures:

Arraylist for storing results:
	Best: O(1) for add() and O(1) for remove 
	Average: O(1) for add() and O(N) for remove
	Worst: O(1) for add() and O(N) for remove

BST for storing words:
	For all three operations we have to traverse through the entire
	tree, which makes it's time complexity as O(N) for all the 
	operations in all cases (Assuming the size of word as constant).
	Best: Insert O(1), Update O(1) [We are never deleting node]
	Average: Insert O(Log(N)), Update O(Log(N))
	Worst: Insert O(N), Update O(N)
		[Assuming input file is randomly distributed, it is very 
		unlikely for the Worst case to happen]
	
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

1) Binary Search Tree implementation references:
http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
http://www.sanfoundry.com/java-program-implement-binary-search-tree/

2) isPalindrome() implementation reference:
http://componentsprogramming.com/palindromes

3) isNumberPrime() implementation source:
https://www.programiz.com/java-programming/examples/prime-number

4) Motivation to select Scanner over BufferedReader:
https://stackoverflow.com/questions/2231369/scanner-vs-bufferedreader

5) Motivation to use PrintWriter over BufferedWriter
https://stackoverflow.com/questions/1747040/difference-between-java-io-printwriter-and-java-io-bufferedwriter
