public class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int x = i, y = j;
                    while (x < m && land[x][j] == 1)
                        x++;
                    while (y < n && land[i][y] == 1)
                        y++;
                    for (int a = i; a < x; a++)
                        for (int b = j; b < y; b++)
                            land[a][b] = 0;
                    res.add(new int[] { i, j, x - 1, y - 1 });
                }
            }
        }
        return res.toArray(new int[0][]);
    }
}