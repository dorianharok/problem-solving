import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if(map[i][j] == 'I') {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int answer = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(map[cur[0]][cur[1]] == 'P') {
                answer++;
            }

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        if(answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }
}
