package model.medium;
import java.util.*;
/*Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]*/
public class combinationSum3 {
    public static int a = 3;
    public static int b = 9;

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        DFSHelper(1, new ArrayList<>(), res, n, k);
        return res;
    }
    public static void DFSHelper(int pos, List<Integer> temp, List<List<Integer>> res, int target, int k){
        if (temp.size() ==k){
            if (target==0)
                res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = pos; i<10; i++){
            int cur = i;
            if(target<cur)
                break;
            //if (i > pos && candidates[i] == candidates[i-1]) continue;
            temp.add(cur);
            DFSHelper(i+1, temp, res,target-cur, k );
            temp.remove(temp.size()-1);
        }
    }
}
