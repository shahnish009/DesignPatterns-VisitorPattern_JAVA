package fileVisitors.util;

public class VisitorHelper {

	public boolean isPalindrome(String str) {
	    int n = str.length();
		if (n <= 3) {
			return false;
		}
		for (int i = 0; i < n/2; ++i) {
		        if (str.charAt(i) != str.charAt(n-i-1)) return false;
		    }
		    return true;    
		}
	}	
}

/**isPalindrome() implementation source:
 * http://componentsprogramming.com/palindromes
 */