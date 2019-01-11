package se.lexicon.Li.VendingMachineAS;

import org.junit.*;

public class MyBagTest {

	private MyBag testBag;

	@Before
	public void infor() {
		testBag = new MyBag();
	}

	@Test
	public void get_class_from_index_check() {
		/**
		 * space[0]=new DrinksVM("Cola",0,0,15,
		 * "A sweetened, carbonated soft drink flavored with vanilla, cinnamon, citrus oils and other flavorings.", 
		 * "33cl-Can",true); 
		 * space[1]=new DrinksVM("Sprite",0,0,20,
		 * "A colorless, caffeine-free, lemon and lime-flavored soft drink.", 
		 * "50cl-Bottle",true);
		 */
		String expected = "Cola";
		Assert.assertTrue(expected.equals(testBag.getFromIndex(0).getName()));
		Assert.assertEquals(20, testBag.getFromIndex(1).getPrice(), 0);
	}

	@Test
	public void match_ID_tset() {
		/**
		 * Index 	0,1,2,3,4,5,6... 
		 * Amount 	0,4,0,0,2,0,1... 
		 * Place 	0,1,0,0,2,0,3...
		 */
		testBag.getFromIndex(1).setAmount(4);
		testBag.getFromIndex(6).setAmount(2);
		testBag.getFromIndex(4).setAmount(1);
		testBag.toString();
		Assert.assertEquals(4, testBag.matchID(2), 0);

	}
}
