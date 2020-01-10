package affine;
import java.util.*;

enum ALPHA{
	a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
}
class Affine{
public static void main(String[] args){
	ALPHA alpha[]=ALPHA.values();
	Scanner scan=new Scanner(System.in);
	System.out.println("enter message");
	String m=scan.nextLine();
	System.out.println("Enter k1 and k2");
	int k1=scan.nextInt();
	int k2=scan.nextInt();
	if(gcd(k1,26)!=1)
		System.exit(0);
	
	String c=encrypt(k1,k2,m);
	
	hack(m,c);

}

private static void hack(String m, String c) {
	int m1=ALPHA.valueOf(String.valueOf(m.charAt(0))).ordinal();
	int m2=ALPHA.valueOf(String.valueOf(m.charAt(1))).ordinal();
	int c1=ALPHA.valueOf(String.valueOf(c.charAt(0))).ordinal();
	int c2=ALPHA.valueOf(String.valueOf(c.charAt(1))).ordinal();
	
	int a=m1-m2;
	int b=c1-c2;
	if(a<0) {
		a+=26;
	}
	a%=26;
	
	
	if(b<0) {
		b+=26;
	}
	b%=26;
	
	
	int k1=calculateInverse(b,a);
	int k2=c2-m2*k1;
	if(k2<0) {
		k2+=26;
	}
	k2%=26;
	
	System.out.println("Values of k1 is "+k1);
	System.out.println("Values of k2 is "+k2);
	
}

private static int calculateInverse(int b, int a) {
	int i=1;
	while((a*i)%26!=b) {
		i++;
	}
	return i;
}	

private static String encrypt(int k1, int k2, String m) {
	StringBuilder sb=new StringBuilder(m.length());
	for(int i=0;i<m.length();i++){
	
		int c=(ALPHA.valueOf(String.valueOf(m.charAt(i))).ordinal()*k1+k2)%26;
		System.out.print(" "+c);
		sb.append(ALPHA.values()[c]);
		
	}
	System.out.println();
	System.out.println(sb.toString());
	return sb.toString();
	
}

private static int gcd(int k1, int i) {
	 if (i == 0) 
	        return k1; 
	      return gcd(i, k1 % i);  
}

}