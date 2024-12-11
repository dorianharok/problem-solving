import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int[] leaf;
    static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new List[N];
        for(int i=0; i<N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n == -1) {
                root = i;
                continue;
            }
            tree[n].add(i);
        }

        target = Integer.parseInt(br.readLine());
        if(target == root) {
            System.out.println(0);
            return;
        }

        for(int i=0; i<N; i++) {
            if(tree[i].contains(target)) {
                tree[i].remove(tree[i].indexOf(target));
            }
        }

        leaf = new int[N];
        dfs(root);

        System.out.println(leaf[root]);
    }

    public static void dfs(int n) {
        if(tree[n].isEmpty()) {
            leaf[n] = 1;
            return;
        }

        for(int i : tree[n]) {
            dfs(i);
            leaf[n] += leaf[i];
        }
    }
}
