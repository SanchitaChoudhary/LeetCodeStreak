class Solution {
    public int numSquares(int n) {
        int maxsq = (int) Math.sqrt(n);
        Integer[][] dp = new Integer[maxsq +1][n + 1];
        return helper(maxsq , n, dp);
    }

    public int helper(int index, int target, Integer[][] dp) {
        if (target == 0) {
            return 0;
        }
        if (index == 0) {
            return Integer.MAX_VALUE/2;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }
        int notTake = helper(index - 1, target, dp);
        int take = Integer.MAX_VALUE/2;
        if(target >= index *index)
        take =  1+ helper(index, target - (index * index), dp);
        dp[index][target] = Math.min(notTake, take);
        return dp[index][target];
    }
}
