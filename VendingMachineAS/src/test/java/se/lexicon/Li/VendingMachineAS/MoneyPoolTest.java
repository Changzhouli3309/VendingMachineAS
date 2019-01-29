package se.lexicon.Li.VendingMachineAS;

import java.util.Arrays;

import org.junit.*;

import se.lexicon.Li.VendingMachine.data.VendingMachineImp;

public class MoneyPoolTest {
	private VendingMachineImp testvm=new VendingMachineImp();
	
	@Before
	public void infor(){
		testvm.setBalance(1234);
	}
	
	@Test
	public void d_arrays_match() {
		//Arrays for 1kr, 5kr, 10kr, 20kr, 50kr, 100kr, 500kr and 1000kr. 
		int []expected={4,0,1,1,0,2,0,1};
		Assert.assertTrue(Arrays.equals(VendingMachineImp.getChanges(),expected));
	}
}
