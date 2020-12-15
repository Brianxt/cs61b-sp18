package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N;
    private boolean[] firstGrid;
    private WeightedQuickUnionUF weightedGrid;
    private WeightedQuickUnionUF backWash;
    boolean percolated = false;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N is excepted to be greater than 0");
        }
        this.N = N;
        firstGrid = new boolean[N * N];
        for (int i = 0; i < N * N; i++) {
            firstGrid[i] = false;
        }
        weightedGrid = new WeightedQuickUnionUF(N * N + 2);
        backWash = new WeightedQuickUnionUF(N * N + 1);
    }

    private int xyTo1D(int row, int col) {
        return N * row + col;
    }

    public void open(int row, int col) {
        if (outOfBounds(row, col)) {
            throw new IndexOutOfBoundsException("Illegal row or colon");
        }
        if (!firstGrid[xyTo1D(row, col)]) {
            firstGrid[xyTo1D(row, col)] = true;
            unionNeighborhood(row, col, row - 1, col);
            unionNeighborhood(row, col, row + 1, col);
            unionNeighborhood(row, col, row, col - 1);
            unionNeighborhood(row, col, row, col + 1);
        }
        if (weightedGrid.connected(N * N, N * N + 1)) {
            percolated = true;
        }
    }

    private boolean outOfBounds(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            return true;
        }
        return false;
    }

    private void unionNeighborhood(int row, int col, int neighborRow, int neighborCol) {
        if (outOfBounds(neighborRow, neighborCol)) {
            return;
        }
        if ((row == 0) && (!weightedGrid.connected(xyTo1D(row, col), N * N))) {
            weightedGrid.union(xyTo1D(row, col), N * N);
            backWash.union(xyTo1D(row, col), N * N);
        } else if ((row == N - 1) && (!weightedGrid.connected(xyTo1D(row, col), N * N + 1))) {
            weightedGrid.union(xyTo1D(row, col), N * N + 1);
        }
        if (firstGrid[xyTo1D(neighborRow, neighborCol)] && !weightedGrid.connected(xyTo1D(row, col), xyTo1D(neighborRow, neighborCol))) {
            weightedGrid.union(xyTo1D(row, col), xyTo1D(neighborRow, neighborCol));
            backWash.union(xyTo1D(row, col), xyTo1D(neighborRow, neighborCol));
        }
    }

    public boolean isOpen(int row, int col) {
        return firstGrid[xyTo1D(row, col)];
    }

    public boolean isFull(int row, int col) {
        if (weightedGrid.connected(N * N, xyTo1D(row, col))
                && backWash.connected(xyTo1D(row, col), N * N)) {
            return true;
        }
        return false;
    }

    public boolean percolates() {
        return percolated;
    }

    /**public static void main(String[] args) {
        Percolation p = new Percolation(4);
        System.out.println(p.percolates());
        p.open(1, 1);
        p.open(1, 2);
        System.out.println(p.isOpen(0, 1));
        System.out.println(p.isOpen(1, 2));
        p.open(2, 2);
        System.out.println(p.isFull(2, 2));
        //System.out.println(p.percolates());
        p.open(0, 2);
        System.out.println(p.percolates());
        p.open(2, 3);
        System.out.println(p.isFull(2, 3));
        p.open(3, 3);
        System.out.println(p.percolates());
        p.open(3, 0);
        System.out.println(p.isFull(3, 0));
    }*/
}
