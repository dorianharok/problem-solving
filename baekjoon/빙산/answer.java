import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int time = 0;
        int island = 0;
        while (!q.isEmpty()) {
            time++;
            melting();
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        island++;
                        dfs(i, j);
                    }
                }
            }

            if (island > 1) {
                System.out.println(time);
                return;
            }

            island = 0;
        }

        System.out.println(0);
    }

    public static void melting() {
        visited = new boolean[N][M];
        ArrayDeque<int[]> temp = new ArrayDeque<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] != 0) continue;
                if (visited[nx][ny]) continue;

                map[x][y] -= 1;
                if (map[x][y] == 0) break;
            }

            if (map[x][y] != 0) temp.add(new int[]{x, y});
        }

        q = temp;
    }

    public static void dfs(int x, int y) {
        if(visited[x][y]) return;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (map[nx][ny] == 0) continue;
            if (visited[nx][ny]) continue;

            dfs(nx, ny);
        }
    }
}