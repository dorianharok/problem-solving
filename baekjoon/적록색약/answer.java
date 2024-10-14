import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] visited;
    static char[][] picture;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            picture[i] = s.toCharArray();
        }

        int bfsSum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j]) continue;

                bfs(i, j, picture[i][j]);
                bfsSum++;
            }
        }

        visited = new boolean[N][N];
        int blindSum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j]) continue;

                blindBfs(i, j, picture[i][j]);
                blindSum++;
            }
        }

        System.out.println(bfsSum + " "+ blindSum);
    }

    public static void bfs(int x, int y, char target) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(picture[nx][ny] != target) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void blindBfs(int x, int y, char target) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(!isSame(picture[nx][ny], target)) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    private static boolean isSame(char ref, char target) {
        if(ref == 'R' || ref == 'G') {
            return target == 'R' || target == 'G';
        }

        return ref == target;
    }
}