package examples;

public class SumArray {

	public static void main(String[] args) {
		System.out.println(sumArray(new int[]{1,2,3,4}));
		System.out.println(containsValue(new int[] {5,10,1,20}, 10));
		System.out.println(containsValue(new int[] {5,10,1,20}, 7));
		int [] b = {5,10,1,20};
		System.out.println(containsValue(b, 7));
		System.out.println("countVowels(\"hello\")" + countVowels("hello"));
		System.out.println("countVowels(\"banana\")" + countVowels("banana"));
		System.out.println("firstDuplicate(new int[] {2, 5, 1, 3, 5, 2})" + firstDuplicate(new int[] {2, 5, 1, 3, 5, 2}));
		System.out.println("stringYak: " + stringYak("yakmew"));
	}

	public static int sumArray(int[] values) {
		int sum = 0;
		for (int current:values)
			sum+=current;
		return sum;
	}

	public static boolean containsValue(int[] values, int target) {
		for (int current:values) {
			if (current==target)
				return true;
		}
		return false;
	}
	public static int countVowels(String s) {
		int countVowels= 0;
		for(char currentLetter:s.toCharArray()) {
			if(currentLetter=='a'|currentLetter=='e'|currentLetter=='i'|currentLetter=='o'|currentLetter=='u') {
				countVowels++;
			}
		}
		return countVowels;
	}
	public static int firstDuplicate(int[] values) {
		for (int i=0;i<values.length;i++) {
			for (int j=i+1; j<values.length;j++) {
				if(values[i]==values[j]) {
					return values[i];
				}
			}
		}
		return 0;
	}
	public static String stringYak(String str) {
		//find instances of yak, if found ommit all such instances
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			//see if we found a yak, i, i +1, i+2
			/*FIX the a to be any char or dont check it simply*/

			//if(str.charAt[i]=='y' && str.charAt[i+1]=='a' && str.charAt[i+2]=='k'){
			if(str.charAt(i)=='y' && str.charAt(i+2) == 'k'){
				// found: lets change the value of i skipping such characters and continue
				// with the loop
				i = i + 2;
			}else{
				// not found: append current character to the return sb 
				// continue with the loop
				sb.append(str.charAt(i));
			}
		}
		//return the yak removed string, where a could had been anything
		return sb.toString();
	}

}
