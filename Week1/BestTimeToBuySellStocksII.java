class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        
        int profit = 0, i = 0, min = 0;
        
        while (i < prices.length) {
            //find first min
            while (i < prices.length - 1 && prices[i+1] <= prices[i])
                i++;
            
            min = prices[i];
            
            //find immediate next max
            while (i < prices.length - 1 && prices[i+1] >= prices[i])
                i++;
            
            //calculate profit
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        
        return profit;
    }
}