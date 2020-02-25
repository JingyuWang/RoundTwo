package model.medium;

import java.lang.reflect.Array;
import java.util.*;

/*Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
public class subsetsWithDup {
    public static int[] input = {1,2,2,3};
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        DFS(0, new ArrayList<>(), nums, res);
        return res;
    }
    public static void DFS(int pos, List<Integer> temp, int[] nums, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i=pos; i<nums.length; i++){
            if (i>pos && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            DFS(i+1, temp, nums, res);
            temp.remove(temp.size()-1);
        }
    }
}
