// T = O(n)
// S = O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int min = prices[0], res = 0;
        for(int price : prices) {
            min = Math.min(min, price);
            res = Math.max(res, price-min);
        }
        return res;
    }
}