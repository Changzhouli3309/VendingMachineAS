package se.lexicon.Li.VendingMachineAS;

public class VendingMF {
	// Arrays for 1kr, 5kr, 10kr, 20kr, 50kr, 100kr, 500kr and 1000kr.
	private final int[] denominations = { 1, 5, 10, 20, 50, 100, 500, 1000 };
	private int[] changes = new int[8];
	private int balance;

	public void buyMenu() {
		System.out.println("Enter Id:");
	}

	/**
	 * Get a valid number of denomination
	 * 
	 * @return number
	 */
	public int getVinputB() {
		while (true) {
			int n = FixInt.getInt();
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

	public void countChanges() {
		/*
		 * denominations = { 1, 5, 10, 20, 50, 100, 500, 1000 };
		 * changes[7] = balance/1000; 
		 * changes[6] = balance%1000/500;
		 * changes[5] = balance%1000%500/100; 
		 * changes[4] = balance%1000%500%100/50; 
		 * changes[3] = balance%1000%500%100%50/20;
		 * changes[2] = balance%1000%500%100%50%20/10; 
		 * changes[1] = balance%1000%500%100%50%20%10/5; 
		 * changes[0] = balance%1000%500%100%50%20%10%5/1;
		 */
		for (int i = denominations.length-1; i >= 0; i--) {
			int n = getBalance();
			for (int j = denominations.length-1; j > i; j--) {
				n %= denominations[j];
			}
			changes[i] = n / denominations[i];
		}
	}

	/**
	 * String tells how many changes you get
	 * 
	 * @return String
	 */
	public String printChanges() {
		String re = "Return balance: " + balance + "Kr\nYou get change: ";
		int max = FixArr.remove0(changes).length;
		int n = 1;

		if (getBalance() != 0) {
			for (int i = 0; i < denominations.length; i++) {
				if (changes[i] != 0) {
					if (n == max) {
						re += changes[i] + "st " + denominations[i] + "Kr.";
					} else {
						re += changes[i] + "st " + denominations[i] + "Kr| ";
						n++;
					}
				}
			}
		} else {
			re += "None.";
		}
		return re;
	}
	public VendingMF() {
		this.balance=0;
	}
	/**
	 * auto countChanges when set balance
	 * 
	 * @param balance
	 */
	public VendingMF(int balance) {
		this();
		setBalance(balance);
	}

	public int getBalance() {
		return balance;
	}

	/**
	 * auto countChanges when set balance
	 * 
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
		countChanges();
	}

	public int[] getChanges() {
		return changes;
	}

	public void setChanges(int[] changes) {
		this.changes = changes;
	}
}
