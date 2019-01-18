package se.lexicon.Li.VendingMachineAS;

public class App {

	static VendingMF vMF = new VendingMF();
	static MyBag mB = new MyBag();

	public static void main(String[] args) {

		plLine(34, "~");
		pl("-Welcome to the Vending Machine!!!");
		printVM();
		boolean run = true;
		while (run) {
			pl("---Menu---(Balance: " + vMF.getBalance() + "kr)\n"
					+ "1-Put money in, 2-Purchase, 3-Check your bag, 4-Details, 5-Leave(or 0)");

			switch (FixInt.getIntFromLimit(5, 0)) {
			case 1:
				pl("How much?(Real denominations only, like: 1,5,10,20kr...) 0-Cancel");
				vMF.setBalance(vMF.getBalance() + vMF.getVinputB());
				break;

			case 2:
				if (vMF.getBalance() == 0) {
					pl("You have no money in the vending machine.\n");

				} else {
					purchaseM();
				}
				break;

			case 3:
				boolean checkBag = true;
				while (checkBag) {
					/**
					 * MyBag.toString has 2 more Functions: 
					 * 1, print out list 
					 * 2, set the place number 
					 * 3, check is bag empty
					 */
					pl(mB);
					if (!mB.isEmptyBag()) {
						// In bag menu
						checkBag = inBag();

					} else {
						checkBag = false;
					}
				}
				break;

			case 4:
				printVM();
				pl("Enter ID:(0-Cancel)");
				int pickNumber = FixInt.getIntFromLimit(9, 0);
				if (pickNumber != 0) {
					pl(mB.getFromIndex(pickNumber - 1));
				}
				break;

			case 0:
			case 5:
				run = !YOrN.bool("Are sure to leave?(y/n)");
				if (!run) {
					pl(vMF.printChanges());
				}
			}
		}
		pl("You left the vending machine.");
	}

	public static void purchaseM() {
		pl("Enter ID:(0-Cancel)");
		int id = FixInt.getIntFromLimit(9, 0) - 1;
		
		if (id>=0) {
			int max = vMF.getBalance() / mB.getFromIndex(id).getPrice();
			pl(mB.getFromIndex(id).nameAndPrice() + "\nAmount:(Max: " + max + ", 0-Cancel)");
			int amount = FixInt.getIntFromLimit(max, 0);
			if (amount != 0) {
				int restBalace = vMF.getBalance() - amount * mB.getFromIndex(id).getPrice();
				vMF.setBalance(restBalace);
				mB.getFromIndex(id).setAmount(mB.getFromIndex(id).getAmount() + amount);
				pl("You put " + amount + "st " + mB.getFromIndex(id).getName() + " in your bag.\n");
			} 
		} 
	}

	public static boolean inBag() {
		pl("Enter number to pick item.(0-Cancel)");

		int pickNumber = FixInt.getIntFromLimit(mB.getAmountType(), 0);
		if (pickNumber != 0) {

			pickItem(mB.matchID(pickNumber));

			return true;
		} else {
			pl();
			return false;
		}
	}

	public static void pickItem(int bagIndex) {

		boolean picked = true;
		while (picked) {
			pl("-" + mB.getFromIndex(bagIndex).getName() + " " 
					+ mB.getFromIndex(bagIndex).getAmount() + "st-");
			pl("1-Use, 2-Details, 3-Cancel(or 0)");

			switch (FixInt.getIntFromLimit(3, 0)) {
			case 1:
				// Amount-1,when use
				mB.getFromIndex(bagIndex).toUse();

				if (mB.getFromIndex(bagIndex).getAmount() == 0) {
					picked = false;
				}
				break;

			case 2:
				pl(mB.getFromIndex(bagIndex));
				break;

			case 0:
			case 3:
				picked = false;
			}
		}
	}

	/**
	 * Draw the vending machine.
	 */
	public static void printVM() {

		String[] prod = { "|Cola      ", "|Sprite    ", "|Juice     ", };
		String s = prod[0] + prod[1] + prod[2];
		plLine(s.length() + 1, "-");
		int n1 = 0, n2 = 0;
		for (int i = 0; i < 9; i++) {
			switch (i) {
			case 2:
			case 5:
			case 8:
				pt("|" + addSpace(mB.getFromIndex(n1).getName(), 10) + "|\n");

				for (int j = 0; j < 3; j++) {
					switch (n2) {
					case 2:
					case 5:
					case 8:
						pt("|" + mB.getFromIndex(n2).getPrice() + "kr,ID-0" + (n2 + 1) + "|\n");
						plLine(s.length() + 1, "-");
						break;

					default:
						pt("|" + mB.getFromIndex(n2).getPrice() + "kr,ID-0" + (n2 + 1));

					}
					n2++;
				}
				break;

			default:
				pt("|" + addSpace(mB.getFromIndex(n1).getName(), 10));

			}
			n1++;
		}
	}

	public static String addSpace(String s, int n) {
		String re = s;
		for (int i = 0; i < n - s.length(); i++) {
			re += " ";
		}
		return re;
	}

	public static void pl(ProductsVM p) {
		System.out.println(p);
	}

	public static void pl(MyBag m) {
		System.out.println(m);
	}

	public static void pl(VendingMF m) {
		System.out.println(m);
	}

	public static void pl() {
		System.out.println();
	}

	public static void pl(String s) {
		System.out.println(s);
	}

	public static void pl(int n) {
		System.out.println(n);
	}

	public static void pt(String s) {
		System.out.print(s);
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
