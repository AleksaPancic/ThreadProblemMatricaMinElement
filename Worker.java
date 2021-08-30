package aleksa;

public class Worker implements Runnable{
	private int a[][];
	private int n;
	private int l,r;
	private int zbir = 0;
	
	
	public Worker(int[][] a, int n, int l, int r) {
		super();
		this.a = a;
		this.n = n;
		this.l = l;
		this.r = r;
	}


	@Override
	public void run() {
		int najmanji = 999999999;
		for(int i = l; i <= r; i++) {
			najmanji = 999999999;
			for(int j = 0; j < n; j++) {
				if(najmanji > a[i][j]) {
					najmanji = a[i][j];
				}
			}
			zbir+=najmanji; //1 + 4 + 6
			}
		}
	


	/**
	 * @return the zbir
	 */
	public int getZbir() {
		return zbir;
	}
	
	
}
