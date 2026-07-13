// Time Complexity O(n)
// Space Complexity O(1)
class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       int buyPrice = Integer.MAX_VALUE;
       int maxProfit = 0;
       for(int price : prices){
        if(price > buyPrice){
            int profit = buyPrice-price;
            maxProfit = Math.max(maxProfit, profit);
        }else{
            buyPrice = price;
        }
       }
       return maxProfit;
    }
};