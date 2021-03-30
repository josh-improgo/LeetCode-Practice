/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class BestTimeToBuyAndSellStock {
    /** Solution 1: Two Pointer Approach (O(n^2)) [Time Limit Exceeded] **/
    public int maxProfit(int[] prices) {
        int profit = 0;

        int length = prices.length;
        for ( int pointerA = 0; pointerA < length; pointerA++ ) {
            for ( int pointerB = pointerA+1; pointerB < length; pointerB++ ) {
                int currentProfit = prices[pointerB] - prices[pointerA];
                if ( currentProfit > profit ) {
                    profit = currentProfit;
                }
            }
        }

        return profit;
    }

    /** Solution 2: Linear Approach **/
    public int maxProfit2(int[] prices) {
        int minVal = Integer.MAX_VALUE; // set to max value
        int maxProfit = 0; // keep track of max profit

        for ( int i = 0; i < prices.length; i++ ) { // iterate through array
            if ( prices[i] < minVal ) { // if the price is less than minVal
                minVal = prices[i]; // set minVal to be the current price
            } else if ( prices[i] - minVal > maxProfit ) { // otherwise, if the price - minVal is greater than the max profit
                maxProfit = prices[i] - minVal; // set the max profit to equal the price - minVal
            }
        }

        return maxProfit;

    }
}
