package se.lexicon.Li.VendingMachineAS.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.Li.VendingMachineAS.model.ProductVM;

public class UsersBagImp implements UsersBag {
	private static List<ProductVM> items = new ArrayList<>();

	@Override
	public void addItem(ProductVM p) {
		boolean toAdd = true;
		for (ProductVM bp : items) {
			if (bp.getName().equals(p.getName())) {
				bp.setAmount(bp.getAmount() + p.getAmount());
				toAdd = false;
				break;
			}
		}
		if (toAdd) {
			items.add(p);
		}
	}

	@Override
	public ProductVM getItem(int n) {
		return items.get(n);
	}

	@Override
	public boolean checkBag() {
		List<ProductVM> temp=new ArrayList<>();
		for (ProductVM p : items) {
			if (p.getAmount() != 0) {
				temp.add(p);
			}
		}
		items=temp;
		
		if (items.size() == 0) {
			System.out.println("---Your bag is empty---\n");
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String toStringBag() {
		String re="";
		if (checkBag()) {
			re += "------------Your-bag--------------\n";
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getAmount() != 0) {
					re += (i + 1) + "-" + items.get(i).getName() + " " + items.get(i).getAmount() + "st\n";
				}
			}
			re += "----------------------------------";

		}
		return re;
	}
	
	@Override
	public List<ProductVM> getList() {
		return items;
	}
}
