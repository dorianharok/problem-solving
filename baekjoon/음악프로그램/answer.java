import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int prev = 0;
            while (cnt-- > 0) {
                int u = Integer.parseInt(st.nextToken());
                graph.get(prev).add(u);
                if (prev != 0) {
                    indegree[u]++;
                }
                prev = u;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int process = 0;

        while (!q.isEmpty()) {
            int n = q.poll();
            sb.append(n).append("\n");
            process++;

            List<Integer> next = graph.get(n);
            for (int u : next) {
                indegree[u]--;
                if (indegree[u] == 0) {
                    q.add(u);
                }
            }
        }

        if(process != N) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }
}
