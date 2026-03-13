package examples;

public class Palindrome {
	public static void main (String[] args) {
		System.out.println(isPalindrome("ManaM"));
		System.out.println(isPalindrome("ManaMe"));
		System.out.println(isPalindrome("M"));
		System.out.println(isPalindrome(""));
	}
	public static boolean isPalindrome(String s) {
		//we can work from outside and inside edges and then work our way to the center. 
		//Q: can even number of character words also be a Palindrome
		//lets find the midpoint of the String s
		for(int i = 0; i<s.length()/2; i++) {
			//find a negative case to fail it
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		//if we make it outside of the loop it means it is a Palindrome
		return true;
	}
}
