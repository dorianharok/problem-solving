import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        boolean[] visited = new boolean[N + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;

        int answer = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int n : list[cur]) {
                if(visited[n]) continue;
                visited[n] = true;
                q.offer(n);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
