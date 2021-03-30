/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    /** Two ways to solve DP questions.
     Solve Top-Down approach or
     Solve bottom-up approach (More intuitive)
     1. Think of base case
     How do you climb 0 stairs? Only one way, you don't climb it.
     1? Just 1 step
     2? 2 ways, 1 + 1, 2 steps
     Make an array to store the number of ways to climb
     **/
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for ( int i = 2; i <= n; i++ ) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }
}
