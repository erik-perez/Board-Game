import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class IterativeTest {
    private int V;
    private int[][] boardArr;
    Graph g;
    ArrayList<Integer> newArr;

    public IterativeTest(int V) {
        this.V=V;
        boardArr=new int[V][V];
        CreateBoard();
    }

    private void CreateBoard() {
        int xZero = ThreadLocalRandom.current().nextInt(0,V);
        int yZero = ThreadLocalRandom.current().nextInt(0,V);
        for (int i = 0 ; i<V ; i++) {
            for (int j = 0 ; j<V ; j++) {
                if(i!=xZero || j!=yZero) {
                    int r = ThreadLocalRandom.current().nextInt(1,V);
                    boardArr[i][j]=r;
                }
            }
        }
        makeGraph(V);
    }

    public int[][] getBoard(){
        return boardArr;
    }

    public void makeGraph(int d) {
        g = new Graph(d*d);
        int count=0;
        int num;
        newArr = new ArrayList<Integer>(d*d);
        for (int i = 0 ; i<d ; i++) {
            for (int j = 0 ; j<d ; j++) {
                num = boardArr[i][j];
                newArr.add(num);
                if((i+num)<d) {
                    g.addEdge(count, (d*(i+num))+j);
                }
                if((i-num)>=0) {
                    g.addEdge(count, (d*(i-num))+j);
                }
                if((j+num)<d) {
                    g.addEdge(count, (d*i)+j+num);
                }
                if((j-num)>=0) {
                    g.addEdge(count, (d*i)+j-num);
                }
                count++;
            }
        }
    }

    public boolean Play(int x, int y) {
        int z= newArr.indexOf(0);
        boolean solved = g.BFS((V*y)+x,z);
        return solved;
    }

    public boolean PlayMagicBoard() {
        if(Play(0,0)) return true;
        if(Play(0,V-1)) return true;
        if(Play(V-1,0)) return true;
        if(Play(V-1,V-1)) return true;
        return false;
    }

}