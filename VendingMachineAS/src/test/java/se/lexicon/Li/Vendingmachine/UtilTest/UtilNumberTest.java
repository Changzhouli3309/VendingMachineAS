package se.lexicon.Li.Vendingmachine.UtilTest;

import org.junit.Test;

import se.lexicon.Li.VendingMachine.util.UtilNumber;

import org.junit.Assert;

public class UtilNumberTest {

	private static final int TEST_TIMES = 1000;
	
	@Test
	public void ramdom_number_generate_test() {
		int maxInt = 10, minInt = 1;
		double maxDou = 9.5, minDou = 1.9;
		for (int i = 0; i < TEST_TIMES; i++) {
			int testInt = UtilNumber.randomInt(maxInt, minInt);
			double testDou = UtilNumber.randomDouble(maxDou, minDou);
			Assert.assertTrue(maxInt >= testInt && minInt <= testInt);
			Assert.assertTrue(maxDou >= testDou && minInt <= testDou);
		}
	}

	@Test
	public void print_integer_number_test() {
		double n1 = 4.0;
		int n2 = 12, max = 123;

		String expected = "4";
		Assert.assertTrue(expected.equals(UtilNumber.printN(n1)));
		
		n1 = 4.12;
		expected = "4.12";
		Assert.assertTrue(expected.equals(UtilNumber.printN(n1)));

		int di = UtilNumber.printN(max).length();
		expected = "012";
		Assert.assertTrue(expected.equals(UtilNumber.addZero(n2, di)));

		di++;
		expected = "  12";
		Assert.assertTrue(expected.equals(UtilNumber.addSpaceBefore(n2, di)));

		di = 6;
		expected = "12    ";
		Assert.assertTrue(expected.equals(UtilNumber.addSpaceBehind(n2, di)));
	}

	@Test
	public void print_double_number_test() {
		double n1 = 2.4561, expectedD = 2.5;
		int de = 0, di = 3;
		
		String expectedS = "2";
		Assert.assertTrue(expectedS.equals(UtilNumber.printD(n1, de)));
		
		expectedS = "2.46";
		de = 2;
		Assert.assertTrue(expectedS.equals(UtilNumber.printD(n1, de)));
		
		expectedS = "002";
		de = 0;
		Assert.assertTrue(expectedS.equals(UtilNumber.printD(n1, de, di)));
		
		expectedS = "002.456";
		de = 3;
		Assert.assertTrue(expectedS.equals(UtilNumber.printD(n1, de, di)));

		de = 1;
		Assert.assertEquals(expectedD, UtilNumber.getRoundingDouble(n1, de), 0);

	}

}
