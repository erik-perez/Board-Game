import java.util.*;
public class Graph {
    List<Edge> G[];
    int n;

    class Edge{
        int v;
        public Edge(int v) {
            this.v=v;
        }
        public String toString() {
            return "("+v+")";
        }
    }

    public void addEdge(int u, int v) {
        G[u].add(0,new Edge(v));
    }

    public boolean isConnected(int u, int v) {
        for (Edge i: G[u])
            if (i.v==v) return true;
        return false;
    }

    public Graph(int n) {
        this.n=n;
        G = new LinkedList[n];
        for(int i=0; i<G.length; i++) {
            G[i]= new LinkedList<Edge>();
        }
    }

    boolean BFS(int s,int f) {

        boolean visited[] = new boolean[n];

        Queue<Integer> queue = new LinkedList<Integer>();


        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {

            s = queue.poll();
            System.out.print(s+" ");
            if (s==f) {
                return true;
            }

            Iterator<Edge> i = G[s].listIterator();
            while (i.hasNext())
            {
                Edge next = i.next();
                if (!visited[next.v])
                {
                    visited[next.v] = true;
                    queue.add(next.v);
                }
            }
        }
        return false;
    }
}

