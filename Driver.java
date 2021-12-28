public class Driver {
    public static void main(String[] args) {
        System.out.println("iterative method");
        int boardSize = 4;
        IterativeTest IT = new IterativeTest(boardSize);
        int[][] board = IT.getBoard();
        for (int i= 0; i<boardSize;i++) {
            for (int j= 0; j<boardSize;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(IT.PlayMagicBoard());
        System.out.println();
        System.out.println("recursive method");
        RecursiveTest RT = new RecursiveTest(boardSize);
        RT.printBoard();
        System.out.println(RT.PlayMagicBoard());
    }
}
