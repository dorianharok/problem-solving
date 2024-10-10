import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int n,m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        map = new int[n][m];

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int paintCount = 0;
        int maxArea = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] != 1) {
                    continue;
                }

                int area = bfs(i, j);
                paintCount++;
                maxArea = Math.max(maxArea, area);
            }
        }

        System.out.println(paintCount);
        System.out.println(maxArea);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        map[x][y] = 0;
        int sum = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            sum++;
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0) continue;

                q.offer(new int[]{nx, ny});
                map[nx][ny] = 0;
            }
        }

        return sum;
    }
}