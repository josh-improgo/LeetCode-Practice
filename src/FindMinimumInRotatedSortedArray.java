import java.util.Arrays;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

    /** Solution 1: Just sort and get the first number (Not really a correct solution) **/
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    /** Solution 2: Brute Force O(n) **/
    public int findMin2(int[] nums) {
        int min = nums[0];

        for ( int i = 1; i < nums.length; i++ ) {
            if ( nums[i] < min )
                min = nums[i];
        }

        return min;
    }

    /** Solution 3: Modified Binary Search Do it in terms of Mid**/
    public int findMin3(int[] nums) {
        int length = nums.length;
        if ( length == 0 ) return -1;
        if ( length == 1 ) return nums[0];

        int left = 0;
        int right = length-1;

        while ( left < right ) {

            // get index of middle
            int mid = left + (right-left) / 2; // proper way to do it to avoid Integer overflow

            if ( mid > 0 && nums[mid] < nums[mid-1] ) return nums[mid]; // the find condition; if mid index is > 0 and value at mid < value at mid-1 (means we found lowest num)
                // check if left index is less than mid index
            else if ( nums[left] <= nums[mid] && nums[mid] > nums[right] ) { // value at left <= value at mid (means it's sorted) and value at mid > value at right (rotated and sorted still)
                left = mid+1; // change left to be mid + 1
            } else {//( nums[mid] < nums[right] ) { // otherwise value at mid is less than value at right (we are still sorted
                right = mid-1; // change right to mid-1
            }
        }
        return nums[left];
    }
    /*
    The patterns looks like this for an ascending order set:
    First, find the middle of start and end. An easy way to find the middle would be: middle = (start + end) / 2. But this has a good chance of producing an integer overflow so it’s recommended that you represent the middle as: middle = start + (end — start) / 2
    If the key is equal to the number at index middle then return middle
    If ‘key’ isn’t equal to the index middle:
    Check if key < arr[middle]. If it is reduce your search to end = middle — 1
    Check if key > arr[middle]. If it is reduce your search to end = middle + 1
     */
}
