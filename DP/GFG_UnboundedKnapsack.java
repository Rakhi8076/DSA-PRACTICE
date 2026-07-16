class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int dp[][] = new int[n+1][capacity+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=capacity; j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){
                    int in = v + dp[i][j-w];
                    int ex = dp[i-1][j];
                    dp[i][j] = Math.max(in, ex);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}