import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class mathproj extends Gui implements ActionListener{
	public static char rungui = 'y'; //GUI Flag---------------------------------------------------------------------------
	static Gui interface1 = new Gui();
//begin xysolve method----------------------------------------------------------------------------------------------
public static int[][] xysolve(long a, long b, int gcd, int maxit, boolean verbose, int maxtry, boolean guiflag) {
		int[][] xyval = new int[2][50];
		xyval[0][0] = 9998;
		xyval[1][0] = 9999;
		
		/*for(int j=maxit; j>=0; j--) {
			System.out.println(alist[j] + ", " + blist[j] + ", " + qlist[j] + ", " + plist[j]);
		}*/
		long sol;
		int i = 0;
		for(int x=1; x<= maxtry; x++) {
			if (verbose == true) System.out.println("Trying x=" + x);
			for(int y=-1; y>=-maxtry; y--) { //x pos y neg
				sol = a*x+b*y;
				if (sol != gcd) {
					if (verbose == true) {System.out.println("No Solution at x=" + x + "  y=" + y);
					if(guiflag == true && verbose == true) { interface1.consolelog("No Solution at x=" + x + "  y=" + y); }
					}
				} else {
					System.out.println("Solution found at x=" + x + "   y=" + y);
					if(guiflag == true && verbose == true) { interface1.consolelog("Solution found at x=" + x + "   y=" + y); }
					xyval[0][i] = x;
					xyval[1][i] = y;
					i++;
				}
			}
			for(int y=1; y<=maxtry; y++) { //x pos y pos
				sol = a*x+b*y;
				if (sol != gcd) {
					if (verbose == true) {System.out.println("No Solution at x=" + x + "  y=" + y);
					if(guiflag == true && verbose == true) { interface1.consolelog("No Solution at x=" + x + "  y=" + y); }
					}
				} else {
					System.out.println("INVALID Solution found at x=" + x + "   y=" + y);
					if(guiflag == true && verbose == true) { interface1.consolelog("INVALID Solution found at x=" + x + "   y=" + y); }
					xyval[0][i] = x;
					xyval[1][i] = y;
					i++;
				}
			}
		}
		for(int x=-1; x>=-maxtry; x--) {
			if (verbose == true) System.out.println("Trying x=" + x);
			for(int y=-1; y>=-maxtry; y--) { //x neg y neg
				sol = a*x+b*y;
				if (sol != gcd) {
					if (verbose == true) {System.out.println("No Solution at x=" + x + "  y=" + y);
					if(guiflag == true && verbose == true) { interface1.consolelog("No Solution at x=" + x + "  y=" + y); }
					}
				} else {
					System.out.println("INVALID Solution found at x=" + x + "   y=" + y);
					if(guiflag == true && verbose == true) { interface1.consolelog("INVALID Solution found at x=" + x + "   y=" + y); }
					xyval[0][i] = x;
					xyval[1][i] = y;
					i++;
				}
			}
			for(int y=1; y<=maxtry; y++) { //x neg y pos
				sol = a*x+b*y;
				if (sol != gcd) {
					if (verbose == true) {System.out.println("No Solution at x=" + x + "  y=" + y);
					if(guiflag == true && verbose == true) { interface1.consolelog("No Solution at x=" + x + "  y=" + y); }
					}
				} else {
					System.out.println("Solution found at x=" + x + "   y=" + y);
					if(guiflag == true && verbose == true) { interface1.consolelog("Solution found at x=" + x + "   y=" + y); }
					xyval[0][i] = x;
					xyval[1][i] = y;
					i++;
				}
			}
		}
		return xyval;
	}//----------end xyval----------------------
//begin axby method call--------------------------------------------------------------------------------------------------------
 public static int[][] axby(int a, int b, boolean verbose, boolean guiflag) {	
	if(guiflag == false) {
	System.out.println("This program will solve solutions for x and y to the equation a*x+b*y=1 where gcd(a,b)=1");
	System.out.println("A solution is 'valid' if either x is positive and y is negative or x is negative and y is positive");
	System.out.println("a and b are specified as below:\n"); }
	//initial inputs------------------------------
	if(guiflag == true && a<1) { interface1.consolelog("A can not be negative or 0"); }
	if (a < 1) throw new IllegalArgumentException("A can not be negative or 0");
	System.out.println("a="+a);
	if(guiflag == true) { interface1.consolelog("a="+a); }
	if(guiflag == true && b<1) { interface1.consolelog("B can not be negative or 0"); }
	if (b < 1) throw new IllegalArgumentException("B can not be negative or 0");
	System.out.println("b="+b+"\n\n");
	if(guiflag == true) { interface1.consolelog("b="+b+"\n"); }
	if(guiflag == true && b==a) { interface1.consolelog("A can not equal B."); }
	if (b == a) throw new IllegalArgumentException("A can not equal B.");
	int maxtry = 0;
	if (a > b) {maxtry = a;} 
	else {maxtry = b;}
	int arraylen = 50;
	//--------------------------------------------
	//gcd traverse
	int q = b;
	int p = a;
	int[] alist = new int[arraylen];
	int[] blist = new int[arraylen];
	int[] plist = new int[arraylen];
	int[] qlist = new int[arraylen];
	int i = 0;
	System.out.println("Euclid's Algorithm to finding gcd(a,b):");
	if(guiflag == true) { interface1.consolelog("\nEuclid's Algorithm to finding gcd(a,b):"); }
	while (q != 0) {
		blist[i] = q;
		alist[i] = p;
        int temp = q;
        qlist[i] = p/q;
        plist[i] = p%q;
        q = p % q;
        p = temp;
        System.out.println(alist[i] + " = " + blist[i] + " * " + qlist[i] + " + " + plist[i]);
        if(guiflag == true) { interface1.consolelog(alist[i] + " = " + blist[i] + " * " + qlist[i] + " + " + plist[i]); }
        i++;  }
	i=i-1;
	int gcd = blist[i];
	if(guiflag == true) { interface1.gcdrelbl(a, b, gcd); }
	System.out.println("\ngcd("+a+","+b+") = "+gcd+"\n");
	if(guiflag == true) { interface1.consolelog("\ngcd("+a+","+b+") = "+gcd+"\n"); }
	if(gcd != 1 && guiflag == true) {
		interface1.validate(false);
		interface1.validrelbl("NOT VALID (gcd(a,b)≠1)");
	} else if(guiflag == true) {
		interface1.validate(true);
		interface1.validrelbl("VALID (gcd(a,b)=1)");
	}
	int[][] solution = new int[1][arraylen];
	//xysolve method call---------------------------------------------------------------------
	solution = xysolve(a, b, gcd, i, verbose, maxtry, guiflag);
	//----------------------------------------------------------------------------------------
	int k =0;
	System.out.println();
	if(guiflag == true) { interface1.consolelog(""); }
	while(solution[0][k] != 0 && solution[1][k] != 0) {
	int x = solution[0][k];
	int y = solution[1][k];
	//outputs---------------------------------------------------------------------------------
	if(x!=9998 && y!=9999) {
		if(x>=1 && y>=1) {
			System.out.println("Solution found, but invalid");
			if(guiflag == true) { interface1.consolelog("Solution found, but invalid"); }
		} else if(x<=-1 && y<=-1) {
			System.out.println("Solution found, but invalid");
			if(guiflag == true) { interface1.consolelog("Solution found, but invalid"); }
		} else {
			System.out.println("Solution: " + a + "*" + x + "+" + b + "*" + y + " = " + gcd);
			if(guiflag == true) { interface1.consolelog("Solution: " + a + "*" + x + "+" + b + "*" + y + " = " + gcd); }
		}
	} else {
		System.out.println("NO SOLUTIONS FOUND");
		if(guiflag == true) { interface1.consolelog("NO SOLUTIONS FOUND"); }
	}
	//----------------------------
	k++;
	}
	String xval = "";
	String yval = "";
	for(int z=0; z<k; z++) {
	xval =Integer.toString(solution[0][z]) + ", " + xval;
	yval =Integer.toString(solution[1][z]) + ", " + yval;
	}
	if(guiflag == true) txtX.setText("x= " + xval);
	if(guiflag == true) txtY.setText("y= " + yval);
	System.out.println("Finished with " + k + " solutions" + "\n--------------\n");
	if(guiflag == true) { interface1.consolelog("\nFinished with " + k + " solutions" + "\n--------------\n");}
	return solution;
 }
//end axby method---------------------------------------------------------------------------
 //main method--------------------------------------------------------------------------------
 public static void main(String[] args) {
        System.out.println("Run User Interface? (y/n)");
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        char rungui = scanner.next(".").charAt(0);
        if(rungui == 'y') {
        	EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					interface1.getFrame().setVisible(true);
    		            interface1.consolelog("Console Initiated.");
    		            calc_btn.addActionListener(new ActionListener() { 
    		    		    public void actionPerformed(ActionEvent e) {
    		    		    	 boolean verbose = false;
    		    		        if (verbose_ck.isSelected()) verbose = true;
								mathproj.axby(Integer.parseInt(a_input.getText()), Integer.parseInt(b_input.getText()), verbose, true);
    		    		    } 
    		    		});
    		            rand_btn.addActionListener(new ActionListener() { 
    		    		    public void actionPerformed(ActionEvent e) {
    		    		    	 boolean verbose = false;
    		    		    	 int a = ThreadLocalRandom.current().nextInt(1, 100 + 1);
    		    		    	 int b = ThreadLocalRandom.current().nextInt(1, 100 + 1);
    		    		    	 interface1.setA_input(a);
    		    		    	 interface1.setB_input(b);
    		    		        if (verbose_ck.isSelected()) verbose = true;
								mathproj.axby(Integer.parseInt(a_input.getText()), Integer.parseInt(b_input.getText()), verbose, true);
    		    		    } 
    		    		});
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
        } else if(rungui=='n') {
        	boolean verbose = false;
        	int a = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        	int b = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        	boolean guiflag = false;
        	axby(a, b, verbose, guiflag);
        } else {
        	throw new IllegalArgumentException("Not a valid input.");
        }
     }
@Override
public void actionPerformed(ActionEvent e) {}
}