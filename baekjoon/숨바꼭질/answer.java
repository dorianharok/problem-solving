import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N,K;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        System.out.println(bfs(N));
    }

    public static int bfs(int x) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[x] = true;
        q.add(new int[]{x, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == K) {
                return cur[1];
            }

            int[] dx = {cur[0]-1, cur[0]+1, cur[0] * 2};

            for(int i=0; i<3; i++) {
                if(dx[i] < 0 || dx[i] >= 100001 || visited[dx[i]]) {
                    continue;
                }

                visited[dx[i]] = true;
                q.add(new int[]{dx[i], cur[1] + 1});
            }
        }

        return -1;
    }
}