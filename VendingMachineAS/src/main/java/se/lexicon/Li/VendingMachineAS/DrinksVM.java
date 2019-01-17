package se.lexicon.Li.VendingMachineAS;

public class DrinksVM extends ProductsVM {
	private String container;
	private boolean carbonated;

	public DrinksVM(String name, int place, int amount, int price, String productInfor, 
			String container, boolean carbonated) {
		super(name, place, amount, price, productInfor);
		// TODO Auto-generated constructor stub
		this.container = container;
		this.carbonated = carbonated;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String re = getName() + " in " + container + "\n";
		re += carbonated ? "Carbonated Drink. " + getPrice() + "kr/st\n"
				: "None carbonated Drink. " + getPrice() + "kr/st\n";
		re += getProductInfor() + "\n";
		return re;
	}

	@Override
	public void toUse() {
		// TODO Auto-generated method stub
		System.out.println("You drink a " + container + " " + getName() + ".\n");
		setAmount(getAmount() - 1);
	}

}
