import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> graph;
    static int vertex, edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            visited = new boolean[n + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int treeCount = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;

                vertex = 0;
                edge = 0;

                dfs(i);
                if (2 * (vertex - 1) == edge) treeCount++;
            }

            if (treeCount == 0) {
                System.out.printf("Case %d: No trees.\n", testCase);
            } else if (treeCount == 1) {
                System.out.printf("Case %d: There is one tree.\n", testCase);
            } else {
                System.out.printf("Case %d: A forest of %d trees.\n", testCase, treeCount);
            }

            testCase++;
        }
    }

    public static void dfs(int n) {
        visited[n] = true;
        vertex++;
        List<Integer> edges = graph.get(n);
        edge += edges.size();
        for (int e : edges) {
            if (visited[e]) continue;

            dfs(e);
        }
    }
}
