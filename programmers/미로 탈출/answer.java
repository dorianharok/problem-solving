import java.util.*;

class Solution {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] start;
    public static int[] lever;
    public static int[] exit;

    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                map[i][j] = c;
                if(c == 'S') {
                    start = new int[]{i, j};
                } else if(c == 'E') {
                    exit = new int[]{i, j};
                } else if(c == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }

        visited = new boolean[maps.length][maps[0].length()];
        int s = bfs(start, lever);
        visited = new boolean[maps.length][maps[0].length()];
        int e = bfs(lever, exit);

        if(s == -1 || e == -1) {
            return -1;
        }

        return s + e;
    }

    public int bfs(int[] start, int[] target) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i=0; i<4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(!valid(nx, ny)) {
                    continue;
                }

                if(nx == target[0] && ny == target[1]) {
                    return current[2] + 1;
                }

                q.offer(new int[]{nx, ny, current[2] + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }

    public boolean valid(int x, int y) {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
            return false;
        }

        if(map[x][y] == 'X') {
            return false;
        }

        if(visited[x][y]) {
            return false;
        }

        return true;
    }
}