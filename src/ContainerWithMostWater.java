/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    /** Solution 1: Brute Force O(n^2) **/
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int length = height.length;

        for ( int i = 0; i < length; i++ ) {
            for ( int j = i+1; j < length; j++ ) {
                int minHeight = Math.min(height[i], height[j]);
                int area = minHeight * (j - i);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    /** Solution 2: In one pass O(n) Two Pointer Method **/
    public int maxArea2(int[] height) {
        int length = height.length;
        int pointerA = 0;
        int pointerB = length-1;

        int maxHeight = Integer.MIN_VALUE;

        while ( pointerA < pointerB ) {
            int aHeight = height[pointerA];
            int bHeight = height[pointerB];

            int currentHeight = Math.min( aHeight, bHeight ) * ( pointerB - pointerA );
            maxHeight = Math.max(maxHeight, currentHeight);

            if ( aHeight < bHeight )
                pointerA++;
            else
                pointerB--;


        }

        return maxHeight;
    }
}
