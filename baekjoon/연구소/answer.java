import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int wallCount) {
        if(wallCount == 3) {
            bfs();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0) {
                    continue;
                }

                map[i][j] = 1;
                dfs(wallCount + 1);
                map[i][j] = 0;
            }
        }
    }

    public static void bfs() {
        visited = new boolean[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            for(int i=0; i<4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];

                if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y]) {
                    continue;
                }
                if(map[x][y] != 0) {
                    continue;
                }

                q.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    answer++;
                }
            }
        }

        max = Math.max(answer, max);
    }
}