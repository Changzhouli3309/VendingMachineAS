package se.lexicon.Li.VendingMachineAS.data;

import java.util.List;

import se.lexicon.Li.VendingMachineAS.model.ProductVM;

public interface UsersBag {
	
	void addItem(ProductVM p);

	ProductVM getItem(int n);

	boolean checkBag();

	String toStringBag();
	
	List<ProductVM> getList();

}
