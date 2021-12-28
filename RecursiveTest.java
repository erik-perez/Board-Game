import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RecursiveTest {
    private int V;
    private int[] boardArr;
    private boolean[] visited;

    public RecursiveTest(int V) {
        this.V=V;
        boardArr=new int[V*V];
        visited = new boolean[V*V];
        CreateBoard();
    }

    private void CreateBoard() {
        int xZero = ThreadLocalRandom.current().nextInt(0,V*V);
        for (int i = 0 ; i<boardArr.length ; i++) {
            if(i!=xZero) {
                int r = ThreadLocalRandom.current().nextInt(1,V);
                boardArr[i]=r;
            }
        }
    }

    public void printBoard(){
        for (int i=0; i<boardArr.length;i++) {
            System.out.print(boardArr[i] + " ");
            if((i+1)%V==0) {
                System.out.println();
            }
        }
    }

    public boolean Play(int x) {
        Queue<Integer> q = new LinkedList<Integer>();

        int num;
        int i;
        int j;
        q.add(x);
        visited[x]=true;

        while(!q.isEmpty()) {
            x = q.poll();
            num = boardArr[x];

            System.out.print(x+" ");
            if (num==0) return true;
            i=x/V;
            j=x%V;

            if((i+num)<V) {
                x=V*(i+num)+j;
                if (!visited[x]) {
                    q.add(x);
                    visited[x]=true;
                }
            }
            if((i-num)>=0) {
                x=V*(i-num)+j;
                if (!visited[x]) {
                    q.add(x);
                    visited[x]=true;
                }
            }
            if((j+num)<V) {
                x=(V*i)+j+num;
                if (!visited[x]) {
                    q.add(x);
                    visited[x]=true;
                }
            }
            if((j-num)>=0) {
                x=(V*i)+j-num;
                if (!visited[x]) {
                    q.add(x);
                    visited[x]=true;
                }
            }
        }

        return false;
    }

    public boolean PlayMagicBoard() {
        if(Play(0)) return true;
        if(Play(V-1)) return true;
        if(Play((V*V)-V)) return true;
        if(Play((V*V)-1)) return true;
        return false;
    }
}
