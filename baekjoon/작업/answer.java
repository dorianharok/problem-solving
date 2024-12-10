import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        int[] time = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            int r = Integer.parseInt(st.nextToken());
            while (r-- > 0) {
                int u = Integer.parseInt(st.nextToken());
                adj.get(u).add(i);
                indegree[i]++;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                result[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                indegree[v]--;
                result[v] = Math.max(result[v], result[u] + time[v]);
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, result[i]);
        }
        System.out.println(maxTime);
    }
}
