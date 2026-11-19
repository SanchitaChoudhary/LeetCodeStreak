class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int component = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'&& vis[i][j]== false) {
                    bfs(i, j, grid, vis);
                    component++;
                }
            }
        }
        return component;
    }

    public void bfs(int row, int col, char[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        //adding starting cell
        q.offer(new int[] { row, col });
        vis[row][col] = true;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == '1' &&
                        vis[nr][nc] == false) {
                    q.offer(new int[] { nr, nc });
                    vis[nr][nc] = true;
                }
            }
        }
    }
}