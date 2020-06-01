// Daniel Chen
// 25 October 2019
// Centimetres to inches

// Algorithm
// ask for input and store in variable
// function is defined as returning variable / 2.54
// pass variable through function and print result


import java.util.Scanner;

class Method6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Centimetres: ");
		double cm = input.nextDouble();
		System.out.println(cm + " cm is " + cm2i(cm) + "\"");
	}
	public static double cm2i(double cm) {
		return cm / 2.54;
	}
}

