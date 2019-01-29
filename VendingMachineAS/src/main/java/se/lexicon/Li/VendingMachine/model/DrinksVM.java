package se.lexicon.Li.VendingMachine.model;

public class DrinksVM extends ProductVM {
	private String container;
	private boolean carbonated;

	public DrinksVM(String name, int amount, int price, String productInfor, 
			String container, boolean carbonated) {
		super(name, amount, price, productInfor);
		this.container = container;
		this.carbonated = carbonated;
	}

	@Override
	public String toString() {
		String re = getName() + " in " + container + "\n";
		re += carbonated ? "Carbonated Drink. " + getPrice() + "kr/st\n"
				: "None carbonated Drink. " + getPrice() + "kr/st\n";
		re += getProductInfor() + "\n";
		return re;
	}

	@Override
	public void toUse() {
		System.out.println("You drink a " + container + " " + getName() + ".\n");
		setAmount(getAmount() - 1);
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public boolean isCarbonated() {
		return carbonated;
	}

	public void setCarbonated(boolean carbonated) {
		this.carbonated = carbonated;
	}

}
