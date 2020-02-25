package model.hard;

import java.util.*;

/*Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

Example 1:
Input: [1,17,8]
Output: 2
Explanation:  [1,8,17] and [17,8,1] are the valid permutations.

Example 2:
Input: [2,2,2]
Output: 1

Note:
1 <= A.length <= 12
0 <= A[i] <= 1e9
相邻两个数字加起来可以square掉 [1,8,17] 则 相邻和为 [1+8, 8+17] => [9, 25] => squareful
*/
public class numSquarefulPerms {
    public static int[] input = {1,1,8,1,8};

    public static int count = 0;

    public static int numSquarefulPerms(int[] A) {
        boolean[] isVisited = new boolean[A.length];
        Arrays.sort(A);
        List<List<Integer>> res = new ArrayList<>();
        //count = 0;
        DFSHelp(new ArrayList<>(), isVisited, A,-1 );

        return count;

    }
    //Overide, only gets the count
    public static void DFSHelp(List<Integer> temp, boolean[] isVisited, int[] A, int lastadd){
        if (temp.size() == A.length){
            count++;
            for(var k: temp)
                System.out.print(k + "  ");
            System.out.println("here");
            return;
        }
        for(int i=0; i<A.length; i++){
            //duplicate visited
            if (isVisited[i]) continue;
            //duplicated elements
            if (i>0 && A[i]==A[i-1] && !isVisited[i-1]) continue;
            //not squareful , consider the 1st element add nothing, elements after 1st should add the previous added one(not A[i-1])
            //[1] =>  [1,8] => [1,8,17] cool
            if (lastadd!=-1 && !isSquareful(A[i],lastadd)) continue;
            isVisited[i] = true;
            temp.add(A[i]);
            DFSHelp(temp, isVisited, A, A[i]);
            temp.remove(temp.size()-1);
            isVisited[i] = false;
        }
    }
    //Overide, return the whole result list
    public static void DFSHelp(int count, List<Integer> temp, boolean[] isVisited, int[] A, List<List<Integer>> res, int lastadd){
        if (temp.size() ==A.length){
            count++;
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<A.length; i++){
            //duplicate visited
            if (isVisited[i]) continue;
            //duplicated elements
            if (i>0 && A[i]==A[i-1] && !isVisited[i-1]) continue;
            //not squareful , consider the 1st element add nothing, elements after 1st should add the previous added one(not A[i-1])
            //[1] =>  [1,8] => [1,8,17] cool
            if (lastadd!=-1 && !isSquareful(A[i],lastadd)) continue;
            isVisited[i] = true;
            temp.add(A[i]);
            DFSHelp(count, temp, isVisited, A, res, A[i]);
            temp.remove(temp.size()-1);
            isVisited[i] = false;
        }
    }
    public static boolean isSquareful(int a, int b){
        int res = (int)Math.sqrt(a+b);
        return (a+b)==res*res;
    }
}
