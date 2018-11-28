import java.util.LinkedList;

public class LinkedLargeInteger implements LargeInteger {

	LinkedList<Integer> name;

	public LinkedLargeInteger(String stringLargeNumber) {

		name = new LinkedList<>();

		for (int i = stringLargeNumber.length() - 1; i > 0; i--) {

			char value = stringLargeNumber.charAt(i);
			Integer newValue = Integer.parseInt(String.valueOf(value));

			name.addFirst(newValue);
			
			System.out.println(newValue);


		}

		
	}

	// adding to linked list
	// convert int to string and call above method
	// call constructor within
	public LinkedLargeInteger(int intLargeNumber) {

		String numberAsString = Integer.toString(intLargeNumber);

		new LinkedLargeInteger(numberAsString);

	}

	// long to int
	public LinkedLargeInteger(long longLargeNumber) {

		long longAsInt = longLargeNumber;

		int conversion = (int) longAsInt;

		new LinkedLargeInteger(conversion);

	}

	@Override
	public LinkedLargeInteger add(int LinkedLargeInteger) {

		return null;
	}

	@Override
	public LinkedLargeInteger subtract(int LinkedLargeInteger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedLargeInteger multiply(int LinkedLargeInteger) {
		// TODO Auto-generated method stub
		return null;
	}

}
