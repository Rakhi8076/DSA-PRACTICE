class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        int inf = amount + 1;
        for(int i=0; i<=amount; i++){
            dp[0][i] = inf;
        }
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount; j++){
                int coin = coins[i-1];
                if(coin <= j){
                    int in = 1 + dp[i][j-coin];
                    int ex = dp[i-1][j];
                    dp[i][j] = Math.min(in, ex);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount] == inf? -1 : dp[n][amount];
    }
}