import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        int m = Integer.parseInt(br.readLine());
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;
        System.out.println(bfs(1));
    }

    public static int bfs(int n) {
        ArrayDeque<int[]> q = new ArrayDeque();
        q.add(new int[]{n, 0});
        int cnt = -1;

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int cur = poll[0];
            int depth = poll[1];
            if(depth == 3) {
                return cnt;
            }
            cnt++;

            List<Integer> friends = graph.get(cur);
            for(int f : friends) {
                if(visited[f]) continue;

                visited[f] = true;
                q.add(new int[]{f, depth + 1});
            }
        }

        return 0;
    }
}
