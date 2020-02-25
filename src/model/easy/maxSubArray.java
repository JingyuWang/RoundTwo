/*
Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
*/
package model.easy;

public class maxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0)
            return  Integer.MIN_VALUE;
        int local = nums[0];
        int global = nums[0];
        for(int i=0; i<nums.length; i++){
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(global,local);
            System.out.println("local is " + local + "  global is " + global);
        }
        return global;
    }
}
