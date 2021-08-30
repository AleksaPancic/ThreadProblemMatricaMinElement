package aleksa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {
public static void F(int a[][], int n, int t) {
	Worker[] workers = new Worker[t];
	ExecutorService executor = Executors.newFixedThreadPool(t);
	int d = n/t;
	for(int i = 0; i < t; i++) {
		workers[i] = new Worker(a, n, i*d, (i == d-1) ? n - 1: (i + 1) * d - 1);
	}
	
	for(int i = 0; i < t; i++) {
		executor.submit(workers[i]);
	}
	
	executor.shutdown();
	
	try {
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	int rez = 0;
	for(int i = 0; i < t; i++) {
		rez += workers[i].getZbir();
	}
	System.out.println("Zbir najmanjih elemenata je: " + rez);
}
public static void main(String[] args) {
	int n = 5;
	int t = 2;
	int a[][] = new int[n][n];
	a[0][0] = 0;
	a[0][1] = 1;
	a[0][2] = 3;
	a[0][3] = 3;
	a[0][4] = 3;
	a[1][3] = 3;
	a[1][0] = 4;
	a[1][1] = 5;
	a[1][2] = 6;
	a[1][4] = 3;
	a[2][0] = 7;
	a[2][1] = 8;
	a[2][2] = 9;
	a[2][3] = 3;
	a[2][4] = 3;
	a[3][1] = 8;
	a[3][2] = 9;
	a[3][3] = 3;
	a[3][4] = 3;
	a[4][1] = 8;
	a[4][2] = 9;
	a[4][3] = 3;
	a[4][4] = 3;
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			System.out.print(a[i][j]);
		}
		System.out.println();
	}
	F(a, n, t);
}
}
