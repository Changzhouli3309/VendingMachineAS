package se.lexicon.Li.VendingMachineAS;

public class SnacksVM extends ProductsVM {
	private int weight;
	private boolean brittle;

	public SnacksVM(String name, int plats, int amount, int price, String productInfor, 
					int weight, boolean brittle) {
		super(name, plats, amount, price, productInfor);
		// TODO Auto-generated constructor stub
		this.weight = weight;
		this.brittle = brittle;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String re = getName() + " in " + weight + "g pouch\n";
		re += brittle ? "Brittle snack. " + getPrice() + "kr/st\n" 
				: "None brittle snack. " + getPrice() + "kr/st\n";
		re += getProductInfor() + "\n";
		return re;
	}

	@Override
	public void toUse() {
		// TODO Auto-generated method stub
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
