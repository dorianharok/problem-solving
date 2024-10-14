import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = -1;
    static int[][] box;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        bfs();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(max);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            max = Math.max(max, cur[2]);

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(box[nx][ny] != 0) continue;

                box[nx][ny] = 1;
                q.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
    }
}