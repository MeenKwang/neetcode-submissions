class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = prices.length - 1;
        int max = 0;
        while (i < j) {
            for (int k = i + 1; k <= j; k++) {
                max = (prices[k] - prices[i]) > max ? prices[k] - prices[i] : max;
            }
            i++;
        }
        return max;
    }
}
