package DiscreteLog;

import java.util.ArrayList;
import java.util.Scanner;

public class PollardsRho {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter value of a");
		int q=in.nextInt();
		System.out.println("Enter value of b");
		int r=in.nextInt();
		System.out.println("Enter value of p");
		int p=in.nextInt();
		
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(0, 0);
		ArrayList<Integer> b=new ArrayList<Integer>();
		b.add(0, 0);
		ArrayList<Integer> x=new ArrayList<Integer>();
		x.add(0,1);
		int i=0;
		G g=new G(p,r,q);
		System.out.println("i\txi\tbi\tai\tx2i\tb2i\ta2i");
		do {
			
			g=checkG(x.get(i),p,q,r);
			
			i=i+1;
			x.add(i,g.fofx(x.get(i-1)));
			a.add(i,g.gofx(x.get(i-1),a.get(i-1)));
			b.add(i,g.hofx(x.get(i-1),b.get(i-1)));
			
//			int xtemp1=x.get(2*i-2);
			
//			g=checkG(xtemp1,p,q,r);
//			
//			int xtemp2=g.fofx(xtemp1);
//			
//			g=checkG(xtemp2,p,q,r);
//			
//			x.add(2*i,g.fofx(xtemp2));
//			g=checkG(xtemp1,p,q,r);
			
			int xtemp1=g.fofx(x.get(2*i-2));
			g=checkG(xtemp1, p, q, r);
			x.add(2*i,g.fofx(xtemp1));
			
			g=checkG(x.get(2*i-2),p,q,r);
			xtemp1=g.gofx(x.get(2*i-2), a.get(2*i-2));
			int xtemp2=g.fofx(x.get(2*i-2));
			g=checkG(xtemp2, p, q, r);
			a.add(2*i,g.gofx(xtemp2, xtemp1));
			
//			a.add(2*i,g.gofx(g.fofx(x.get(2*i-2)), g.gofx(x.get(2*i-2), a.get(2*i-2))));
			g=checkG(x.get(2*i-2),p,q,r);
			xtemp1=g.hofx(x.get(2*i-2), a.get(2*i-2));
			xtemp2=g.fofx(x.get(2*i-2));
			g=checkG(xtemp2,p,q,r);
			b.add(2*i,g.hofx(xtemp2, xtemp1));
			//b.add(2*i,g.hofx(g.fofx(x.get(2*i-2)), g.hofx(x.get(2*i-2), b.get(2*i-2))));
			
			System.out.println(i+"\t"+x.get(i)+"\t"+b.get(i)+"\t"+a.get(i)+"\t"+x.get(2*i)+"\t"+b.get(2*i)+"\t"+a.get(2*i));
			
		}while(x.get(i)!=x.get(2*i));
		
		if(b.get(i)==b.get(2*i)) {
			System.out.println("Algo failed");
		}
		int m=(a.get(i)-a.get(2*i))%(p-1);
		int n=(b.get(2*i)-b.get(i))%(p-1);
		
		

	}

	private static G checkG(int i,int p,int q,int r) {
		if(i%3==0)
			return new G1(p,q,r);
		else if(i%3==2)
			return new G2(p,q,r);
		else {
			return new G(p,q,r);}
		
	}

	

}
