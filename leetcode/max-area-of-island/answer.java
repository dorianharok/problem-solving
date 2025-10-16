class Solution {
    public int[] dx = new int[]{-1, 0, 1, 0};
    public int[] dy = new int[]{0, -1, 0, 1};
    public boolean[][] visited;
    public int n,m;
    public int[][] map;

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        visited = new boolean[n][m];
        map = grid;

        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1) {
                    visited[i][j] = true;
                    max = Math.max(max, dfs(i, j));
                }
            }
        }

        return max;
    }

    public int dfs(int x, int y) {
        int count = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;

            visited[nx][ny] = true;
            count += dfs(nx, ny);
        }

        return count;
    }
}