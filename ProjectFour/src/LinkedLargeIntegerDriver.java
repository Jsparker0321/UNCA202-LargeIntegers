/**
 * 
 * @author Jessica Parker
 * @version Project 4: Large Integers CSCI 202 December 5th, 2018 Professor
 *          Charley Sheaffer
 * 
 */
public class LinkedLargeIntegerDriver {

	public static void main(String[] args) {

		System.out.println("String to Integer: ");
		LinkedLargeInteger<Integer> test = new LinkedLargeInteger<Integer>("987654");
		System.out.println(test.toString());
		System.out.println(" ");

		System.out.println("Integer to Integer: ");
		LinkedLargeInteger<Integer> testTwo = new LinkedLargeInteger<Integer>(456789);
		System.out.println(testTwo.toString());
		System.out.println(" ");

		System.out.println("Long to Integer: ");
		LinkedLargeInteger<Integer> testThree = new LinkedLargeInteger<Integer>(2147483647L);
		System.out.println(testThree.toString());
		System.out.println(" ");

		System.out.println("Addition: ");
		LinkedLargeInteger<Integer> addition = new LinkedLargeInteger<Integer>(800);
		LinkedLargeInteger<Integer> additionTwo = new LinkedLargeInteger<Integer>(8);
		LinkedLargeInteger<Integer> additionResult = addition.add(additionTwo);
		System.out.println(" ");
		System.out.println(addition.toString());
		System.out.println("+");
		System.out.println(additionTwo.toString());
		System.out.println("-----");
		System.out.println(additionResult.toString());

		System.out.println(" ");
		System.out.println("Subtraction: ");
		LinkedLargeInteger<Integer> subtraction = new LinkedLargeInteger<Integer>("682");
		LinkedLargeInteger<Integer> subtractionTwo = new LinkedLargeInteger<Integer>("656");
		LinkedLargeInteger<Integer> subtractionResult = subtraction.subtract(subtractionTwo);
		System.out.println(" ");
		System.out.println(subtraction.toString());
		System.out.println("-");
		System.out.println(subtractionTwo.toString());
		System.out.println("-----");
		System.out.println(subtractionResult.toString());

		System.out.println(" ");
		System.out.println("Subtraction: ");
		LinkedLargeInteger<Integer> subtractionAgain = new LinkedLargeInteger<Integer>(545);
		LinkedLargeInteger<Integer> subtractionTwoAgain = new LinkedLargeInteger<Integer>(230);
		LinkedLargeInteger<Integer> subtractionResultAgain = subtractionAgain.subtractTwo(subtractionTwoAgain);
		System.out.println(" ");
		System.out.println(subtractionAgain.toString());
		System.out.println("-");
		System.out.println(subtractionTwoAgain.toString());
		System.out.println("-----");
		System.out.println(subtractionResultAgain.toString());

		/*
		 * System.out.println("Multiplication: "); LinkedLargeInteger<Integer>
		 * multiplication = new LinkedLargeInteger<Integer>("5");
		 * LinkedLargeInteger<Integer> multiplicationTwo = new
		 * LinkedLargeInteger<Integer>("1"); LinkedLargeInteger<Integer>
		 * multiplicationResult = multiplication.multiply(multiplicationTwo);
		 * System.out.println(" "); System.out.println(multiplication.toString());
		 * System.out.println(multiplicationTwo.toString());
		 * System.out.println(multiplicationResult.toString());
		 */
	}

}