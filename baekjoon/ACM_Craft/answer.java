import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0; i<=N; i++) {
                adj.add(new ArrayList<>());
            }

            int[] indegree = new int[N + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj.get(u).add(v);
                indegree[v]++;
            }

            int target = Integer.parseInt(br.readLine());

            int[] time = new int[N + 1];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    time[i] = D[i];
                }
            }

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v : adj.get(u)) {
                    indegree[v]--;
                    time[v] = Math.max(time[v], time[u] + D[v]);
                    if(indegree[v] == 0) {
                        queue.add(v);
                    }
                }
            }

            System.out.println(time[target]);
        }
    }
}
