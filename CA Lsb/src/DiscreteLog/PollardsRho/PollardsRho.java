package DiscreteLog.PollardsRho;


import java.util.Scanner;

public class PollardsRho {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter value of a");
		int q=2;//a
		System.out.println("Enter value of b");
		int r=228;//b
		System.out.println("Enter value of p");
		int p=383;//p
		
		int []a=new int[100];
		a[0]=0;
		int[] b=new int[100];
		b[0]=0;
		int[] x=new int[100];
		x[0]=1;
		int i=0;
		
		System.out.println("i\txi\tbi\tai\tx2i\tb2i\ta2i");
		do {
			
			F f=new F(q,r,p);
			
			G g=new G(p);
			H h=new H(p);
			
			/*
			 * Every time you use a function, you have to check the group first and then
			 * use the function of that Group. Each Function has types: type 0, type 1 and
			 * type 2. Each type represents the group.
			 * 
			 * So what i have done is that every time a function is called, I have checked
			 * the group of that function and then called the corresponding function group.
			 */
			i=i+1;
			x[i]=f.check(x[i-1]);
			a[i]=g.check(x[i-1],a[i-1]);
			b[i]=h.check(x[i-1],b[i-1]);
			
			x[2*i]=f.check(f.check(x[2*i-2]));
			a[2*i]=g.check(f.check(x[2*i-2]), g.check(x[2*i-2], a[2*i-2]));
			b[2*i]=h.check(f.check(x[2*i-2]),h.check(x[2*i-2],b[2*i-2] ) );
			
			System.out.println(i+"\t"+x[i]+"\t"+b[i]+"\t"+a[i]+"\t"+x[2*i]+"\t"+b[2*i]+"\t"+a[2*i]);
			
		}while(x[i]!=x[2*i]);
		
		if(b[i]==b[2*i]) {
			System.out.println("Algo failed");
		}
		in.close();
	}

}
