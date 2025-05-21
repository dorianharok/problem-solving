import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(start);
        map[start[0]][start[1]] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = map[x][y];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                map[nx][ny] = dis + 1;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    map[i][j] = -1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}
