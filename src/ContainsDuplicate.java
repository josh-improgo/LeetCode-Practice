import java.util.Arrays;
import java.util.HashSet;

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
    /** Solution 1: HashSet Solution **/
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for ( int i : nums ) {
            if ( set.contains(i) ) return true;
            else set.add(i);
        }

        return false;
    }

    /** Solution 2: Simple Array Solution **/
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for ( int i = 0; i < nums.length-1; i++ ) {
            if ( nums[i] == nums[i+1] ) return true;
        }

        return false;
    }
}
