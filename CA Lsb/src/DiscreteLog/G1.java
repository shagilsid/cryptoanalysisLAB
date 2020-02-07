package DiscreteLog;

public class G1 extends G{
	
	
	
	G1(int p, int q, int r) {
		super(p,q,r) ;
		// TODO Auto-generated constructor stub
	}

	@Override
	int fofx(int x) {
		
		return (int)Math.pow(x, 2)%p;
	}
	
	@Override
	int gofx(int x, int n) {
		
		return (2*n)%(p-1);
	}
	
	@Override
	int hofx(int x, int n) {
		
		return (2*n)%(p-1);
	}
}
