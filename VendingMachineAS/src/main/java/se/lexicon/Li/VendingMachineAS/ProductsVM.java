package se.lexicon.Li.VendingMachineAS;

public abstract class ProductsVM {
	private String name;
	private int place;
	private int price;
	private int amount;
	private String productInfor;

	public abstract String toString();

	public abstract void toUse();

	public String nameAndPrice() {
		return getName() + " " + getPrice() + "kr/st";
	}

	public ProductsVM(String name, int place, int amount, int price, String productInfor) {
		this.name = name;
		this.place = place;
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

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public String getProductInfor() {
		return productInfor;
	}

	public void setProductInfor(String productInfor) {
		this.productInfor = productInfor;
	}

}
