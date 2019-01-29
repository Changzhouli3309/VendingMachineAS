package se.lexicon.Li.VendingMachine.data;

import se.lexicon.Li.VendingMachine.model.ProductVM;

public interface VendingMachine {
	int[] DENOMINATIONS = { 1, 5, 10, 20, 50, 100, 500, 1000 };

	String printChanges();

	ProductVM getProduct(int id);
}
