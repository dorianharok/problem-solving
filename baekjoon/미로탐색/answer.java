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
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs(0, 0);

        System.out.println(min);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == n-1 && cur[1] == m-1) {
                min = Math.min(min, cur[2]);
            }

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cur[2] + 1});
            }
        }
    }
}