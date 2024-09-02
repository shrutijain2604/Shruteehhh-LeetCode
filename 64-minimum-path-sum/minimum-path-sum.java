class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        return dest(grid, new int[r][c], 0, r, c, 0);
    }

    public int dest(int[][] grid, int[][] dp, int i, int r, int c, int j) {
        if (i == r - 1 && j == c - 1) {
            return grid[i][j];
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (i == r - 1) {
            dp[i][j] = grid[i][j] + dest(grid, dp, i, r, c, j + 1);
        } else if (j == c - 1) {
            dp[i][j] = grid[i][j] + dest(grid, dp, i + 1, r, c, j);
        } else {
            dp[i][j] = grid[i][j] + Math.min(dest(grid, dp, i + 1, r, c, j), dest(grid, dp, i, r, c, j + 1));
        }
        return dp[i][j];
    }
}