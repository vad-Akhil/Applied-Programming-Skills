class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(nums,0, dp);
    }
    public int helper(int nums[],int n , int dp[]){
        if(n>= nums.length ){
            return 0;
        }
        if(dp[n] != -1) return dp[n];
        int take = helper(nums,n+2,dp) + nums[n];
        int left= helper(nums,n +1, dp);
        return dp[n] = Math.max(take,left);
    }
}