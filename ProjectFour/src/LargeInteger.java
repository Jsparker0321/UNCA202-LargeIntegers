
public interface LargeInteger extends Comparable {

	/**
	 * 
	 * @param subtract
	 * @return returns the LinkedLargeInteger difference of this and the argument
	 */
	public LinkedLargeInteger<Integer> subtract(LinkedLargeInteger<Integer> subtract);

	/**
	 * 
	 * @param multiply
	 * @return returns the LinkedLargeInteger product of this and the argument
	 */
	public LinkedLargeInteger<Integer> multiply(LinkedLargeInteger<Integer> multiply);

	/**
	 * 
	 * @param addition
	 * @return returns the LinkedLargeInteger sum of this and the argument
	 */
	public LinkedLargeInteger<Integer> add(LinkedLargeInteger<Integer> addition);

}
