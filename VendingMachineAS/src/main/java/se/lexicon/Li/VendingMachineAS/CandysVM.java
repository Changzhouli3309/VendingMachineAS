package se.lexicon.Li.VendingMachineAS;

public class CandysVM extends ProductsVM {
	private int weight;
	private boolean hard;

	public CandysVM(String name, int place, int amount, int price, String productInfor, 
					int weight, boolean hard) {
		super(name, place, amount, price, productInfor);
		// TODO Auto-generated constructor stub
		this.weight = weight;
		this.hard = hard;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String re = getName() + " in " + weight + "g pouch\n";
		re += hard ? "Hard candy. " + getPrice() + "kr/st\n" 
				: "None hard candy. " + getPrice() + "kr/st\n";
		re += getProductInfor() + "\n";
		return re;
	}

	@Override
	public void toUse() {
		// TODO Auto-generated method stub
		System.out.println("You eat a " + getName() + ".\n");
		setAmount(getAmount() - 1);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isHard() {
		return hard;
	}

	public void setHard(boolean hard) {
		this.hard = hard;
	}

}
