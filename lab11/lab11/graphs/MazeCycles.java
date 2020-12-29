package lab11.graphs;

//import java.util.Stack;
import edu.princeton.cs.algs4.Stack;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s = 0;
    //private int b;
    private int[] cameFrom;

    public MazeCycles(Maze m) {
        super(m);
    }


    @Override
    public void solve() {
        cameFrom = new int[maze.V()];
        cycle(s);
    }

    Stack<Integer> vv = new Stack<>();

    // Helper methods go here
    private void cycle(int v) {
        //edgeTo[v] = v;
        marked[v] = true;
        if (v == 0) {
            distTo[v] = 0;
            vv.push(v);
            announce();
            cameFrom[v] = v;
        }

        for (int w : maze.adj(v)) {
            /*if (vv.size() > 1) {
                int a = vv.pop();
                b = vv.peek();
                vv.push(a);
            }*/
            if (marked[w] && w != cameFrom[v]) {
                edgeTo[w] = v;
                for (int i = 0; i < vv.size() - 1; i++) {
                    int p = vv.pop();
                    edgeTo[vv.peek()] = p;
                    if (vv.peek() == w) {
                        break;
                    }
                }
            }
            if (!marked[w]) {
                //edgeTo[w] = v;
                cameFrom[w] = v;
                announce();
                vv.push(w);
                distTo[w] = distTo[v] + 1;
                cycle(w);
            }
        }
    }
}

