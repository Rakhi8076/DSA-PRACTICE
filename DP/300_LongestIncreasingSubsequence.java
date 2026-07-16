class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int nums1[] = new int[set.size()];
        int i = 0;
        for(int s: set){
            nums1[i] = s;
            i++;
        }
        Arrays.sort(nums1);
        return lowestCommonSub(nums, nums1);
    }
    private int lowestCommonSub(int nums1[], int nums2[]){
        int m = nums1.length;
        int n = nums2.length;
        int dp[][] = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[m][n];
    }
}