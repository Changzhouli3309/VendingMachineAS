package se.lexicon.Li.VendingMachineAS;

import org.junit.*;

import se.lexicon.Li.VendingMachineAS.data.UsersBagImp;
import se.lexicon.Li.VendingMachineAS.model.DrinksVM;
import se.lexicon.Li.VendingMachineAS.model.ProductVM;

public class MyBagTest {

	private UsersBagImp testBag = new UsersBagImp();
	static ProductVM p0 = new DrinksVM("Cola", 0, 15,
			"A sweetened, carbonated soft drink flavored with vanilla, cinnamon, citrus oils and other flavorings.",
			"33cl-Can", true);
	static ProductVM p1 = new DrinksVM("Sprite", 0, 20,
			"A colorless, caffeine-free, lemon and lime-flavored soft drink.", "50cl-Bottle", true);
	static ProductVM p2 = new DrinksVM("Juice", 0, 10, "Apple juice made by the maceration and pressing of an apple.",
			"33cl-Carton", false);

	@Before
	public void infor() {
		testBag.addItem(p0);
		testBag.addItem(p2);
		testBag.addItem(p1);
	}

	@Test
	public void get_class_from_index_check() {
		String expected = "Cola";
		Assert.assertTrue(expected.equals(testBag.getItem(0).getName()));
		Assert.assertEquals(20, testBag.getItem(2).getPrice(), 0);

		Assert.assertEquals(testBag.getItem(2), p1);

		testBag.getList().remove(0);
		Assert.assertEquals(testBag.getItem(1), p1);
	}

}
