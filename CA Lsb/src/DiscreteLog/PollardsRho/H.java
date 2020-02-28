package DiscreteLog.PollardsRho;


public class H {
	int n;
	int p;
	
	H(int p){
		this.p=p;
	}
	int check(int x, int n) {
		this.n=n;
		
		if(x%3==0)
			return h1(x,n);
		else if(x%3==1)
			return h0(x,n);
		else
			return h2(x,n);
	}

	private int h0(int x, int n2) {
		// TODO Auto-generated method stub
		return n%(p-1);
	}

	private int h1(int x, int n2) {
		// TODO Auto-generated method stub
		return (2*n)%(p-1);
	}

	private int h2(int x, int n2) {
		// TODO Auto-generated method stub
		return (n+1)%(p-1);
	}
}
