package model.medium;

public class TicTacToe {
    /** Initialize your data structure here. */
    int[] rowSet;
    int[] colSet;
    int forward;
    int backward;
    int cap;
    public TicTacToe(int n) {
        rowSet = new int[n];
        colSet = new int[n];
        cap = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins.
     Time Complexity O(1) */
    public int move(int row, int col, int player) {
        int accu = 0;
        if (player == 1){
            accu = 1;
        }
        if (player == 2){
            accu = -1;
        }
        rowSet[row]+=accu;
        colSet[col]+=accu;
        if(row+col+1==cap)
            forward+=accu;
        if(row==col)
            backward+=accu;
        if(Math.abs(rowSet[row])==cap || Math.abs(colSet[col])==cap || Math.abs(forward)==cap || Math.abs(backward)==cap)
            return player;
        else
            return 0;
    }
}
