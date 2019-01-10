package se.lexicon.Li.VendingMachineAS;

public class App 
{
    public static void main( String[] args )
    {	
    	boolean run=true,inBag=false,picked=false;
    	VendingMF vmMF=new VendingMF(0);
    	MyBag mB= new MyBag();
    	
    	pl("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nWelcome to the Vending Machine!!!");
    	printVM();
    	while (run) {
			pl("---Menu---(balance: "+vmMF.getBalance()+"kr)\n"
					+ "1-Put money in, 2-Buy Staffs, 3-Check your bag, 4-Details, 5-Leave");
			switch (FixInt.getIntFromLimit(5, 1)) {
			case 1:
				pl("How much?(in rael denominations like: 1,5,10kr...)");
				vmMF.setBalance(vmMF.getBalance()+vmMF.getVinputB());
				break;
			case 2:
				if (vmMF.getBalance() == 0) {
					pl("You have 0 banlance in the vending machin.\n");
					break;
				} else {
					pl("Enter ID:");
					int id=FixInt.getIntFromLimit(9, 1)-1;
					pl(mB.getFromIndex(id).nameAndPrice()+"\nAmount:(0-cancel)");
					int amount=FixInt.getIntFromLimit(999, 0);
					if (amount!=0) {
						int restBalace=vmMF.getBalance()-amount*mB.getFromIndex(id).getPrice();
						if (restBalace<0) {
							pl("Your balance is too low to buy.\n");
						}else {
							vmMF.setBalance(restBalace);
							mB.getFromIndex(id).setAmount(amount);
							pl("You put "+amount+"st "+mB.getFromIndex(id).getName()+" in your bag.\n");
						}						
					}else {
						pl();
					}					
				}
				break;
			case 3:
				inBag=true;
				while (inBag) {
					pl(mB);
					if (!mB.isEmptyBag()) {
						pl("Enter number to pick item.(0-Back)");
						int choos = mB.matchID(FixInt.getIntFromLimit(mB.getAmountType(), 0));
						if (choos != 0) {
							picked=true;
							while (picked) {
								pl(mB.getFromIndex(choos).getName() + " " + 
										mB.getFromIndex(choos).getAmount() + "st");
								pl("1-Use, 2-Details, 3-Back");
								switch (FixInt.getIntFromLimit(3, 1)) {
								case 1:
									//Amount-1,when use
									mB.getFromIndex(choos).toUse();
									if (mB.getFromIndex(choos).getAmount()==0) {
										picked=false;
									}
									break;
								case 2:
									pl(mB.getFromIndex(choos));
									break;
								case 3:
									picked=false;
									break;
								}
							}
						} else {
							pl();
							inBag=false;
						}
					}else {
						inBag=false;
					}
				}
				break;
			case 4:
				printVM();
				pl("Eneter ID:(0-back)");
				int n =FixInt.getIntFromLimit(9, 0)-1;
				if(n!=-1) {
					pl(mB.getFromIndex(n));
				}
				break;
			case 5:
				run=!YOrN.bool("Are sure to leave?(y/n)");
				if (!run) {
					pl(vmMF.printChanges());
				}
			}
		}
    	pl("You left the vending machine.");
    }
    
    /**
     * Draw the vending machine.
     */
    public static void printVM() {
    	MyBag b= new MyBag();
    	String[] prod= {"|Cola      ","|Sprite    ","|Juice     ",
    					"|Gum       ","|Chocolate ","|Lollipop  ",
    					"|Cake      ","|Peanut    ","|Biscuits  "};
    	String s = prod[1]+prod[2]+prod[3];
    	plLine(s.length()+1);
    	int n1=0,n2=0;
    	for (int i =0;i<prod.length;i++) {
    		switch(i){
    		case 2:
    		case 5:
    		case 8:
    			pt(prod[n1]+"|\n");
    			for (int j =0;j<3;j++) {
    	    		switch(n2){
    	    		case 2:
    	    		case 5:
    	    		case 8:
    	    			pt("|"+b.getFromIndex(n2).getPrice()+"kr,ID-0"+(n2+1)+"|\n");
    	    			plLine(s.length()+1);    	    			
    	    			break;
    	    		default:
    	    			pt("|"+b.getFromIndex(n2).getPrice()+"kr,ID-0"+(n2+1));
    	    			break;
    	    		}
    			n2++;
    			}
    			break;
    		default:
    			pt(prod[n1]);
    			break;
    		}
    		n1++;
    	}
    }
    
    
    public static void pl(ProductsVM p) {
    	System.out.println(p);
    }
    public static void pl(MyBag m) {
    	System.out.println(m);
    }
    public static void pl(VendingMF m) {
    	System.out.println(m);
    }
    public static void pl() {
    	System.out.println();
    }
    public static void pl(String s) {
    	System.out.println(s);
    }
    public static void pl(int n) {
    	System.out.println(n);
    }
    public static void pt(String s) {
    	System.out.print(s);
    }
    /**
     * print - 
     * @param n amount of -
     */
    public static void plLine(int n) {
    	for (int i =0;i<n;i++) {
    		if(i!=n-1) {
    			System.out.print("-");
    		}else {
    			System.out.print("-\n");
    		}
    		
    	}
    }
}
