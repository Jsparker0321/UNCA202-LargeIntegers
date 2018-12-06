/**
 * 
 * @author Jessica Parker
 * @version Project 4: Large Integers CSCI 202 December 5th, 2018 Professor
 *          Charley Sheaffer
 * 
 */

public class LinkedLargeInteger<Node> implements LargeInteger {

	LinkedLargeIntegerList<Integer> name;
	int carryOver;
	LinkedLargeInteger ONE;
	LinkedLargeInteger ZERO;

	/**
	 * takes a String representing the large number and creates the linked
	 * representation
	 * 
	 * @param stringLargeNumber
	 */
	public LinkedLargeInteger(String stringLargeNumber) {

		name = new LinkedLargeIntegerList<>();

		for (int i = stringLargeNumber.length() - 1; i >= 0; i--) {

			char value = stringLargeNumber.charAt(i);
			Integer newValue = Integer.parseInt(String.valueOf(value));

			name.add(newValue);

		}
	}

	/**
	 * takes an int representing the large number and creates the linked
	 * representation
	 * 
	 * @param intLargeNumber
	 */
	public LinkedLargeInteger(int intLargeNumber) {

		this(intLargeNumber + "");

	}

	/**
	 * takes a long representing the large number and creates the linked
	 * representation
	 * 
	 * @param longLargeNumber
	 */
	public LinkedLargeInteger(long longLargeNumber) {

		this(longLargeNumber + "");

	}

	@Override
	public LinkedLargeInteger add(LinkedLargeInteger addition) {

		int value = 0;

		String totalSum = "";

		LinkedLargeInteger smallest = getShortestList(this, addition);

		for (int i = 0; i < smallest.name.size(); i++) {
			value = (name.get(i) + (int) addition.name.get(i) + carryOver);

			totalSum = carry(value) + totalSum;

		}
		if (name.size() == addition.name.size()) {
			totalSum = carryOver + totalSum;
		} else if (addition.equals(smallest)) {

			for (int i = smallest.name.size(); i < name.size(); i++) {
				value = carryOver + name.get(i);
				totalSum = carry(value) + totalSum;

			}
		} else {
			for (int i = smallest.name.size(); i < addition.name.size(); i++) {
				value = carryOver + (int) addition.name.get(i);
				totalSum = carry(value) + totalSum;

			}
		}
		return new LinkedLargeInteger<Integer>(totalSum);
	}

	public LinkedLargeInteger subtractTwo(LinkedLargeInteger subtractTwo) {

		int value = 0;

		String totalSum = "";

		LinkedLargeInteger smallest = getShortestList(this, subtractTwo);

		for (int i = 0; i < smallest.name.size(); i++) {
			value = (name.get(i) - (int) subtractTwo.name.get(i) - carryOver);

			totalSum = carry(value) + totalSum;

		}
		if (name.size() == subtractTwo.name.size()) {
			totalSum = carryOver + totalSum;
		} else if (subtractTwo.equals(smallest)) {

			for (int i = smallest.name.size(); i < name.size(); i++) {
				value = carryOver + name.get(i);
				totalSum = carry(value) + totalSum;

			}
		} else {
			for (int i = smallest.name.size(); i < subtractTwo.name.size(); i++) {
				value = carryOver + (int) subtractTwo.name.get(i);
				totalSum = carry(value) + totalSum;

			}
		}
		return new LinkedLargeInteger<Integer>(totalSum);
	}

	/**
	 * Finds which LinkedLargeIntegerList is shorter
	 * 
	 * @param one
	 * @param two
	 * @return returns the shorter list
	 */
	public LinkedLargeInteger<Integer> getShortestList(LinkedLargeInteger one, LinkedLargeInteger two) {

		if (one.name.size() > two.name.size()) {
			return two;
		}

		return one;

	}

	/**
	 * Handles the carrying for adding numbers together
	 * 
	 * @param res
	 * @return num after carry
	 */
	private int carry(int num) {

		carryOver = 0;

		while (num > 9) {
			num -= 10;
			carryOver++;
		}

		return num;
	}

	/**
	 * Handles the borrowing for subtracting numbers
	 * 
	 * @param top
	 * @param bottom
	 * @return answer and digits borrowed
	 */
	private int carrySubtraction(int top, int bottom) {

		carryOver = 0;
		int answer = 0;

		if (top < bottom) {
			top += 10;
			carryOver++;
			return top;

		} else {
			answer = top - bottom;
		}

		return answer;
	}

	@Override
	public LinkedLargeInteger<Integer> subtract(LinkedLargeInteger<Integer> subtract) {

		int value = 0;

		String totalSum = "";

		LinkedLargeInteger smallest = getShortestList(this, subtract);

		for (int i = 0; i < smallest.name.size(); i++) {
			value = (name.get(i) - (int) subtract.name.get(i) - carryOver);

			totalSum = carrySubtraction(value, subtract.name.get(i)) + totalSum;

		}

		if (name.size() == subtract.name.size()) {
			totalSum = carryOver + totalSum;
		} else if (subtract.equals(smallest)) {

			for (int i = smallest.name.size(); i < name.size(); i++) {
				value = carryOver + name.get(i);
				totalSum = carrySubtraction(value, subtract.name.get(i)) + totalSum;

			}
		} else {
			for (int i = smallest.name.size(); i < subtract.name.size(); i++) {
				value = carryOver + (int) subtract.name.get(i);
				totalSum = carrySubtraction(value, subtract.name.get(i)) + totalSum;

			}
		}
		return new LinkedLargeInteger<Integer>(totalSum);
	}

	@Override
	public LinkedLargeInteger<Integer> multiply(LinkedLargeInteger<Integer> multiply) {

		/*
		 * int value = 0;
		 * 
		 * String totalSum = "";
		 * 
		 * LinkedLargeInteger smallest = getShortestList(this, multiply);
		 * 
		 * for (int i = 0; i < smallest.name.size(); i++) { value = (name.get(i) * (int)
		 * multiply.name.get(i) * carryOver) ;
		 * 
		 * totalSum = carry(value) + totalSum;
		 * 
		 * } if (name.size() == multiply.name.size()) { totalSum = carryOver + totalSum;
		 * } else if (multiply.equals(smallest)) {
		 * 
		 * for (int i = smallest.name.size(); i < name.size(); i++) { value = carryOver
		 * + name.get(i); totalSum = carry(value) + totalSum;
		 * 
		 * 
		 * } } else { for (int i = smallest.name.size(); i < multiply.name.size(); i++)
		 * { value = carryOver + (int) multiply.name.get(i); totalSum = carry(value) +
		 * totalSum;
		 * 
		 * 
		 * }
		 */
		return null;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {

		String newString = "";

		for (int i = name.size() - 1; i >= 0; i--) {

			newString += name.get(i) + "";

		}

		return newString;
	}

}
