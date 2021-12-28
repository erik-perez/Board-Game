import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int V;
    private int[][] boardArr;
    private int x;
    private int y;
    private int xZero;
    private int yZero;
    private boolean[][] visited;

    public Board(int V) {
        this.V=V;
        this.x=0;
        this.y=0;
        boardArr = new int[V][V];
        visited = new boolean[V][V];
        this.xZero = ThreadLocalRandom.current().nextInt(0,V);
        this.yZero = ThreadLocalRandom.current().nextInt(0,V);
        this.CreateBoard();
    }

    public void CreateBoard() {
        if (x==V-1 && y==V) {
            x=0;
            y=0;
            return;
        }
        if (y>V-1 && x!=V-1) {
            y=0;
            x++;
        }
        if (x!=xZero || y!=yZero) {
            int r = ThreadLocalRandom.current().nextInt(1,V);
            boardArr[x][y]=r;
        }
        y++;
    }

    public boolean Play(int x, int y) {

        if (x<0 || x>=V || y<0 || y>=V)
            return false;
        if (visited[x][y]==true)
            return false;

        int num = boardArr[x][y];
        System.out.println(num);
        visited[x][y]=true;

        if (num==0)
            return true;
        if (Play(x+num,y))
            return true;
        if (Play(x-num,y))
            return true;
        if (Play(x,y+num))
            return true;
        if (Play(x,y-num))
            return true;

        return false;
    }

    public boolean PlayMagicBoard() {
        if (Play(0,0))
            return true;
        if (Play(0,V-1))
            return true;
        if (Play(V-1,0))
            return true;
        if (Play(V-1,V-1))
            return true;

        return false;
    }
}
