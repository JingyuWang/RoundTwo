package model.medium;

import java.util.*;

/*Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]*/
public class combinationSum {
    public static int[] input = {2,3,5};
    public static int sum = 8;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, new LinkedList<>(), candidates, 0, target);
        //toFindCombinationSum(candidates, target, 0, new ArrayList(), res);
        return res;
    }
    public static void helper (List<List<Integer>> res, List<Integer> temp, int[] candidates, int pos, int target){
        if (target == 0){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i=pos; i<candidates.length; i++){
            //System.out.println("------------" + candidates[i]);
            int cur = candidates[i];
            if(cur>target)
                break;
            //System.out.println("------------" + tempSum);
            temp.add(cur);
            helper(res, temp, candidates, i, target - cur);
            temp.remove(temp.size()-1);
        }
    }
    private static void toFindCombinationSum(int[] nums, int remTarget, int startIndex, List<Integer> current, List<List<Integer>> results) {
        if(remTarget == 0) {
            results.add(new ArrayList(current));
            return;
        }

        for(int i = startIndex; i < nums.length; i++) {
            if(nums[i] > remTarget)
                break;
            current.add(nums[i]);
            toFindCombinationSum(nums, remTarget - nums[i], i, current, results);
            current.remove(current.size() - 1);
        }
    }
}