package DiscreteLog;

public class G2 extends G{
	
	
	
	G2(int p, int q, int r) {
		super(p, q, r);
		// TODO Auto-generated constructor stub
	}

	@Override
	int fofx(int x) {
		// TODO Auto-generated method stub
		return (q*x)%p;
	}
	
	@Override
	int gofx(int x, int n) {
		// TODO Auto-generated method stub
		return n%(p-1);
	}
	
	@Override
	int hofx(int x, int n) {
		// TODO Auto-generated method stub
		return (n+1)%(p-1);
	}
}
