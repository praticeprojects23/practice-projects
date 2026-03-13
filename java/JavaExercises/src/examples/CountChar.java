package examples;

public class CountChar {

	public static void main(String[] args) {
		System.out.println(CountChar("banana", 'a'));
		System.out.println(CountChar("hello", 'l'));

	}

	private static int CountChar(String s, char findMe) {
		int count = 0;
		for (int i=0; i<s.length();i++) {
			if (s.charAt(i) == findMe) count+=1;
		}
		return count;
	}

}
