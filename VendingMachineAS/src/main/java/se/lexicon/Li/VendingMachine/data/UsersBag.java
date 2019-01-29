package se.lexicon.Li.VendingMachine.data;

import java.util.List;

import se.lexicon.Li.VendingMachine.model.ProductVM;

public interface UsersBag {
	
	void addItem(ProductVM p);

	ProductVM getItem(int n);

	boolean checkBag();

	String toStringBag();
	
	List<ProductVM> getList();

}
