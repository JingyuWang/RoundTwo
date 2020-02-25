package model.medium;
import model.common.Point;

import java.util.*;
/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.*/
public class exist {
    public static char[][] input = {
                                {'A','B','C','E'},
                                {'S','F','C','S'},
                                {'A','D','E','E'}
                            };
    public static String input2nd = "CSECB";
    public static boolean exist(char[][] board, String word) {
        boolean ans = false;
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
                if (DFSHelperNew(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    public static boolean DFSHelperNew(char[][] board, int x, int y, int index, String s){
        if (index==s.length()){
            return true;
        }
        if (x<0 || x>=board.length || y<0 || y>=board[x].length || board[x][y] != s.charAt(index))
            return false;
        char c = board[x][y];
        board[x][y] = '*';
        boolean ans = DFSHelperNew(board, x+1, y, index+1, s)
                || DFSHelperNew(board, x-1, y, index+1, s)
                || DFSHelperNew(board, x, y -1, index+1, s)
                || DFSHelperNew(board, x, y + 1, index+1, s);
        board[x][y] = c;
        return ans;
    }
    //invalid answer
    public static boolean DFSHelper(Point pre, HashMap<Character, List<Point>> dic, String word, int index){
        char tempChar = word.charAt(index);

        if (index == word.length()){
            System.out.println("end execution");
            return true;
        }

        if (!dic.containsKey(tempChar)){
            System.out.println("not exist");
            return false;
        }

        //dic has it
        List<Point> pointList = dic.get(tempChar);
        for(int i=0; i< pointList.size(); i++){
            Point temp = pointList.get(i);
            System.out.println("a is " + temp.a + ", b is " + temp.b + " index is " + index);
            if( pre ==null || (pre.a == temp.a && Math.abs(pre.b-temp.b)==1) || (pre.b == temp.b && Math.abs(pre.a-temp.a)==1)){
                if (pre==null){
                    pre = temp;
                    System.out.println("take temp");
                }
                else
                    System.out.println("a is " + temp.a + ", b is " + temp.b + " index is " + index + " *****");
                temp.setVoid();
                DFSHelper(temp, dic, word, index+1);
                temp.setBack();
            }
        }
        return false;
    }
}
