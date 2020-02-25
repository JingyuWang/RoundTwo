package model.hard;

import model.common.Point;

import java.util.ArrayList;
import java.util.List;

public class solveNQueens_2 {
    public int ans;
    public int totalNQueens(int n) {
        List<Point> pointsSet = new ArrayList<>();
        Fill(n, 0, pointsSet);
        return ans;
    }
    public void Fill(int n, int x, List<Point> pointsSet){
        if(x>=n){
            ans++;
            return;
        }

        for(int y=0; y< n; y++){
            if(isValid(x, y, pointsSet)){
                pointsSet.add(new Point(x, y));
                int nextX = x+1;
                Fill(n, nextX, pointsSet);
                pointsSet.remove(pointsSet.size()-1);
            }
        }
    }
    public boolean isValid(int x, int y, List<Point> pointsSet){
        for(var k: pointsSet){
            if (y == k.b || Math.abs(x-k.a)==Math.abs(y-k.b) || x == k.a)
                return false;
        }
        return true;
    }
}
