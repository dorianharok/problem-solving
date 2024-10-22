import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,a,b,m;
    static boolean[] visited;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }
        visited[a] = true;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == b) {
                System.out.println(cur[1]);
                return;
            }
            ArrayList<Integer> rel = list.get(cur[0]);

            for(Integer r : rel) {
                if(visited[r]) continue;

                visited[r] = true;
                q.add(new int[]{r, cur[1] + 1});
            }
        }

        System.out.println(-1);
    }
}