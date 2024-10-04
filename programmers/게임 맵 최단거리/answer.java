import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        return bfs(maps, 0, 0);
    }

    public int bfs(int[][] maps, int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 0});
        int[] destination = new int[]{maps.length-1, maps[0].length-1};
        maps[x][y] = 0;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            if(current[0] == destination[0] && current[1] == destination[1]) {
                return current[2] + 1;
            }

            for(int i=0; i<4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length || maps[nx][ny] != 1) {
                    continue;
                }

                maps[nx][ny] = 0;
                q.offer(new int[]{nx, ny, current[2] + 1});
            }
        }

        return -1;
    }
}