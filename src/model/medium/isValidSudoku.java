package model.medium;
import java.util.*;

public class isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i< 3; i++){
            for(int j=0; j<3; j++){
                if (!boxIsValid(board, i*3, i*3+3, j*3, j*3+3))
                    return false;
            }
        }
        for(int index = 0; index<9; index++){
            if (!rowIsValid(board, index) || !columnIsValid(board, index))
                return false;
        }
        return true;
    }
    public static boolean boxIsValid(char[][] board, int istart, int iend, int jstart, int jend){
        int[] set = new int[10];
        for(int i=istart; i< iend; i++){
            for(int j = jstart; j< jend; j++){
                char temp = board[i][j];
                if (temp=='.'){
                    continue;
                }else if(temp>='1' && temp<='9'){
                    if(set[temp-'1']>0)
                        return false;
                    else
                        set[temp-'1']=1;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean rowIsValid(char[][] board, int row){
        int[] set = new int[10];
        for(int k=0; k<9; k++){
            char temp = board[row][k];
            if (temp=='.'){
                continue;
            }else if(temp>='1' && temp<='9'){
                if(set[temp-'1']>0)
                    return false;
                else
                    set[temp-'1']=1;
            }else{
                return false;
            }
        }
        return true;
    }
    public static boolean columnIsValid(char[][] board, int col){
        int[] set = new int[10];
        for(int k=0; k<9; k++){
            char temp = board[k][col];
            if (temp=='.'){
                continue;
            }else if(temp>='1' && temp<='9'){
                if(set[temp-'1']>0)
                    return false;
                else
                    set[temp-'1']=1;
            }else{
                return false;
            }
        }
        return true;
    }
}
