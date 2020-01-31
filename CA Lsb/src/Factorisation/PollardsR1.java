package Factorisation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PollardsR1 {
	 static void run() {
		 Scanner scan=new Scanner(System.in);
		 double N=scan.nextDouble();
		 double B=50;
		 ArrayList<Integer> pList=new ArrayList<Integer>();
		 for (int i = 2; i <B; i++) {
			 int flag=0;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j==0) {
					flag=1;
					break;
				}
			}
			if(flag==0) {
				pList.add(i);
			}
		}
		 
		 double b=2;
		 Iterator<Integer> it=pList.iterator();
		 while(it.hasNext()) {
			 Integer i=it.next();
			 double e=Math.log10(B)/Math.log10(i);
			 double f=Math.pow(i, e);
			 b=Math.pow(b, f)%N;
			 
		 }
		 
		 double g=gcd(N-1,b);
		 if(g>1&&g<b) {
			 System.out.println(g+" is a factor of "+b);
		 }else {
			 System.out.println("algo fails");
		 }
		 
		 for (Iterator iterator = pList.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
			
		}
		 
	 }
	 public static double gcd(double i, double n) {
			if(n==0)
				return i;
			
			return gcd(n,i%n);
		}

}
