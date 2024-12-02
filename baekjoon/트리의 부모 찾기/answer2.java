import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parents = new int[N+1];
        boolean[] visited = new boolean[N+1];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        int T = N-1;
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nodes = graph.get(cur);

            for(int n : nodes) {
                if(visited[n]) continue;

                visited[n] = true;
                queue.add(n);
                parents[n] = cur;
            }
        }

        for(int i=2; i<=N; i++) {
            System.out.println(parents[i]);
        }
    }
}
