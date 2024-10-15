import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static boolean[][] visited;
    static int[] dx = {1, 1, 2, 2, -2, -2, -1, -1};
    static int[] dy = {2, -2, 1, -1, 1, -1, 2, -2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            l= Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            String[] current = br.readLine().split(" ");
            String[] target = br.readLine().split(" ");

            int answer = bfs(
                    Integer.parseInt(current[0]),
                    Integer.parseInt(current[1]),
                    Integer.parseInt(target[0]),
                    Integer.parseInt(target[1])
            );

            System.out.println(answer);
        }

    }

    public static int bfs(int x, int y, int targetX, int targetY) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            if(poll[0] == targetX && poll[1] == targetY) {
                return poll[2];
            }

            for(int i=0; i<8; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= l || ny >= l || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, poll[2] + 1});
            }
        }

        return -1;
    }
}