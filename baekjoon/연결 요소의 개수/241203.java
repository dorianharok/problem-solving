import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int cnt = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int n) {
        visited[n] = true;
        List<Integer> edges = graph.get(n);

        for(Integer e: edges) {
            if(!visited[e]) {
                dfs(e);
            }
        }
    }
}
