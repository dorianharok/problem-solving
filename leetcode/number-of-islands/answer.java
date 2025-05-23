class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];

        int answer = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }

        return answer;
    }

    public void dfs(int x, int y, char[][] grid) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
            if(visited[nx][ny]) continue;
            if(grid[nx][ny] != '1') continue;
            visited[nx][ny] = true;

            dfs(nx, ny, grid);
        }
    }
}