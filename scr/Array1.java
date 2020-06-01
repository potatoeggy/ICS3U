// Daniel Chen
// 7 October 2019
// Print 1-20 via an array

class Array1 {
	public static void main(String[] args) {
		int[] numArray = new int[20]; // Create empty array
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = i + 1;
			System.out.println(i + 1);
		}
	}
}
