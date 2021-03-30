import java.util.HashMap;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    /** Solution 1: HashMap Solution **/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Key: nums[i], value: index

        for ( int i = 0; i < nums.length; i++ ) {
            int complement = target - nums[i];
            if ( map.containsKey(complement) ) {
                return new int[]{i, map.get(complement)};
            } else {
                map.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No match found");
    }

    /** Solution 2: Brute Force Solution **/
    public static int[] twoSum2(int[] nums, int target) {
        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            for (int j = 1; j < nums.length && j != i; j++) {
                if (difference == nums[j]) {
                    solution[0] = i;
                    solution[1] = j;
                }
            }
        }
        return solution;
    }
}
