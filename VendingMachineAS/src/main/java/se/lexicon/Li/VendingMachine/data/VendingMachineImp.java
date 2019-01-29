package se.lexicon.Li.VendingMachine.data;

import java.util.Arrays;
import java.util.List;

import se.lexicon.Li.VendingMachine.model.CandysVM;
import se.lexicon.Li.VendingMachine.model.DrinksVM;
import se.lexicon.Li.VendingMachine.model.ProductVM;
import se.lexicon.Li.VendingMachine.model.SnacksVM;

public class VendingMachineImp implements VendingMachine{
	private static int[] changes = new int[8];
	private static int balance=0;
	
	static ProductVM p0 = new DrinksVM("Cola", 0, 15,
			"A sweetened, carbonated soft drink flavored with vanilla, cinnamon, citrus oils and other flavorings.",
			"33cl-Can", true);
	static ProductVM p1 = new DrinksVM("Sprite", 0, 20, "A colorless, caffeine-free, lemon and lime-flavored soft drink.",
			"50cl-Bottle", true);
	static ProductVM p2 = new DrinksVM("Juice", 0, 10, "Apple juice made by the maceration and pressing of an apple.",
			"33cl-Carton", false);
	// CandysVM((...),int weight, boolean hard)
	static ProductVM p3 = new CandysVM("Gum", 0, 14,
			"A soft, cohesive substance designed to be chewed without being swallowed.", 90, false);
	static ProductVM p4 = new CandysVM("Chocolate", 0, 24,
			"A sweet, brown food preparation of roasted and ground cacao seeds.", 200, false);
	static ProductVM p5 = new CandysVM("Lollipop", 0, 12,
			"A type of sugar candy consisting of hard candy mounted on a stick.", 150, true);
	// SnacksVM((...),int weight, boolean brittle)
	static ProductVM p6 = new SnacksVM("Cake", 0, 18, "Small baked cake with flavor vanilla", 240, false);
	static ProductVM p7 = new SnacksVM("Peanut", 0, 21, "Salt peanut in pouch", 210, true);
	static ProductVM p8 = new SnacksVM("Biscuits", 0, 17, "A flour-based baked food.", 160, true);
	
	private static List<ProductVM> pList= Arrays.asList(p0,p1,p2,p3,p4,p5,p6,p7,p8);
	
	
	@Override
	public String printChanges() {
		String re = "Return balance: " + balance + "Kr\nYou get change: ";
		int max =0;
		for (int n:changes) {
			if(n>0) {
				max++;
			}
		}
		int n = 1;
		if (getBalance() != 0) {
			for (int i = 0; i < DENOMINATIONS.length; i++) {
				if (changes[i] != 0) {
					if (n == max) {
						re += changes[i] + "st " + DENOMINATIONS[i] + "Kr.";
					} else {
						re += changes[i] + "st " + DENOMINATIONS[i] + "Kr| ";
						n++;
					}
				}
			}
		} else {
			re += "None.";
		}
		return re;
	}

	@Override
	public ProductVM getProduct(int id) {
		return pList.get(id);
	}

	public static void countChanges() {
		for (int i = DENOMINATIONS.length-1; i >= 0; i--) {
			int n = balance;
			for (int j = DENOMINATIONS.length-1; j > i; j--) {
				n %= DENOMINATIONS[j];
			}
			changes[i] = n / DENOMINATIONS[i];
		}
		
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		VendingMachineImp.balance = balance;
		countChanges();
	}
	
	public static int[] getChanges() {
		return changes;
	}
}
