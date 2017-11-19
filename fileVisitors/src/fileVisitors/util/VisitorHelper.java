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
	
	
	public boolean isLengthPrime(String word) {
            
            boolean val=true;
            int len=word.length();
            if (len>=2){
                for(int i=2;i<=len/2;i++)
            {
                if(len%i==0)
                {                  
                val=false;
                }
            }
            }
            else
                val=false;
            
            return val;
                
}
}

/**isPalindrome() implementation source:
 * http://componentsprogramming.com/palindromes
 * 
 * isLengthPrime() implementation source:
 * https://www.programiz.com/java-programming/examples/prime-number
 * 
 */