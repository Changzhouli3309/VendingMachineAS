package se.lexicon.Li.VendingMachineAS;

public class App {

	public static void main(String[] args) {

		VendingMF vMF = new VendingMF(0);
		MyBag mB = new MyBag();
		boolean run = true;

		pl("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nWelcome to the Vending Machine!!!");
		printVM();
		while (run) {
			pl("---Menu---(Balance: " + vMF.getBalance() + "kr)\n"
					+ "1-Put money in, 2-Purchase, 3-Check your bag, 4-Details, 5-Leave(or 0)");
			
			switch (FixInt.getIntFromLimit(5, 0)) {
			case 1:
				pl("How much?(With real denominations only, like: 1,5,10kr...) 0-Cancel");
				vMF.setBalance(vMF.getBalance() + vMF.getVinputB());
				break;
				
			case 2:
				if (vMF.getBalance() == 0) {
					pl("You have 0 banlance in the vending machine.\n");
										
				} else {
					pl("Enter ID:");
					int id = FixInt.getIntFromLimit(9, 1) - 1;
					int max = vMF.getBalance() / mB.getFromIndex(id).getPrice();
					
					pl(mB.getFromIndex(id).nameAndPrice() + "\nAmount:(Max: " + max + ", 0-Cancel)");
					int amount = FixInt.getIntFromLimit(max, 0);
					
					if (amount != 0) {
						int restBalace = vMF.getBalance() - amount * mB.getFromIndex(id).getPrice();
						vMF.setBalance(restBalace);
						mB.getFromIndex(id).setAmount(mB.getFromIndex(id).getAmount() + amount);
						pl("You put " + amount + "st " + mB.getFromIndex(id).getName() + " in your bag.\n");
						
					} else {
						pl();
					}
				}
				break;
				
			case 3:
				boolean inBag = true;
				while (inBag) {
					pl(mB);
					if (!mB.isEmptyBag()) {
						pl("Enter number to pick item.(0-Cancel)");
						
						int pickNumber = FixInt.getIntFromLimit(mB.getAmountType(), 0);
						if (pickNumber != 0) {
							boolean picked = true;
							int bagIndex = mB.matchID(pickNumber);
							
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
									break;
									
								}
							}
							
						} else {
							pl();
							inBag = false;
						}
						
					} else {
						inBag = false;
					}
					
				}
				break;
				
			case 4:
				printVM();
				pl("Eneter ID:(0-Cansel)");
				int pickNumber = FixInt.getIntFromLimit(9, 0) - 1;
				if (pickNumber != -1) {
					pl(mB.getFromIndex(pickNumber));
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

	/**
	 * Draw the vending machine.
	 */
	public static void printVM() {
		MyBag b = new MyBag();
		String[] prod = { "|Cola      ", "|Sprite    ", "|Juice     ",};
		String s = prod[0] + prod[1] + prod[2];
		plLine(s.length() + 1);
		int n1 = 0, n2 = 0;
		for (int i = 0; i < 9; i++) {
			switch (i) {
			case 2:
			case 5:
			case 8:
				pt("|" + addSpace(b.getFromIndex(n1).getName(), 10) + "|\n");
				
				for (int j = 0; j < 3; j++) {
					switch (n2) {
					case 2:
					case 5:
					case 8:
						pt("|" + b.getFromIndex(n2).getPrice() + "kr,ID-0" + (n2 + 1) + "|\n");
						plLine(s.length() + 1);
						break;
						
					default:
						pt("|" + b.getFromIndex(n2).getPrice() + "kr,ID-0" + (n2 + 1));

					}
					n2++;
				}
				break;
				
			default:
				pt("|" + addSpace(b.getFromIndex(n1).getName(), 10));

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
	 * print dash(-)
	 * 
	 * @param n amount of dash(-)
	 */
	public static void plLine(int n) {
		for (int i = 0; i < n; i++) {
			if (i != n - 1) {
				System.out.print("-");
			} else {
				System.out.print("-\n");
			}
		}
	}
}
