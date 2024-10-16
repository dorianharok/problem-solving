import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = arr[j] - '0';
            }
        }

        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    count++;
                    pq.add(bfs(i, j));
                }
            }
        }

        System.out.println(count);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static int bfs(int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        map[x][y] = 0;

        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(map[nx][ny] != 1) continue;

                q.offer(new int[]{nx, ny});
                map[nx][ny] = 0;
            }
        }

        return count;
    }
}