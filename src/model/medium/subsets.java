package model.medium;

import java.util.*;

/*Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/
public class subsets {
    public static int[] input = {1,2,3};
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(0, new ArrayList<>(), nums, res);
        return res;
    }
    public static void DFS(int pos, List<Integer> temp, int[] nums, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i=pos; i<nums.length; i++){
            temp.add(nums[i]);
            DFS(i+1, temp, nums, res);
            temp.remove(temp.size()-1);
        }
    }
}
