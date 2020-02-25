package model.hard;

import java.util.*;

public class solveSudoku {
    public static void solveSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] boxes = new int[9][10];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]== '.') continue;
                int n = board[i][j] - '0';
                rows[i][n] = 1;
                cols[j][n] = 1;
                int bi = i/3;
                int bj = j/3;
                boxes[bi*3+bj][n] = 1;
            }
        }
        fillDFS(board, 0, 0, rows, cols, boxes);
    }

    public static boolean fillDFS(char[][] board, int x, int y, int[][] rows, int[][] cols, int[][]boxes){
        if(x==9){//the next row of last row
            return true;
        }
        //left->right, up->down
        int nextX = y==8? x+1: x; //if y is the last column, x will be x+1(next row)
        int nextY = (y + 1) % 9;

        if (board[x][y]!='.') return fillDFS(board, nextX, nextY, rows, cols, boxes);

        for(int i = 1; i<=9; i++){
            int bi = x/3;
            int bj = y/3;
            //boxes[bi*3+bj][i];
            if(rows[x][i]==0 && cols[y][i]==0 && boxes[bi*3 + bj][i]==0){
                rows[x][i] = 1;
                cols[y][i] = 1;
                boxes[bi*3 + bj][i] = 1;
                board[x][y] = (char)(i + '0');
                if (fillDFS(board, nextX, nextY, rows, cols, boxes)){
                    return true;
                }
                else{
                    rows[x][i] = 0;
                    cols[y][i] = 0;
                    boxes[bi*3 + bj][i] = 0;
                    board[x][y] = '.';
                }
            }
        }
        return false;
    }
    public static boolean isValid(char[][] board, int i, int j, char c){
        //Check colum
        for(int row = 0; row < 9; row++)
            if(board[row][j] == c)
                return false;

        //Check row
        for(int col = 0; col < 9; col++)
            if(board[i][col] == c)
                return false;

        //Check 3 x 3 block
        for(int row = 3*(i/3); row<3*(i/3)+3; row++)
            for(int col = 3*(j/3); col<3*(j/3)+3; col++)
                if(board[row][col] == c)
                    return false;
        return true;
    }
}
