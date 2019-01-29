package se.lexicon.Li.VendingMachine.util;

public class UtilString {
	
	public static void pl() {
		System.out.println();
	}

	public static void pl(Object o) {
		System.out.println(o);
	}

	public static void pt(Object o) {
		System.out.print(o);
	}
	public static String addSpace(String s, int n) {
		String re = s;
		for (int i = 0; i < n - s.length(); i++) {
			re += " ";
		}
		return re;
	}
	/**
	 * print same thing in a line
	 * 
	 * @param n amount
	 * @param s to print
	 */
	public static void plLine(int n, String s) {
		for (int i = 0; i < n; i++) {
			if (i != n - 1) {
				System.out.print(s);
			} else {
				System.out.print(s + "\n");
			}
		}
	}
}
