package DiscreteLog.PollardsRho;

public class G {
	int n;
	int p;
	
	G(int p){
		this.p=p;
	}
	
	int check(int x, int n) {
		this.n=n;
		
		if(x%3==0)
			return g1(x,n);
		else if(x%3==1)
			return g0(x,n);
		else
			return g2(x,n);
	}

	private int g0(int x, int n2) {
		// TODO Auto-generated method stub
		return (n+1)%(p-1);
	}

	private int g1(int x, int n2) {
		// TODO Auto-generated method stub
		return (2*n)%(p-1);
	}

	private int g2(int x, int n2) {
		// TODO Auto-generated method stub
		return (n)%(p-1);
	}
}
