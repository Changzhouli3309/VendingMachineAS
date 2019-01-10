package se.lexicon.Li.VendingMachineAS;

import java.util.Scanner;

public class YOrN {
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Keep asking for answer yes or no , doesn't accept anything else.
	 * @param askS :Question to ask for yes or no
	 * @return boolean
	 */
	public static boolean bool(String question) {
		System.out.println(question);
		boolean v = false, re=true;
		while(!v) {
			String sr = scan.nextLine();
			String s = sr.toLowerCase();
			switch (s) {
			case "y":
				v = true;
				re=true;
				break;
			case "n":
				v = true;
				re=false;
				break;
			default:
				System.out.println("Not enter avalidable enter.(y/n)");
			}
		}
		return re;
	}
}
