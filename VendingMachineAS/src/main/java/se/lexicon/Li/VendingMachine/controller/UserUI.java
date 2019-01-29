package se.lexicon.Li.VendingMachine.controller;

import static se.lexicon.Li.VendingMachine.util.UserInput.*;
import static se.lexicon.Li.VendingMachine.util.UtilString.*;

import se.lexicon.Li.VendingMachine.data.UsersBag;
import se.lexicon.Li.VendingMachine.data.UsersBagImp;
import se.lexicon.Li.VendingMachine.data.VendingMachineImp;
import se.lexicon.Li.VendingMachine.model.ProductVM;

public class UserUI {
	
	static UsersBag mB = new UsersBagImp();
	static VendingMachineImp vMF= new VendingMachineImp();

	public void mainMenu() {

		plLine(34, "~");
		pl("-Welcome to the Vending Machine!!!");
		printVM();
		boolean run = true;
		while (run) {
			pl("---Menu---(Balance: " + vMF.getBalance() + "kr)\n"
					+ "1-Put money in, 2-Purchase, 3-Check your bag, 4-Details, 5-Leave(or 0)");

			switch (getIntFromLimit(5, 0)) {
			case 1:
				pl("How much?(Real denominations only: 1,5,10,20,50,100,500,1000) 0-Cancel");
				vMF.setBalance(vMF.getBalance() + getVinputB());
				break;
		
			case 2:
				if (vMF.getBalance() == 0) {
					pl("You have no money in the vending machine.\n");

				} else {
					purchaseM();
				}
				break;

			case 3:
				inBag();
				break;
			case 4:
				printVM();
				pl("Enter ID:(0-Cancel)");
				int pickNumber = getIntFromLimit(9, 0);
				if (pickNumber != 0) {
					pl(vMF.getProduct(pickNumber));
				}
				break;

			case 0:
			case 5:
				if (yesOrNo("Are sure to leave?")) {
					pl(vMF.printChanges());
					run=false;
				}
			}
		}
		pl("You left the vending machine.");
	}

	private static int getVinputB() {
		while (true) {
			int n = getInt();
			switch (n) {
			case 0:
			case 1:
			case 5:
			case 10:
			case 20:
			case 50:
			case 100:
			case 500:
			case 1000:
				return n;
			default:
				System.out.println("Not a valid Denomination.");
			}
		}
	}

	private static void purchaseM() {
		pl("Enter ID:(0-Cancel)");
		int id = getIntFromLimit(9, 0) - 1;
		
		if (id>=0) {
			ProductVM buying= vMF.getProduct(id);
			int max = vMF.getBalance() / buying.getPrice();
			pl(buying.getName()+" "+buying.getPrice() + "kr\nAmount:(Max: " + max + ", 0-Cancel)");
			int amount = getIntFromLimit(max, 0);
			if (amount != 0) {
				vMF.setBalance(vMF.getBalance() - amount * buying.getPrice());
				buying.setAmount(amount);
				mB.addItem(buying);
				pl("You put " + amount + "st " + buying.getName() + " in your bag.\n");
			} 
		} 
	}

	private static void inBag() {
		
		while(mB.checkBag()) {
			pl(mB.toStringBag());
			pl("Enter number to pick item.(0-Cancel)");

			int pickNumber = getIntFromLimit(mB.getList().size(), 0)-1;
			if (pickNumber >= 0) {
				pickItem(mB.getItem(pickNumber));
			} else {
				pl();
				break;
			}
		}
	}

	private static void pickItem(ProductVM p) {

		boolean picked = true;
		while (picked) {
			pl("-" + p.getName() + " " 
					+ p.getAmount() + "st-");
			pl("1-Use, 2-Details, 3-Cancel(or 0)");

			switch (getIntFromLimit(3, 0)) {
			case 1:
				// Amount-1,when use
				p.toUse();

				if (p.getAmount() == 0) {
					picked = false;
				}
				break;

			case 2:
				pl(p);
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
	private static void printVM() {

		String[] prod = { "|Cola      ", "|Sprite    ", "|Juice     ", };
		String s = prod[0] + prod[1] + prod[2];
		plLine(s.length() + 1, "-");
		int n1 = 0, n2 = 0;
		for (int i = 0; i < 9; i++) {
			switch (i) {
			case 2:
			case 5:
			case 8:
				pt("|" + addSpace(vMF.getProduct(n1).getName(), 10) + "|\n");

				for (int j = 0; j < 3; j++) {
					switch (n2) {
					case 2:
					case 5:
					case 8:
						pt("|" + vMF.getProduct(n2).getPrice() + "kr,ID-0" + (n2 + 1) + "|\n");
						plLine(s.length() + 1, "-");
						break;

					default:
						pt("|" + vMF.getProduct(n2).getPrice() + "kr,ID-0" + (n2 + 1));

					}
					n2++;
				}
				break;

			default:
				pt("|" + addSpace(vMF.getProduct(n1).getName(), 10));

			}
			n1++;
		}
	}
}
