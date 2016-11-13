package converter;

import java.util.ArrayList;

public class Number {

	private long number;

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setNumber(String number, NumeralSystem type) {
		number = number.toUpperCase();
		char[] arr = number.toCharArray();
		switch (type) {
		case Decimal:
			if(isValidDecimal(number))
				setNumber(Long.parseLong(number));
			break;
		case Octonary:
			if (isValidOctonary(number))
				setNumber(toDecimal(arr, 8));
			break;
		case Binary:
			if (isValidBinary(number))
				setNumber(toDecimal(arr, 2));
			break;
		case Hexadecimal:
			if(isValidHexadecimal(number))
				setNumber(toDecimal(arr, 16));
			break;
		default:
			break;
		}
	}

	public Number() {
		setNumber(0);
	}

	public Number(long n) {
		setNumber(n);
	}

	public static int getIntFromChar(char n) {
		if (n >= '0' && n <= '9')
			return n - '0';
		else if (n >= 'A' && n <= 'F')
			return n - 55;
		else
			return -1;
	}

	public static char getCharFromInt(int n) {
		if (n >= 0 && n <= 9)
			return (char) ('0' + n);
		else if (n >= 10 && n <= 16)
			return (char) (55 + n);
		else
			return '\0';
	}

	public static long toDecimal(char[] arr, int pow) {
		long result = 0;
		for (int i = arr.length - 1, j = 0; i >= 0; i--, j++)
			result += getIntFromChar(arr[i]) * Math.pow(pow, j);
		return result;
	}

	public static String toNumberLetter(long n, int pow) {
		ArrayList<Character> list = new ArrayList<>();
		do {
			list.add(0, getCharFromInt((int) (n % pow)));
			n /= pow;
		} while (n > 0);

		StringBuilder result = new StringBuilder(list.size());
		for (char i : list)
			result.append(i);

		return result.toString();
	}

	public String getBinary() {
		return toNumberLetter(number, 2);
	}

	public String getOctonary() {
		return toNumberLetter(number, 8);
	}

	public String getHexadecimal() {
		return toNumberLetter(number, 16);
	}

	private boolean isValidNumeral(String number, int beginBound, int endBound, boolean character) {
		char[] s = number.toCharArray();
		boolean isValidNumber = true;
		boolean isValidCharacter = true;
		for (char i : s) {
			if (i < '0' + beginBound)
				isValidNumber = false;
			if (character && (i > '0' + endBound && i < 'A' || i > 'F'))
				isValidCharacter = false;
			if (!character && i > '0' + endBound)
				isValidNumber = false;
		}

		return isValidCharacter && isValidNumber;
	}

	public boolean isValidBinary(String number) {
		return isValidNumeral(number, 0, 1, false);
	}

	public boolean isValidDecimal(String number) {
		return isValidNumeral(number, 0, 9, false);
	}
	
	public boolean isValidOctonary(String number){
		return isValidNumeral(number, 0, 7, false);
	}
	
	public boolean isValidHexadecimal(String number){
		return isValidNumeral(number, 0, 9, true);
	}

}
