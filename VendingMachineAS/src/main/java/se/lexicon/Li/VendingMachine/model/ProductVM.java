package se.lexicon.Li.VendingMachine.model;

public abstract class ProductVM {
	private String name;
	private int price;
	private int amount;
	private String productInfor;

	public abstract String toString();

	public abstract void toUse();

	public String nameAndPrice() {
		return getName() + " " + getPrice() + "kr/st";
	}

	public ProductVM(String name, int amount, int price, String productInfor) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.productInfor = productInfor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrise(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductInfor() {
		return productInfor;
	}

	public void setProductInfor(String productInfor) {
		this.productInfor = productInfor;
	}

}
