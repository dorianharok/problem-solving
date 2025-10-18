import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 2; i <= n; i++) {
            if (!visited[i]) {
                flag = true;
                sb.append(i).append("\n");
            }
        }

        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int n) {
        if (visited[n]) return;
        visited[n] = true;

        for (int next : adj[n]) {
            dfs(next);
        }
    }
}