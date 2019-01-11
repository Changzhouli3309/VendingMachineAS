package se.lexicon.Li.VendingMachineAS;

import java.util.*;

public class FixInt {

	private static Scanner scan = new Scanner(System.in);
	private static Random ran = new Random();

	/**
	 * Get a random integer with range between max and min
	 * 
	 * @param max highest number (include)
	 * @param min lowest number (include)
	 * @return a random number
	 */
	public static int randomInt(int max, int min) {
		int re = ran.nextInt(max - min) + min;
		return re;
	}

	/**
	 * Check the string is number with in range of Integer or not, until you get a
	 * valid number
	 * 
	 * @return valid number
	 */
	public static int getInt() {
		boolean valid = false;
		int n = 0;
		while (!valid) {
			try {
				n = Integer.parseInt(scan.nextLine());
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("Not valid enter.(int)");
			}
		}
		return n;
	}

	/**
	 * keep asking for number until you put right number from limit
	 * 
	 * @param max
	 * @param min
	 * @return valid number
	 */
	public static int getIntFromLimit(int max, int min) {
		int re = 0;
		boolean valid = false;
		while (!valid) {
			re = getInt();
			if (re >= min && re <= max) {
				valid = true;
			}
			if (!valid) {
				System.out.println("Not valid enter.(int " + min + "-" + max + ")");
			}
		}
		return re;
	}

	/**
	 * keep asking for number until you put right number from limit
	 * 
	 * @param max
	 * @param min
	 * @param with decide max and min are Inclusive or not
	 * @return
	 */
	public static int getIntFromLimit(int max, int min, boolean with) {
		int re = 0;
		boolean valid = false;
		while (!valid) {
			re = getInt();
			if (re >= min && re <= max) {
				valid = true;
				if (!with) {
					if (re == min || re == max) {
						valid = false;
					}
				}
			}
			if (!valid) {
				System.out.println("Not valid enter.(int between " + min + "-" + max + ")");
			}
		}
		return re;
	}

	/**
	 * Print integer part of doubled number
	 * 
	 * @param n
	 * @return integer
	 */
	public static String printN(double n) {
		String s = "" + (int) n;
		return s;
	}

	/**
	 * Add 0 before the number if it is too short
	 * 
	 * @param n
	 * @param max
	 * @return
	 */
	public static String addZero(int n, int max) {
		String s = "";

		for (int b = n; (max / 10) > 0; max /= 10) {
			b /= 10;
			if (b == 0) {
				s += "0";
			}
		}
		return s + n;
	}

	/**
	 * Add space after the number if it is too short
	 * 
	 * @param n
	 * @param max
	 * @return
	 */
	public static String addSpace(int n, int max) {
		String s = "";

		for (int b = n; (max / 10) > 0; max /= 10) {
			b /= 10;
			if (b == 0) {
				s += " ";
			}
		}
		return n + s;
	}

	/**
	 * Add space after the number if it is too short
	 * 
	 * @param n
	 * @param di :amount of length that you want
	 * @return String n+space
	 */
	public static String addSpaceL(int n, int di) {
		String s = "" + n;
		for (int i = s.length(); i < di; i++) {
			s += " ";
		}
		return s;
	}

	public static String changeToNumberSystem(int n, int toN) {
		String re = "";
		int p = toN;
		int[] toNA = { 1 };
		while (n / p > 0) {
			toNA = FixArr.addToArr(toNA, p);
			p *= toN;
		}

		for (int i = 0; i < toNA.length; i++) {
			int n1 = n;
			for (int j = 0; j < i; j++) {
				n1 %= toNA[toNA.length - j - 1];
			}
			switch (n1 / toNA[toNA.length - i - 1]) {
			case 10:
				re += "a";
				break;
			case 11:
				re += "b";
				break;
			case 12:
				re += "c";
				break;
			case 13:
				re += "d";
				break;
			case 14:
				re += "e";
				break;
			case 15:
				re += "f";
				break;
			case 16:
				re += "g";
				break;
			case 17:
				re += "h";
				break;
			case 18:
				re += "i";
				break;
			case 19:
				re += "j";
				break;
			case 20:
				re += "k";
				break;
			case 21:
				re += "l";
				break;
			case 22:
				re += "m";
				break;
			case 23:
				re += "n";
				break;
			case 24:
				re += "o";
				break;
			case 25:
				re += "p";
				break;
			case 26:
				re += "q";
				break;
			case 27:
				re += "r";
				break;
			case 28:
				re += "s";
				break;
			case 29:
				re += "t";
				break;
			case 31:
				re += "u";
				break;
			case 32:
				re += "v";
				break;
			case 33:
				re += "w";
				break;
			case 34:
				re += "x";
				break;
			case 35:
				re += "y";
				break;
			case 36:
				re += "z";
				break;
			default:
				re += n1 / toNA[toNA.length - i - 1];
			}
		}
		return re.toUpperCase();
	}

}
