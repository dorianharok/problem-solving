import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N,M;
    static int cnt = 0;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new char[N][M];

        int x = 0, y = 0;
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        visited[x][y] = true;
        dfs(x, y);

        if(cnt == 0) {
            System.out.println("TT");
        } else{
            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 'X') continue;

            visited[nx][ny] = true;
            if(map[nx][ny] == 'P') cnt++;
            dfs(nx, ny);
        }
    }
}
