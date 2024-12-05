import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            parents = new int[n+1];
            for(int i=1; i<=n; i++) {
                parents[i] = i;
            }

            while(m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            Set<Integer> set = new HashSet<>();
            for(int i=1; i<=n; i++) {
                if(parents[find(i)] == 0) continue;

                set.add(parents[i]);
            }

            int size = set.size();
            if(size == 0) {
                System.out.printf("Case %d: No trees.\n", testCase);
            } else if(size == 1) {
                System.out.printf("Case %d: There is one tree.\n", testCase);
            } else {
                System.out.printf("Case %d: A forest of %d trees.\n", testCase, size);
            }

            testCase++;
        }
    }

    public static int find(int n) {
        if(parents[n] != n) {
            parents[n] = find(parents[n]);
        }

        return parents[n];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) {
            int min = Math.min(a, b);
            parents[min] = 0;
        }

        if(a < b) {
            parents[b] = find(a);
        } else{
            parents[a] = find(b);
        }
    }
}
