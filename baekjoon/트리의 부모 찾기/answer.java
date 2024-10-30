import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] v;
    static int[] node;
    static List<ArrayList<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        v = new boolean[N+1];
        node = new int[N+1];

        dfs(1, 0);

        for(int i=2; i<=N; i++) {
            System.out.println(node[i]);
        }
    }

    public static void dfs(int n, int prev) {
        v[n] = true;
        ArrayList<Integer> integers = tree.get(n);
        node[n] = prev;

        for(Integer i : integers) {
            if(v[i]) continue;

            dfs(i, n);
        }
    }
}