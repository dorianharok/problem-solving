import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] score;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= n; i++) {
            int p = Integer.parseInt(st.nextToken());

            graph.get(p).add(i);
        }

        score = new int[n + 1];
        visited = new boolean[n + 1];
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            score[num] += s;
        }

        for(int i=1; i<=n; i++) {
            if(visited[i]) continue;

            dfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            sb.append(score[i] + " ");
        }

        System.out.println(sb);
    }

    public static void dfs(int n) {
        visited[n] = true;
        List<Integer> ver = graph.get(n);

        for(int v : ver) {
            if(visited[v]) continue;

            score[v] += score[n];
            dfs(v);
        }
    }
}
