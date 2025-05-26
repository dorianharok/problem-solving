import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public int solution(int[][] maps) {
        bfs(maps);

        if(maps[maps.length - 1][maps[0].length - 1] == 1) {
            return -1;
        }

        return maps[maps.length - 1][maps[0].length - 1];
    }

    public void bfs(int[][] maps) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(!isValid(nx, ny, maps)) continue;
                if(maps[nx][ny] != 1) continue;

                q.offer(new int[]{nx, ny});
                maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
            }
        }
    }

    public boolean isValid(int x, int y, int[][] maps) {
        if(x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) {
            return false;
        }

        return true;
    }
}