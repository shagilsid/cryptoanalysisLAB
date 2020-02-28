package DiscreteLog.PollardsRho;

public class F {
	 int a;
	 int b;
	 int p;
	F(int a, int b, int p) {
		this.a=a;
		this.b=b;
		this.p=p;
	}
	int check(int x) {
		
		if(x%3==0)
			return f1(x);
		else if(x%3==1)
			return f0(x);
		else
			return f2(x);
		
	}
	int f0(int x){
		return (b*x)%p;
	}
	
	int f1(int x) {
		return (x*x)%p;
	}
	int f2(int x) {
		return (a*x)%p;
	}
}
