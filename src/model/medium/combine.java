package model.medium;

import java.util.*;

/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/
public class combine {
    public static int num = 5;
    public static int count = 3;
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();

        helper(new ArrayList<>(), 1, n, k, res);
        return res;
    }
    public static void helper(List<Integer> temp, int pos, int n, int k, List<List<Integer>> res){
        if(temp.size()==k){
            res.add(new LinkedList<>(temp));
            return;
        }
        for(int i=pos; i<=n; i++){
            if(temp.size() + (n - i + 1) < k)
                break;
            temp.add(i);
            helper(temp, i+1, n, k, res);
            temp.remove(temp.size()-1);
        }
    }
}
