/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {
    /** Solution 1: Brute force approach (Double pointers) [Time Limit Exceeded] **/
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        for ( int i = 0; i < length; i++ ) {
            output[i] = 1;
        }

        for ( int pointerA = 0; pointerA < length; pointerA++ ) {
            for ( int pointerB = 0; pointerB < length; pointerB++ ) {
                if ( pointerA != pointerB) {
                    output[pointerA] *= nums[pointerB];
                }
            }
        }

        return output;
    }

    /** Solution 2: With space **/
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;

        int[] output = new int[length];

        int[] leftProducts = new int[length];
        int[] rightProducts = new int[length];

        leftProducts[0] = 1;
        rightProducts[length-1] = 1;

        for ( int i = 1; i < length; i++ ) {
            leftProducts[i] = nums[i-1] * leftProducts[i-1];
        }

        for ( int i = length-2; i >= 0; i-- ) {
            rightProducts[i] = nums[i+1] * rightProducts[i+1];
        }

        for ( int i = 0; i < length; i++ ) {
            output[i] = leftProducts[i] * rightProducts[i];
        }

        return output;
    }

    /** Solution 3: With Constant Space **/
    /** Solution 1: With Constant space **/
    public int[] productExceptSelf3(int[] nums) {
        int length = nums.length;

        int[] output = new int[length];


        output[0] = 1;
        output[length-1] = 1;

        for ( int i = 1; i < length; i++ ) {
            output[i] = nums[i-1] * output[i-1];
        }

        int right = 1;

        for ( int i = length-1; i >= 0; i-- ) {
            output[i] = output[i] * right;
            right = right * nums[i];
        }

        return output;
    }
}
