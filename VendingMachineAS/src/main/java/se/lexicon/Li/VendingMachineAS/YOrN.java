package se.lexicon.Li.VendingMachineAS;

import java.util.Scanner;

public class YOrN {
	private static Scanner scan = new Scanner(System.in);

	/**
	 * Keep asking for answer yes or no , doesn't accept anything else.
	 * 
	 * @param askS :Question to ask for yes or no
	 * @return boolean
	 */
	public static boolean bool(String question) {
		System.out.println(question);
		while (true) {
			String sr = scan.nextLine();
			String s = sr.toLowerCase();
			switch (s) {
			case "y":
				return true;
			case "n":
				return false;
			default:
				System.out.println("Not a vaild enter.(y/n)");
			}
		}
	}
}
