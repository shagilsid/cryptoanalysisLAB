package DiscreteLog;

public class G {
	int p;
	int q;
	int r;
	G(int p,int q,int r) {
		this.p=p;
		this.q=q;
		this.r=r;
	}
	
	int fofx(int x) {
		return (r*x)%p;
	}
	
	int gofx(int x,int n) {
		return (n+1)%(p-1);
	}
	
	int hofx(int x, int n) {
		return n%(p-1);
	}
}
