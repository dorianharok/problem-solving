import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph = new ArrayList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        visited[V] = true;
        bfs(V);

        System.out.println(sb);
    }

    public static void bfs(int v) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(v);
        while(!q.isEmpty()) {
            Integer cur = q.poll();
            List<Integer> vv = graph.get(cur);
            sb.append(cur).append(" ");

            for(int i : vv) {
                if(visited[i]) continue;

                q.add(i);
                visited[i] = true;
            }
        }
    }

    public static void dfs(int v) {
        sb.append(v).append(" ");
        visited[v] = true;
        List<Integer> vv = graph.get(v);
        for(int i : vv) {
            if(!visited[i]) dfs(i);
        }
    }
}
