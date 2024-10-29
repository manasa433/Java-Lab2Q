2Q. The task is to determine the maximum profit a share trader can achieve from stock prices given for a single day, allowing for at most two transactions (one buy followed by one sell, and then another buy followed by another sell).
Transaction Limits: The trader is restricted to a maximum of two transactions:
First transaction: Buy and then sell.
Second transaction: Buy again (only after the first sell) and then sell.
Input: An array of integers representing the stock prices at various times during the day.
Output: The maximum profit that can be achieved through these transactions.

public class ShareTraderProfit {
    // Static variable to hold the maximum profit
    private static int maxProfit;

    // Static method to find the maximum profit with at most 2 transactions
    public static int findMaxProfit(int[] prices) {
        maxProfit = 0;

        if (prices == null || prices.length == 0) {
            return maxProfit;
        }

        // Variables to track profits for up to two transactions
        int firstBuy = Integer.MIN_VALUE; // Profit from first buy
        int firstSell = 0;                 // Profit from first sell
        int secondBuy = Integer.MIN_VALUE; // Profit from second buy
        int secondSell = 0;                // Profit from second sell

        for (int price : prices) {
            // Update first buy
            firstBuy = Math.max(firstBuy, -price);
            // Update first sell
            firstSell = Math.max(firstSell, firstBuy + price);
            // Update second buy
            secondBuy = Math.max(secondBuy, firstSell - price);
            // Update second sell
            secondSell = Math.max(secondSell, secondBuy + price);
        }

        // The maximum profit is the result of the second sell
        maxProfit = secondSell;
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {10, 15, 25, 38, 66, 5};
        System.out.println("Maximum Profit for prices1: " + findMaxProfit(prices1)); // Test case 1

        int[] prices2 = {20, 12, 33, 4, 35};
        System.out.println("Maximum Profit for prices2: " + findMaxProfit(prices2)); // Test case 2

        int[] prices3 = {70, 6, 24, 50, 30};
        System.out.println("Maximum Profit for prices3: " + findMaxProfit(prices3)); // Test case 3
    }
}
