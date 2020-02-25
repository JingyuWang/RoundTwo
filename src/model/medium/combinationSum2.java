package model.medium;

import java.util.*;
/*Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]*/
public class combinationSum2 {
    public static int[] input = {2,5,2,1,2};
    public static int sum = 5;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        DFSHelper(0, new ArrayList<>(), res, candidates, target);
        return res;
    }
    public static void DFSHelper(int pos, List<Integer> temp, List<List<Integer>> res, int[] candidates, int target){
        if (target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = pos; i<candidates.length; i++){
            int cur = candidates[i];
            if(target<cur)
                break;
            if (i > pos && candidates[i] == candidates[i-1]) continue;
            temp.add(cur);
            DFSHelper(i+1, temp, res, candidates, target-cur);
            temp.remove(temp.size()-1);
        }
    }
}
