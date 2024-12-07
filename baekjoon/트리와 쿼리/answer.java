import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        parents = new int[N + 1];
        Arrays.fill(parents, 1);
        visited = new boolean[N + 1];

        N--;
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(R);

        while(Q-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(parents[n]);
        }
    }

    public static void dfs(int n) {
        visited[n] = true;
        List<Integer> ver = graph.get(n);

        for(int v : ver) {
            if(visited[v]) continue;

            dfs(v);
            parents[n] += parents[v];
        }
    }
}
