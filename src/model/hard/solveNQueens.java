package model.hard;
import model.common.Point;

import java.util.*;

public class solveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Point> pointsSet = new ArrayList<>();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++){
            sb.append(".");
        }

        Fill(n, 0, res, pointsSet, sb);
        return res;
    }
    public static void Fill(int n, int x, List<List<String>> res, List<Point> pointsSet, StringBuilder sb){
        if(x>=n){
            //res.add(board);
            List<String> tempAns = new ArrayList<>();
            for (Point p : pointsSet){
                System.out.print(p.a + "," + p.b + " ");
                sb.setCharAt(p.b, 'Q');
                tempAns.add(sb.toString());
                sb.setCharAt(p.b, '.');
            }
            res.add(tempAns);
            return;
        }

        for(int y=0; y< n; y++){
            if(isValid(x, y, pointsSet)){
                pointsSet.add(new Point(x, y));
                int nextX = x+1;
                Fill(n, nextX, res, pointsSet, sb);
                pointsSet.remove(pointsSet.size()-1);
            }
        }
    }
    public static boolean isValid(int x, int y, List<Point> pointsSet){
        for(var k: pointsSet){
            if (x == k.a || y == k.b || Math.abs(x-k.a)==Math.abs(y-k.b))
                return false;
        }
        return true;
    }
}
