package DP.Easy;
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable303 {
    public class NumArray {
        public int[] dp;
        public int[] A;
        public NumArray(int[] nums) {
            if (nums.length<=0)
                return;
            int n = nums.length;
            A = nums;
            dp = new int[n];
            dp[0] = nums[0];
            for(int i=1; i<n; i++){
                dp[i] = nums[i] + dp[i-1];
            }
        }
        public int sumRange(int i, int j) {
            return dp[j] - dp[i] + A[i];
        }
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */