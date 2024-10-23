import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

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

        int count = 0;
        for(int i=1; i<=N; i++) {
            if(visited[i]) continue;

            dfs(i);
            count++;
        }

        System.out.println(count);
    }

    public static void dfs(int x) {
        visited[x] = true;

        ArrayList<Integer> rel = graph.get(x);
        for(Integer r : rel) {
            if(visited[r]) continue;
            dfs(r);
        }
    }
}