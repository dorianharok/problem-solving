import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> computers = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            computers.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers.get(a).add(b);
            computers.get(b).add(a);
        }

        System.out.println(dfs(1));
    }

    public static int dfs(int n) {
        visited[n] = true;
        int count = 0;

        for(int c : computers.get(n)) {
            if(visited[c]) continue;

            count += 1 + dfs(c);
        }

        return count;
    }
}
