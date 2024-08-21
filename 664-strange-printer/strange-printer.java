class Solution {
     public static int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(0, n - 1, s, dp);
    }

    public static int solve(int i, int j, String s, int[][] dp) {
        if (i == j) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            mini = Math.min(mini, solve(i, k, s, dp) + solve(k + 1, j, s, dp));
        }
        dp[i][j] = (s.charAt(i) == s.charAt(j)) ? mini - 1 : mini;
        return dp[i][j];
    } 
}