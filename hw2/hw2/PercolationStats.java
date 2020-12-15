package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private int N;
    private int T;
    private Percolation[] p;
    private int[] num;
    //private boolean flag = true;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("Both N and T should be larger than 0!");
        }
        this.N = N;
        this.T = T;
        num = new int[T];
        p = new Percolation[T];
        for (int i = T; i > 0; i--) {
            p[T - i] = pf.make(N);
            while (!p[T - i].percolates()) {
                int row = StdRandom.uniform(0, N);
                int col = StdRandom.uniform(0, N);
                if (!p[T - i].isOpen(row, col)) {
                    p[T - i].open(row, col);
                    num[T - i] = num[T - i] + 1;
                }
            }
        }
    }

    public double mean() {
        return StdStats.mean(num);
    }

    public double stddev() {
        return StdStats.stddev(num);
    }

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }
}
