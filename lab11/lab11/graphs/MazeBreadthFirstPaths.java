package lab11.graphs;

import java.util.ArrayDeque;
//import java.util.Collection;
//import java.util.Iterator;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    //private boolean targetFound = false;
    private Maze maze;
    private static final int INFINITY = Integer.MAX_VALUE;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = m.xyTo1D(sourceX, sourceY);
        t = m.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int g) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int v = 0; v < maze.V(); v++) {
            distTo[v] = INFINITY;
        }
        distTo[g] = 0;
        marked[g] = true;
        queue.add(g);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : maze.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    queue.add(w);
                }
                announce();
            }
            if (queue.contains(t)) {
                return;
            }
        }
    }

    public void solve() {
        bfs(s);
    }
}

