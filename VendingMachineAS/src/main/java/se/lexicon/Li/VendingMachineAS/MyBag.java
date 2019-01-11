package se.lexicon.Li.VendingMachineAS;

public class MyBag {

	private ProductsVM[] space = new ProductsVM[9];
	private int amountType;

	private boolean emptyBag;

	// ProductsVM(String name, int place, int amount, int price, String productInfor)
	public MyBag() {
		// DrinksVM((...),String container,boolean carbohydrate)
		space[0] = new DrinksVM("Cola", 0, 0, 15,
				"A sweetened, carbonated soft drink flavored with vanilla, cinnamon, citrus oils and other flavorings.",
				"33cl-Can", true);
		space[1] = new DrinksVM("Sprite", 0, 0, 20, "A colorless, caffeine-free, lemon and lime-flavored soft drink.",
				"50cl-Bottle", true);
		space[2] = new DrinksVM("Juice", 0, 0, 10, "Apple juice made by the maceration and pressing of an apple.",
				"33cl-Carton", false);
		// CandysVM((...),int weight, boolean hard)
		space[3] = new CandysVM("Gum", 0, 0, 14,
				"A soft, cohesive substance designed to be chewed without being swallowed.", 90, false);
		space[4] = new CandysVM("Chocolate", 0, 0, 24,
				"A sweet, brown food preparation of roasted and ground cacao seeds.", 200, false);
		space[5] = new CandysVM("Lollipop", 0, 0, 12,
				"A type of sugar candy consisting of hard candy mounted on a stick.", 150, true);
		// SnacksVM((...),int weight, boolean brittle)
		space[6] = new SnacksVM("Cake", 0, 0, 18, "Small baked cake with flavor vanilla", 240, false);
		space[7] = new SnacksVM("Peanut", 0, 0, 21, "Salt peanut in pouch", 210, true);
		space[8] = new SnacksVM("Biscuits", 0, 0, 17, "A flour-based baked food.", 160, true);
	}

	/**
	 * Get element from space-arrays
	 * 
	 * @param n :index
	 * @return space[n]
	 */
	public ProductsVM getFromIndex(int n) {
		return space[n];
	}

	/**
	 * Find index after place-number
	 * 
	 * @param n place-number
	 * @return index of space-arrays
	 */
	public int matchID(int n) {
		for (int i = 0; i < space.length; i++) {
			if (n == space[i].getPlace()) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		for (int i = 0; i < space.length; i++) {
			space[i].setPlace(0);
		}
		String re = "------------Your-bag--------------\n";
		int n = 0;
		for (int i = 0; i < space.length; i++) {
			n += space[i].getAmount();
		}
		if (n != 0) {
			n = 1;
			for (int i = 0; i < space.length; i++) {
				if (space[i].getAmount() != 0) {
					re += n + "-" + space[i].getName() + " " + space[i].getAmount() + "st\n";
					space[i].setPlace(n);
					setAmountType(n);
					n++;
				}
			}
			re += "----------------------------------";
			setEmptyBag(false);
		} else {
			re = "---Your bag is empty---\n";
			setEmptyBag(true);
		}
		return re;
	}

	public ProductsVM[] getSpace() {
		return space;
	}

	public void setSpace(ProductsVM[] space) {
		this.space = space;
	}

	public boolean isEmptyBag() {
		return emptyBag;
	}

	public void setEmptyBag(boolean emptyBag) {
		this.emptyBag = emptyBag;
	}

	public int getAmountType() {
		return amountType;
	}

	public void setAmountType(int amountType) {
		this.amountType = amountType;
	}

}
