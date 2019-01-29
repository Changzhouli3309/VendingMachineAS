package se.lexicon.Li.VendingMachine.model;

public class SnacksVM extends ProductVM {
	private int weight;
	private boolean brittle;

	public SnacksVM(String name, int amount, int price, String productInfor, 
					int weight, boolean brittle) {
		super(name, amount, price, productInfor);
		this.weight = weight;
		this.brittle = brittle;
	}

	@Override
	public String toString() {
		String re = getName() + " in " + weight + "g pouch\n";
		re += brittle ? "Brittle snack. " + getPrice() + "kr/st\n" 
				: "None brittle snack. " + getPrice() + "kr/st\n";
		re += getProductInfor() + "\n";
		return re;
	}

	@Override
	public void toUse() {
		System.out.println("You take a snack of " + getName() + ".\n");
		setAmount(getAmount() - 1);

	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
