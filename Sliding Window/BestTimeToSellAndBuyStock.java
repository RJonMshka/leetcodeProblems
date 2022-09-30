public class BestTimeToSellAndBuyStock {
    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(
                new BestTimeToSellAndBuyStock().maxProfit(prices)
        );
    }

    public int maxProfit(int[] prices) {
        int maxp = 0;
        int left = 0;
        int right = 1;

        while(right < prices.length) {
            int profit = prices[right] - prices[left];
            maxp = Math.max(maxp, profit);
            if(profit <= 0) {
                left = right;
            }
            right++;
        }

        return maxp;
    }
}
