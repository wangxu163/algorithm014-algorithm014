/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumberIsland {

    public int numIslands(char[][] grid) {
        if (null == grid || grid.length < 0) {
            return 0;
        }
        int nr = grid.length;//行
        int nc = grid[0].length;//列
        int num_island = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    ++num_island;
                    dfs(grid, r, c);
                }
            }
        }
        return num_island;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    //TODO bfs

}
