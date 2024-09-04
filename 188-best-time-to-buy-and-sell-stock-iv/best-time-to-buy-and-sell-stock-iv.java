class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][(k * 2) + 2];
        for(int i = n-1; i>=0; i--){
            for(int j = k*2; j >=0 ; j--){
                int amt = 0;
                if(j % 2 == 0){
                    amt = Math.max(dp[i+1][j] , -prices[i] + dp[i+1][j+1]);
                }else{
                    amt = Math.max(dp[i+1][j] , prices[i] + dp[i+1][j+1]);
                }
                dp[i][j] = amt;
                
            }
            
        }
        return dp[0][0];
    }
}