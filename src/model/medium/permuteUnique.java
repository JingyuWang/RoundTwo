package model.medium;
import java.util.*;
/*Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]*/
public class permuteUnique {
    public static int[] input = {1,1,2};
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        DFSHelper(new ArrayList<>(), new boolean[nums.length], res, nums);
        return res;
    }
    public static void DFSHelper(List<Integer> temp, boolean[] visited, List<List<Integer>> res, int[] nums){
        if (temp.size() ==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if (visited[i]) continue;
            // Same number can be only used once at each depth.
            if (i>0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            DFSHelper(temp, visited, res, nums);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}
