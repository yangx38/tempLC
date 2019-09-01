class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            if(i > 0 && prices[i] > prices[i-1]) res += prices[i]-prices[i-1];
        }
        return res;
    }
}