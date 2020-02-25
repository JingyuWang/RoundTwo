package model.medium;

import java.util.HashMap;
import java.util.Map;

public class validTicTacToe {
    public static boolean validTicTacToe(String[] board){
        int Xcount = 0;
        int Ocount = 0;
        int[] row = new int[3];
        int[] col = new int[3];
        int forward = 0;
        int backward = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                char temp = board[i].charAt(j);
                int val=0;
                if (temp=='O'){
                    val = -1;
                    Ocount++;
                }
                if (temp=='X') {
                    Xcount++;
                    val = 1;
                }
                row[j]+=val;
                col[i]+=val;
                if (i==j) backward+=val;
                if (i+j==2) forward+=val;
            }
        }
        for(int k=0; k<3; k++){
            if (row[k]==3||col[k]==3||forward==3||backward==3){
                if(Xcount-Ocount==1)
                    return true;
                else
                    return false;
            }
            if (row[k]==-3||col[k]==-3||forward==-3||backward==-3){
                if(Xcount-Ocount==0)
                    return true;
                else
                    return false;
            }
        }
        //no winner
        if (Xcount-Ocount==1 || Xcount==Ocount)
            return true;
        else
            return false;

    }
}
