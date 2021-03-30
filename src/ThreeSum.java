import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -3, -4};

        ThreeSum threeSum = new ThreeSum();

        System.out.println(threeSum.threeSum(nums));
        /*

        [-4, -3, -1, 0, (1), 2]
        nums[i]: -4
        low: -3
        high: 2
        sum:
         */
    }

    /** Solution 1: Two Pointer Method **/
    public List<List<Integer>> threeSum(int[] nums) {
        // Loop through the array, recreate two sum.
        // sort the array
        Arrays.sort(nums);

        // sort the array
        List<List<Integer>> output = new LinkedList<>();

        for ( int i = 0; i < nums.length-2; i++ ) {
            // nums[i] is iterating through
            // nums[i-1] is the one previous
            if ( i == 0 || ( i > 0  && nums[i] != nums[i-1])) { // if this isn't true, we found a duplicate
                // if i isn't 0
                // if i is greater than 0 AND
                    // if the current num is not equal to the one before
                int low = i+1; // lower boundary ( the next index)
                int high = nums.length-1; // last element of the array
                int sum = 0-nums[i]; // 0 minus the current number

                while ( low < high ) {
                    // if the next index value + the last element value is equal to the sum,
                    if (nums[low] + nums[high] == sum ) {
                        output.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // if there are duplicates
                        //      move to next index for low
                        //      move to previous index for high
                        while ( low < high && nums[low] == nums[low+1]) low++;
                        while ( low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;

                    } else if ( nums[low] + nums[high] > sum) { // we want to make the higher boundary to go down
                        // nums low + nums high will be smaller because it is sorted, so make high go down
                        high--;

                    } else {
                        // for bigger numbers
                        low++;
                    }
                }


            }
        }

        return output;
    }

}
