package examples;

public class ReverseString {
	public static void main (String[] args) {
		System.out.println("from normal approach " + reverseString("ABCDEF"));
		System.out.println("from StringBuilder approach " +reverseStringStringBuilder("ABCDEF"));
	}

	public static String reverseString (String s) {
		String tempString = "";

		for(int index = s.length()-1; index>=0; index--) {
			tempString+=s.charAt(index);
		}
		return tempString;
	}
	
	public static String reverseStringStringBuilder(String s) {
		StringBuilder sBuilder = new StringBuilder();
		for(int index = s.length()-1; index>=0; index--) {
			sBuilder.append(s.charAt(index));
		}
		//convert StringBuilder to String
		return sBuilder.toString();
	}
	
	//cleanest answer
	public static String reverseStringClean(String s) {
	    return new StringBuilder(s).reverse().toString();
	}

}
