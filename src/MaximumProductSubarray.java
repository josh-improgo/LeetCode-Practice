/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // Given an integer array nums,
        // find the contiguous subarray within an array, containing at least one number, which ahs the largest product

        int length = nums.length;
        if ( length == 1 ) return nums[0];

        int result = nums[0];

        int min = 1;
        int max = 1;

        for ( int i = 0; i < length; i++ ) {
            // if ( nums[i] == 0 ) {
            //     min = 1;
            //     max = 1;
            //     continue;
            // }


            int tempMax = max;
            int newMax = Math.max( nums[i] * max, nums[i] * min );
            max = Math.max(newMax, nums[i]);

            int newMin = Math.min( nums[i] * tempMax, nums[i] * min );
            min = Math.min(newMin, nums[i]);

            result = Math.max(result, max);

        }

        return result;
    }
}
