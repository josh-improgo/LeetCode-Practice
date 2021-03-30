/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubArray {

    /** Solution 1: O(n) solution (Kadane's Algorithm **/
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if ( length == 1 ) return nums[0];



        int maxSum = nums[0];

        int currentSum = maxSum;
        for ( int i = 1; i < length; i++ ) {
            // find max between the current index plus the sum and the current index
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    /** Solution 2: O(n^2) Sliding Window **/
    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        if ( length == 1 ) return nums[0];

        int sum = Integer.MIN_VALUE;

        for ( int i = 0; i < length; i++ ) {
            int currentSum = 0;

            for ( int j = i; j < length; j++ ) {
                currentSum += nums[j];
                if ( currentSum > sum ) {
                    sum = currentSum;
                }
            }
        }
        return sum;
    }
}
