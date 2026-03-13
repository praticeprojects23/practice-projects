package examples;
public class MaxNumber {
	public static void main (String[] args) {
		int[] values = {5,10,1,20,32,21};
		System.out.println(max(values));
	}
	
	public static int max(int[] values) {
		int max = values[0];
		for (int i=0; i<values.length; i++) {
			if(values[i]>max) max = values[i];
		}
		return max;
	}
}
