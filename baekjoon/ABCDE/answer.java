import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> rel = new ArrayList<>();
    static boolean[] visited;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            rel.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rel.get(a).add(b);
            rel.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 1);
            if(flag) break;
        }

        System.out.println(flag ? 1 : 0);
    }

    public static void dfs(int n, int depth) {
        if (depth == 5) {
            flag = true;
            return;
        }

        ArrayList<Integer> friends = rel.get(n);
        for (Integer f : friends) {
            if (visited[f]) continue;

            visited[f] = true;
            dfs(f, depth + 1);
            visited[f] = false;
        }
    }
}