package se.lexicon.Li.VendingMachineAS;

public class VendingMF {
	//Arrays for 1kr, 5kr, 10kr, 20kr, 50kr, 100kr, 500kr and 1000kr. 
		private final int [] denominations= {1,5,10,20,50,100,500,1000};
		private int [] changes=new int [8];
		private int balance;
		
		public void buyMenu() {
			System.out.println("Enter Id:");
		}
		/**
		 * Get a valid number of denomination
		 * @return number
		 */
		public int getVinputB() {
			boolean valid = false;
	    	int n= 0;
	    	while(!valid) {
	    		switch (n=FixInt.getInt()) {
	    		case 1:
	    		case 5:
	    		case 10:
	    		case 20:
	    		case 50:
	    		case 100:
	    		case 500:
	    		case 1000:
	    			valid=true;
	    			break;
	    		default:
	    			System.out.println("not a valid Denomination.");
	    		}
	    	}
	    	return n;    
		}

		public void countChanges() {
	/*		denominations[7] = balance/1000;
			denominations[6] = balance%1000/500;
			denominations[5] = balance%1000%500/100;
			denominations[4] = balance%1000%500%100/50;
			denominations[3] = balance%1000%500%100%50/20;
			denominations[2] = balance%1000%500%100%50%20/10;
			denominations[1] = balance%1000%500%100%50%20%10/5;
			denominations[0] = balance%1000%500%100%50%20%10%5/1;
	*/
			for(int i=0;i<denominations.length;i++ ) {
				int n=getBalance();
				for (int j=0;j<i;j++) {
					n %= denominations[denominations.length-j-1];
				}
				changes[denominations.length-i-1] = n /denominations[denominations.length-i-1];
			}
		}
		
		/**
		 * String tells how many changes you get
		 * @return String
		 */
		public String printChanges() {
			String re = "Return balance: " + balance+"Kr\nYou get change: ";
			int n1=FixArr.remove0(changes).length;
			int n2=1;
			for (int i=0;i<denominations.length;i++) {
				if(changes[i]!=0) {
					if (n2==n1) {
						re+=changes[i]+"st "+denominations[i]+"Kr.";
					}else {
						re+=changes[i]+"st "+denominations[i]+"Kr,";
						n2++;
					}
				}
			}
			return re;
		}

		public VendingMF(int balance) {
			this.balance = balance;
			countChanges();
		}
		public int getBalance() {
			return balance;
		}
		/**
		 * auto countChanges when set balance
		 * @param balance
		 */
		public void setBalance(int balance) {
			this.balance = balance;
			countChanges();
		}
		public int [] getChanges() {
			return changes;
		}
		public void setChanges(int [] changes) {
			this.changes = changes;
		}
}
