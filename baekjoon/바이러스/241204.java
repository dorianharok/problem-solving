import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int count = -1;
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

        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int n) {
        count++;
        visited[n] = true;
        List<Integer> vv = graph.get(n);
        for(int v : vv) {
            if(visited[v]) continue;

            dfs(v);
        }
    }
}
