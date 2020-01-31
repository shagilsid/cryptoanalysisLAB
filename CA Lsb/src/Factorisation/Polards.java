package Factorisation;

import java.util.Random;
import java.util.Scanner;

public class Polards {

	public static void run() {
		System.out.println("Enter the value of N");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		Random r=new Random();
		int b=r.nextInt(n-3)+1;
		System.out.println("b is: "+b);
		int s=r.nextInt(n);
		System.out.println("s is: "+s);
		long A=s;
		long B=s;
		
		int g=1;
		while(g==1) {
			A=someFunction(A,b,n);
			B=someFunction(someFunction(B, b, n), b, n);
			g=gcd((int)Math.abs(A-B),n);
		}
		
		if(g<n && g>0) {
			System.out.println("Value of g= "+g);
			int i=1;
			while(g*i!=n) {
				System.out.print(".");
				i++;
			}
			System.out.println();
			System.out.println("another factor is "+i);
		}
		else {
			System.out.println(g);
			System.out.println("Unable to find");
		}

	}
	
	private static int gcd(int i, int n) {
		if(n==0)
			return i;
		
		return gcd(n,i%n);
	}

	static long someFunction(long x, int b,int n) {
		return  (long) ((Math.pow(x, 2)+b)%n);
	}

}
