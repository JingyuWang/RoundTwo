package model.hard;

import java.lang.reflect.Array;
import java.util.*;

public class solveSingleSudoku {
    public static int[][] b = {{5,3,0},{6,0,0},{0,9,8}};
    public static void solveSingleSudoku(int[][] board) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<10; i++){
            list.add(i);
        }
        for(int i=0; i<3; i++){
            for( int j=0; j<3; j++){
                int temp = board[i][j];
                list.remove(Integer.valueOf(temp));
            }
        }
        printBoard(board);
        System.out.println(list);
        System.out.println("*********");
        DFSHelper(board, new ArrayList<>(list), 0);
        printBoard(board);

    }
    public static void DFSHelper(int[][] board, List<Integer> list, int index){
        if (list.isEmpty()){
            printBoard(board);
            System.out.println("*********");
            return;
        }
        for(int i=0; i<3; i++){
            for( int j=0; j<3; j++){
                if (3*i + j >= index){
                    System.out.println("-------------------------");
                    System.out.println("i is " + i + " j is " + j);
                    System.out.println(list);
                    System.out.println("-------------------------");
                    if (board[i][j] == 0){

                        for(int k = 0; k < list.size(); k++){
                            int temp = list.get(k);
                            board[i][j] = temp;
                            list.remove(Integer.valueOf(temp));
                            DFSHelper(board, list, index +1);
                            board[i][j] = 0;
                            list.add(temp);
                        }
                    }
                }
            }
        }
    }
    public static void printBoard(int[][] board){
        for (var k: board){
            for (var c: k){
                System.out.print(c + ", ");
            }
            System.out.println();
        }
    }
}
